package in.sp.main.entity;

import java.time.LocalDateTime;
import in.sp.main.model.JobOpening;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "apply")  // Specify the table name as 'apply'
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private String gender;

    @Column(name = "about_yourself")
    private String aboutYourself;

    private String skills;

    private String location;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobOpening jobOpening;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "experience_details")
    private String experienceDetails;

    @Column(name = "application_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime applicationDate;

    // New fields
    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;

    @PrePersist
    public void prePersist() {
        if (applicationDate == null) {
            applicationDate = LocalDateTime.now(); // Set current timestamp before saving
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String aboutYourself) {
        this.aboutYourself = aboutYourself;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JobOpening getJobOpening() {
        return jobOpening;
    }

    public void setJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getExperienceDetails() {
        return experienceDetails;
    }

    public void setExperienceDetails(String experienceDetails) {
        this.experienceDetails = experienceDetails;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
