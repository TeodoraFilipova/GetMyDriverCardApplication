package com.mystique.springdrivercard.services.cardApplicationFormService;

import com.mystique.springdrivercard.models.CardApplicationForm;

import java.util.List;

public interface CardApplicationService {
    CardApplicationForm addCardApplicationForm(CardApplicationForm cardApplicationForm);

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    CardApplicationForm updateCardApplication(int id, CardApplicationForm cardApplicationForm);
}
