package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import android.content.Context;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;

/**
 * <h1>CardApplicationDetailsContracts</h1>
 *
 * <b>Description: </b> This interface defines the interfaces which are used by the
 * fragment, presenter, activity trio in order to implement the MVP pattern.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface CardApplicationDetailsContracts {
    interface View {
        void showCardApplicationFormDetails(CardApplicationForm form);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading(Driver driver);

        void showMessageApplicationStatusChange();


    }

    interface Presenter {
        void subscribe(View view);

        void loadCardApplicationForm();

        void updateCardApplicationForm(String item);

        void sendMail(Context context, String email, String status, String office);

        //do we need this?
        void setCardApplicationFormId(int id);

        void updateDriver(Driver updatedDriver);
    }
}
