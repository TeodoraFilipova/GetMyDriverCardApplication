

package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.util.Date;
import java.util.List;

/**
 * <h1>CardApplicationFormListContracts</h1>
 *
 * <b>Description: </b> This interface defines the interfaces which are used by the
 * fragment, presenter, activity trio in order to implement the MVP pattern and handle
 * navigation.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface CardApplicationFormsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCardApplications(List<CardApplicationForm> cardApplicationForms);

        void showEmptyCardApplicationsList();

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showCardApplicationsDetails(CardApplicationForm cardApplicationForm);
    }

    interface Presenter {
        void subscribe(View view);

        void loadCardApplicationsForms();

        void filterCardApplicationFormsByPersonalNumber(String pattern);

        void filterCardApplicationFormsByName(String pattern);

        void filterCardApplicationFormsBySubmissionDate(String pattern);

        void filterCardApplicationFormsByStatus(String pattern);

        void selectCardApplicationForm(CardApplicationForm cardApplicationForm);
    }

    interface Navigator {
        void navigateWith(CardApplicationForm cardApplicationForm);
    }

}
