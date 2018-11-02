package com.mystique.rt.getmydrivercardapplcation.services;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HttpCardApplicationFormService implements CardApplicationFormService {
    private final CardApplicationFormRepository mCardApplicationFormRepository;
    private final Validator<CardApplicationForm> mCardApplicationFormValidator;

    public HttpCardApplicationFormService(CardApplicationFormRepository cardApplicationFormRepository,
            Validator<CardApplicationForm> cardApplicationFormValidator) {
        mCardApplicationFormRepository = cardApplicationFormRepository;
        mCardApplicationFormValidator = cardApplicationFormValidator;
    }


    @Override
    public List<CardApplicationForm> getAllForms() throws IOException {
        return mCardApplicationFormRepository.getAll();
    }

    @Override
    public CardApplicationForm addForm(CardApplicationForm applicationForm) throws IOException {
        if (!mCardApplicationFormValidator.isValid(applicationForm)) {
            throw new IllegalArgumentException("Application form details are invalid");
        }

        return mCardApplicationFormRepository.add(applicationForm);
    }

    @Override
    public CardApplicationForm getFormById(int id) throws IOException {
        return mCardApplicationFormRepository.getById(id);
    }

    @Override
    public CardApplicationForm updateFormById(int id, CardApplicationForm applicationForm) throws IOException {
        if (!mCardApplicationFormValidator.isValid(applicationForm)) {
            throw new IllegalArgumentException("Application form details are invalid");
        }
        return mCardApplicationFormRepository.updateById(id, applicationForm);
    }

    @Override
    public CardApplicationForm getByStatusCheckCode(final String statusCheckCode) throws IOException {
        List<CardApplicationForm> all = getAll();
        for (CardApplicationForm app : all) {
            if (app.getStatusCheckCode().equals(statusCheckCode)) {
                return app;
            }
        }
        return null;
    }

    @Override
    public List<CardApplicationForm> getFilteredFormsByID(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();

        List<CardApplicationForm> forms = getAllForms();
        List<CardApplicationForm> filteredforms = new ArrayList<>();
        for (int i = 0; i < forms.size() ; i++) {
            String form = String.valueOf(forms.get(i).getCardApplicationFormId());
            form.contains(patternToLower); // not right declaration
            filteredforms.add(forms.get(i));
        }
        return filteredforms;
    }

    @Override
    public List<CardApplicationForm> getFilteredFormsByName(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();
        List<CardApplicationForm> forms = getAllForms();
        List<CardApplicationForm> filteredforms = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
           if (forms.get(i).getDriver().getFirstName().toLowerCase().contains(patternToLower) ||
                   forms.get(i).getDriver().getLastName().toLowerCase().contains(patternToLower)){
               filteredforms.add(forms.get(i));
           }
        }
        return filteredforms;
    }

    @Override
    public List<CardApplicationForm> getFilteredProductsBySubbmisitonDate(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();
        List<CardApplicationForm> forms = getAllForms();
        List<CardApplicationForm> filteredforms = new ArrayList<>();

        // is date to string right declaration
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).getDateOfSubmission().toString().contains(patternToLower)){
                filteredforms.add(forms.get(i));
            }
        }
        return filteredforms;
    }

    @Override
    public List<CardApplicationForm> getFilteredProductsByStatus(String status) throws Exception {
        String patternToLower = status.toLowerCase();
        List<CardApplicationForm> forms = getAllForms();
        List<CardApplicationForm> filteredforms = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).getStatus().toLowerCase().contains(patternToLower) ){
                filteredforms.add(forms.get(i));
            }
        }
        return filteredforms;
    }
}
