package com.mystique.springdrivercard.services.cardApplicationFormService;

import com.mystique.springdrivercard.models.CardApplicationForm;

import java.util.List;

/**
 * <h1>CardApplicationFormService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service of CardApplicationForm(reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface CardApplicationService {
    CardApplicationForm addCardApplicationForm(CardApplicationForm cardApplicationForm);

    List<CardApplicationForm> getAllCardApplications();

    CardApplicationForm getCardApplicationByID(int id);

    CardApplicationForm updateCardApplication(int id, CardApplicationForm cardApplicationForm);
}
