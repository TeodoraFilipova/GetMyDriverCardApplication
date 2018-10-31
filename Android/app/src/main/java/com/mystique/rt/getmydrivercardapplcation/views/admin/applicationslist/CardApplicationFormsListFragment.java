package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;


import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardApplicationFormsListFragment extends Fragment
        implements CardApplicationFormsListContracts.View, CardApplicationFormsListAdapter.OnProductClickListener{

    private CardApplicationFormsListContracts.Navigator mNavigator;

    @BindView(R.id.loading_bar)
    ProgressBar mLoadingBar;

    @BindView(R.id.et_filter_search)
    EditText mSearchFilterText;

    @BindView(R.id.lv_cardappforms)
    RecyclerView mCardAppFormsListView;

    @Inject
    CardApplicationFormsListAdapter mCardAppFormsAdapter;

    private CardApplicationFormsListContracts.Presenter mPresenter;
    private GridLayoutManager mCardAppFormsViewLayoutManager;

    @Inject
    public CardApplicationFormsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_application_forms, container, false);

        ButterKnife.bind(this, view);

        mCardAppFormsAdapter.setOnProductClickListener(this);
        mCardAppFormsListView.setAdapter(mCardAppFormsAdapter);

        mCardAppFormsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mCardAppFormsListView.setLayoutManager(mCardAppFormsViewLayoutManager);

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

    // make filter by ...
    @OnTextChanged(R.id.et_filter_search)
    public void onTextChanged() {
        String pattern = mSearchFilterText.getText().toString();
        mPresenter.filterCardApplicationForms(pattern);
    }
}
