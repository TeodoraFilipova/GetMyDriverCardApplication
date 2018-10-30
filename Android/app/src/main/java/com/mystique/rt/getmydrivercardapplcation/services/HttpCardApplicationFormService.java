package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import java.io.IOException;
import java.util.List;

public class HttpCardApplicationFormService implements CardApplicationFormService {
    private final CardApplicationFormRepository mCardApplicationFormRepository;
    private final Validator<CardApplicationForm> mCardApplicationFormValidator;

    public HttpCardApplicationFormService(CardApplicationFormRepository cardApplicationFormRepository,
            Validator<CardApplicationForm> cardApplicationFormValidator) {
        mCardApplicationFormRepository = cardApplicationFormRepository;
        mCardApplicationFormValidator = cardApplicationFormValidator;
    }


    @Override
    public List<CardApplicationForm> getAll() throws IOException {
        return mCardApplicationFormRepository.getAll();
    }

    @Override
    public CardApplicationForm add(CardApplicationForm applicationForm) throws IOException {
        if (!mCardApplicationFormValidator.isValid(applicationForm)) {
            throw new IllegalArgumentException("Application form details are invalid");
        }

        return mCardApplicationFormRepository.add(applicationForm);
    }

    @Override
    public CardApplicationForm getById(int id) throws IOException {
        return mCardApplicationFormRepository.getById(id);
    }

    @Override
    public CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException {
        if (!mCardApplicationFormValidator.isValid(applicationForm)) {
            throw new IllegalArgumentException("Application form details are invalid");
        }
        return mCardApplicationFormRepository.updateById(id, applicationForm);
    }
}
