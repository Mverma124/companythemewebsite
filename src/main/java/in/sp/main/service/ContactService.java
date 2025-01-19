package in.sp.main.service;

import in.sp.main.entity.Contact;
import in.sp.main.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    public void saveContact(Contact contact) {
        logger.info("Saving contact: {}", contact);
        contactRepository.save(contact);
        logger.info("Contact saved successfully.");
    }
}
