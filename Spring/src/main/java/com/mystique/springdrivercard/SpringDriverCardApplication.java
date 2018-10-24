package com.mystique.springdrivercard;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.models.User;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDriverCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDriverCardApplication.class, args);
    }


    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CardApplicationForm.class)
                .addAnnotatedClass(Driver.class)
                .addAnnotatedClass(Picture.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

}
