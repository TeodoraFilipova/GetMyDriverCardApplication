package com.mystique.springdrivercard.services.cardApplicationFormService;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardApplicationServiceImpl implements CardApplicationService {

    private CardApplicationRepository repository;

    @Autowired
    public CardApplicationServiceImpl(CardApplicationRepository cardApplicationRepository) {
        this.repository = cardApplicationRepository;
    }

    @Override
    public void addCardApplicationForm(CardApplicationForm cardApplicationForm) {
        repository.addCardApplicationForm(cardApplicationForm);
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
    public void updateCardApplication(int id, CardApplicationForm cardApplicationForm) {
        repository.updateCardApplication(id, cardApplicationForm);
    }
}
