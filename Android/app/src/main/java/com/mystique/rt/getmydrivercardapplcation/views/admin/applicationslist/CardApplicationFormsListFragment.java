package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;


import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.SetDate;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardApplicationFormsListFragment extends Fragment
        implements CardApplicationFormsListContracts.View, CardApplicationFormsListAdapter.OnProductClickListener,
        FocusListener{

    private CardApplicationFormsListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_id_filter_search)
    EditText mIDSearchFilterText;

    @BindView(R.id.et_name_filter_search)
    EditText mNameSearchFilterText;

    @BindView(R.id.et_submission_filter_search)
    EditText mSubmissionSearchFilterText;

    @BindView(R.id.et_status_filter_search)
    EditText mStatusSearchFilterText;

    @BindView(R.id.btn_searchclean)
    Button mSearchCliearButton;

    @BindView(R.id.lv_cardappforms)
    RecyclerView mCardAppFormsListView;

    @Inject
    CardApplicationFormsListAdapter mCardAppFormsAdapter;

    private CardApplicationFormsListContracts.Presenter mPresenter;
    private GridLayoutManager mCardAppFormsViewLayoutManager;
    SetDate fromDate;

    @Inject
    public CardApplicationFormsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_application_forms_list, container, false);

        ButterKnife.bind(this, view);

        fromDate = new SetDate(mSubmissionSearchFilterText, getContext(), this);

        mCardAppFormsAdapter.setOnProductClickListener(this);
        mCardAppFormsListView.setAdapter(mCardAppFormsAdapter);

        mCardAppFormsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mCardAppFormsListView.setLayoutManager(mCardAppFormsViewLayoutManager);

        mSearchCliearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadCardApplicationsForms();
            }
        });

        return view;
    }

    void setNavigator(CardApplicationFormsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadCardApplicationsForms();
    }

    @Override
    public void onClick(CardApplicationForm form) {
        mPresenter.selectCardApplicationForm(form);
    }

    @Override
    public void setPresenter(CardApplicationFormsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCardApplications(List<CardApplicationForm> cardApplicationForms) {
        mCardAppFormsAdapter.clear();
        mCardAppFormsAdapter.addAll(cardApplicationForms);
        mCardAppFormsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyCardApplicationsList() {
        mCardAppFormsAdapter.clear();
        mCardAppFormsAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"No card applications available to show!", Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mCardAppFormsListView.setVisibility(View.GONE);
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mCardAppFormsListView.setVisibility(View.VISIBLE);
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void showCardApplicationsDetails(CardApplicationForm form) {
        mNavigator.navigateWith(form);
    }

    @OnTextChanged(R.id.et_id_filter_search)
    public void onIDTextChanged() {
        String pattern = mIDSearchFilterText.getText().toString();
        mPresenter.filterCardApplicationFormsByPersonalNumber(pattern);
    }

    @OnTextChanged(R.id.et_name_filter_search)
    public void onNameTextChanged() {
        String pattern = mNameSearchFilterText.getText().toString();
        mPresenter.filterCardApplicationFormsByName(pattern);
    }

    @OnTextChanged(R.id.et_submission_filter_search)
    public void onSubmissionTextChanged() {
        String pattern = fromDate.toString();
        mPresenter.filterCardApplicationFormsBySubmissionDate(pattern);
    }

    @OnTextChanged(R.id.et_status_filter_search)
    public void onStatusTextChanged() {
        String pattern = mStatusSearchFilterText.getText().toString();
        mPresenter.filterCardApplicationFormsByStatus(pattern);
    }

    @Override
    public void saveDateToObject() {

    }
}
