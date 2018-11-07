package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

public interface CardApplicationDetailsContracts {
    interface View {
        void showCardApplicationFormDetails(CardApplicationForm form);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();

    }

    interface Presenter {
        void subscribe(View view);

        void loadCardApplicationForm();

        void updateCardApplicationForm(String item);

        void sendMail(String item);

        //do we need this?
        void setCardApplicationFormId(int id);
    }
}
