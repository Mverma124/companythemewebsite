package in.sp.main.repository;

import in.sp.main.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Custom query methods can be defined here
}
