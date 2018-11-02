package com.mystique.springdrivercard.repositories;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlCardApplicationRepository implements CardApplicationRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCardApplicationForm(CardApplicationForm cardApplicationForm) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(cardApplicationForm);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CardApplicationForm> getAllCardApplications() {

        List<CardApplicationForm> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from CardApplicationForm").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public CardApplicationForm getCardApplicationByID(int id) {
        CardApplicationForm result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(CardApplicationForm.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateCardApplication(int id, CardApplicationForm cardApplicationForm) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            CardApplicationForm cardFormToChange = session.get(CardApplicationForm.class, id);
            cardFormToChange.setStatus(cardApplicationForm.getStatus());
            cardFormToChange.setDetails(cardApplicationForm.getDetails());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public Driver getDriverByID(int id) {
        Driver result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Driver.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void updateDriver(int id, Driver driver) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Driver driverFormToChange = session.get(Driver.class, id);

            // field names should be changed in Driver, according to DB
            driverFormToChange.setFirstName(driver.getFirstName());
            driverFormToChange.setLastName(driver.getLastName());
            driverFormToChange.setAddress(driver.getAddress());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Override
    public void addDriver(Driver driver) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Override
    public Picture getPictureByID(int id) {
        Picture result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Picture.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void addNewPicture(Picture picture) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(picture);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePicture(int id, Picture picture) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Picture pictureToChange = session.get(Picture.class, id);
            pictureToChange.setPicture(picture.getPicture());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }
}
