package org.example.contact.manager;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact save(Contact contact);
    Optional<Contact> findById(long contactId);
    void deleteById(long contactId);
    List<Contact> findAll();

    @Transactional
    @Modifying
    @Query("update Contact c set c.phone = :phone where c.id = :contactId")
    void updatePhone(@Param("contactId") long contactId, @Param("phone") String phoneNumber);

    @Transactional
    @Modifying
    @Query("update Contact c set c.email = :email where c.id = :contactId")
    void updateEmail(@Param("contactId") long contactId, @Param("email") String email);
}
