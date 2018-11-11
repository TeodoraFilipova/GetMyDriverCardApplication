package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

public interface SaveCardApplicationFormContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showError(Throwable error);

        void showLoading();

        void hideLoading();

        void setNextCardApplicationFormId(CardApplicationForm lastUpdatedCardApplicationForm);

        void updateRememberAll();

        void sendEmail();
    }

    interface Presenter {
        void subscribe(View view);

        void saveCardApplicationForm(CardApplicationForm cardApplicationForm);

        void getLastUpdatedCardApplicationForm();

        void updateLastCardApplicationForm(CardApplicationForm cardApplicationForm);
    }

    interface Navigator {
        void navigateBackToMain();
    }
}
