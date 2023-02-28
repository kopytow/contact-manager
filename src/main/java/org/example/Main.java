package org.example;

import org.example.contact.manager.ContactDao;
import org.example.contact.manager.ContactConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(ContactConfiguration.class);
        var contactDao = applicationContext.getBean(ContactDao.class);
        var contact = contactDao.getContact(1L);
        System.out.println(contact);
    }
}