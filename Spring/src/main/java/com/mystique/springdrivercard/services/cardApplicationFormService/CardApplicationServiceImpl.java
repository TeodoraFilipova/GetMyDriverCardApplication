package com.mystique.springdrivercard.services.cardApplicationFormService;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>CardApplicationServiceImpl class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * service of CardApplicationForm (reflecting the business requirements of the
 * application).
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Service
public class CardApplicationServiceImpl implements CardApplicationService {

    private CardApplicationRepository repository;

    @Autowired
    public CardApplicationServiceImpl(CardApplicationRepository cardApplicationRepository) {
        this.repository = cardApplicationRepository;
    }

    @Override
    public CardApplicationForm addCardApplicationForm(CardApplicationForm cardApplicationForm) {
        return repository.addCardApplicationForm(cardApplicationForm);
    }

    @Override
    public List<CardApplicationForm> getAllCardApplications() {
        return repository.getAllCardApplications();
    }

    @Override
    public CardApplicationForm getCardApplicationByID(int id) {
        return repository.getCardApplicationByID(id);
    }

    @Override
    public CardApplicationForm updateCardApplication(int id, CardApplicationForm cardApplicationForm) {
        return repository.updateCardApplication(id, cardApplicationForm);
    }
}
