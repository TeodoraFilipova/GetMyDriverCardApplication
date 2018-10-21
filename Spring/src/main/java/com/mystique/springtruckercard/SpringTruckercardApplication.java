package com.mystique.springtruckercard;

import com.mystique.springtruckercard.models.CardApplicationForm;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringTruckercardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTruckercardApplication.class, args);
    }


    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CardApplicationForm.class)
                .buildSessionFactory();
    }

}
