package com.mystique.springtruckercard.repositories;

import com.mystique.springtruckercard.models.CardApplicationForm;
import com.mystique.springtruckercard.models.Picture;
import com.mystique.springtruckercard.models.TrackerForm;

import java.util.List;

public interface CardApplicationRepository {

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationsByID(int id);

    void updateCardApplicaton(int id, CardApplicationForm cardApplicationForm);

    // it we need tracker from CardAppForm
    TrackerForm getTrackerByID(int id);

    void updateTrackerForm(int id, TrackerForm tracker);

    void addNewTrackerDetails(TrackerForm tracker);

    // it we need picture from CardAppForm
    Picture getPictureByID(int id);

    void addNewPicture(Picture picture);


}
