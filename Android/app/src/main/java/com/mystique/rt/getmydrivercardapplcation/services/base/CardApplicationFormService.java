package com.mystique.rt.getmydrivercardapplcation.services.base;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface CardApplicationFormService {

    List<CardApplicationForm> getAllForms() throws IOException;

    CardApplicationForm addForm(CardApplicationForm applicationForm) throws IOException;

    CardApplicationForm getFormById(int id) throws IOException;

    CardApplicationForm updateFormById(int id, CardApplicationForm applicationForm) throws IOException;

    List<CardApplicationForm> getFilteredFormsByID(String pattern) throws Exception;

    List<CardApplicationForm> getFilteredFormsByName(String pattern) throws Exception;

    CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException;

    CardApplicationForm getByStatusCheckCode(String statusCheckCode) throws IOException;
    List<CardApplicationForm> getFilteredProductsBySubbmisitonDate(String patterne) throws Exception;

    List<CardApplicationForm> getFilteredProductsByStatus(String status) throws Exception;
}
