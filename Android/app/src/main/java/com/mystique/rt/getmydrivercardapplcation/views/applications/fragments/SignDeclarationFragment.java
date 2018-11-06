package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.CompletedApplicationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignDeclarationFragment extends Fragment {

    private RememberAll mRememberAll;

    private Navigator mNavigator;

    @BindView(R.id.button_submit)
    Button mSubmitButton;

    public SignDeclarationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sing_declaration, container, false);
        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();
        setNavigator((Navigator) getActivity());

        return view;
    }

    @OnClick(R.id.button_submit)
    public void goToCompletionActivity() {
        mNavigator.navigateToActivity(CompletedApplicationActivity.class);
    }

    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }
}
