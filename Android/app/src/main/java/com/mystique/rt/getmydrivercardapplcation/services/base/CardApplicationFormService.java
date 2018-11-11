/**
 * <h1>CardApplicationFormService interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for the
 * service layer (reflecting the business requirements of the
 * application) of CardApplicationForm.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

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

    List<CardApplicationForm> getFilteredFormsByPersonalNumber(String pattern) throws Exception;

    List<CardApplicationForm> getFilteredFormsByName(String pattern) throws Exception;

    CardApplicationForm getFormByStatusCheckCode(String statusCheckCode) throws IOException;

    List<CardApplicationForm> getFilteredFormsBySubmissionDate(String pattern) throws Exception;

    List<CardApplicationForm> getFilteredFormsByStatus(String status) throws Exception;

    CardApplicationForm getLastUpdatedForm() throws IOException;
}
