package org.example.contact.manager;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        var configuration = new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Contact.class)
                .configure();
        return configuration.buildSessionFactory();
    }

    @Bean
    public ContactDao contactDao(SessionFactory sessionFactory) {
        return new HibernateContactDao(sessionFactory);
    }
}
