package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.util.List;

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

        void filterCardApplicationForms(String pattern);

        void selectCardApplicationForm(CardApplicationForm cardApplicationForm);
    }

    interface Navigator {
        void navigateWith(CardApplicationForm cardApplicationForm);
    }

}
