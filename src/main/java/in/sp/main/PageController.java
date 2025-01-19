package in.sp.main;

import in.sp.main.entity.Contact;
import in.sp.main.entity.JobApplication;
import in.sp.main.model.JobOpening;
import in.sp.main.repository.ContactRepository;
import in.sp.main.repository.JobApplicationRepository;
import in.sp.main.repository.JobOpeningRepository;
import in.sp.main.service.ContactService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;

@Controller
public class PageController {
	
	 @Autowired
	 private ContactRepository contactRepository;

    @Autowired
    private JobOpeningRepository jobOpeningRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private ContactService contactService;

    // Display career page with job openings
    @GetMapping("/careers")
    public String careers(Model model) {
        model.addAttribute("jobOpenings", jobOpeningRepository.findAll());
        return "careers";
    }

    // Show contact page
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    // Handle contact form submission
    @PostMapping("/send-email")
    public String sendEmail(@ModelAttribute("contact") Contact contact, Model model) {
        contactService.saveContact(contact); // Save contact form data
        model.addAttribute("message", "Your message has been sent successfully!");
        return "index"; // Redirect to index with success message
    }

    // Show index page
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Show about page
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // Show privacy page
    @GetMapping("/privacy")
    public String privacy() {
        return "privacy";
    }
    
    //show admin-panel page
    
    @GetMapping("/admin-panel")
    public String adminPanel(Model model) {
        // Fetch data from the database
        List<Contact> contacts = contactRepository.findAll();
        List<JobApplication> applies = jobApplicationRepository.findAll(); // Fetch all job applications

        // Add data to the model
        model.addAttribute("contacts", contacts);
        model.addAttribute("jobOpenings", jobOpeningRepository.findAll());
        model.addAttribute("applies", applies); // Add the applies data to the model

        return "admin-panel";
    }
    
    

    // Show terms and conditions page
    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }

    @GetMapping("/apply")
    public String showApplyPage(Model model) {
        model.addAttribute("jobOpenings", jobOpeningRepository.findAll());
        model.addAttribute("jobApplication", new JobApplication());
        model.addAttribute("applicationSubmitted", false); // Ensure the form is visible initially
        return "apply";
    }

    // Handle job application submission
    @PostMapping("/apply")
    public String submitApplication(@ModelAttribute("jobApplication") @Valid JobApplication jobApplication,
                                    BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("jobOpenings", jobOpeningRepository.findAll());
            return "apply";
        }

        // Save job application
        jobApplicationRepository.save(jobApplication);

        // Set the flag to hide the form and show the success message
        model.addAttribute("applicationSubmitted", true);
        model.addAttribute("jobApplication", new JobApplication()); // Reset the form
        return "apply"; // Redirect back to the apply page with the success message
    }
}

