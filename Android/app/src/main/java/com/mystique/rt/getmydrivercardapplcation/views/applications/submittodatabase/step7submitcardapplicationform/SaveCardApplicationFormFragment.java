package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveCardApplicationFormFragment extends Fragment implements SaveCardApplicationFormContracts.View {
    private RememberAll mRememberAll;
    SaveCardApplicationFormContracts.Presenter mPresenter;

    private int mNextCardApplicationFormId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveCardApplicationFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_card_application_form, container, false);

        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();

        showLoading();
        mPresenter.getLastUpdatedCardApplicationForm();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }


    @Override
    public void setPresenter(SaveCardApplicationFormContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable error) {
        mMessageTextView.setText(error.getMessage());
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void setNextCardApplicationFormId(CardApplicationForm lastUpdatedCardApplicationForm) {
        mNextCardApplicationFormId = lastUpdatedCardApplicationForm.getCardApplicationFormId() + 1;
        mPresenter.updateLastCardApplicationForm(lastUpdatedCardApplicationForm);
    }

    @Override
    public void updateRememberAll() {
        mRememberAll.getCardApplicationForm().setCardApplicationFormId(mNextCardApplicationFormId);
        mRememberAll.getCardApplicationForm().setLastUpdated(Constants.LAST_UPDATED_TRUE);
        mPresenter.saveCardApplicationForm(mRememberAll.getCardApplicationForm());
    }

    @Override
    public void sendEmail() {
        hideLoading();
        mRememberAll.resetRememberAll();

        String email = mRememberAll.getCardApplicationForm().getDriver().getEmail().trim();
        String subject = Constants.EMAIL_SUBJECT;
        String message = Constants.EMAIL_MESSAGE;

        SendMail sm = new SendMail(getContext(), email, subject, message);

        sm.execute();

        mMessageTextView.setText(R.string.application_successful);
    }

}
