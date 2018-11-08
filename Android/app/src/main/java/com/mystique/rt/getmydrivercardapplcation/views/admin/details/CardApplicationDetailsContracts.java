package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import android.content.Context;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

public interface CardApplicationDetailsContracts {
    interface View {
        void showCardApplicationFormDetails(CardApplicationForm form);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

        void showMessageApplicationStatusChange();

    }

    interface Presenter {
        void subscribe(View view);

        void loadCardApplicationForm();

        void updateCardApplicationForm(String item);

        void sendMail(Context context, String email, String status, String office);

        //do we need this?
        void setCardApplicationFormId(int id);
    }
}
