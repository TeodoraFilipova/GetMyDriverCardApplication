package com.mystique.springdrivercard.services.cardApplicationFormService;

import com.mystique.springdrivercard.models.CardApplicationForm;

import java.util.List;

public interface CardApplicationService {
    void addCardApplicationForm(CardApplicationForm cardApplicationForm);

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    void updateCardApplication(int id, CardApplicationForm cardApplicationForm);
}
