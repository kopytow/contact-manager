package org.example;

import org.example.contact.manager.Contact;
import org.example.contact.manager.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {


    private static final List<Contact> CONTACTS = List.of(
            new Contact(1000L, "Ivan", "Ivanov", "iivanov@gmail.com", "1234567"),
            new Contact(2000L, "Maria", "Ivanova", "mivanova@gmail.com", "7654321")
    );

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(ContactRepository contactRepository) {
        return args -> {
            contactRepository.deleteAllInBatch();

            var contacts = contactRepository.saveAll(CONTACTS);
            System.out.println("PERSISTED CONTACTS: " + contacts);

            List<Contact> adults = contactRepository.findAll();
            System.out.println(adults);
        };
    }

}