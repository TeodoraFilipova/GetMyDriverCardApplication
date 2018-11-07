package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;
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


    @BindView(R.id.sp_signature_pad)
    SignaturePad mSignaturePad;

    @BindView(R.id.chb_declaration)
    CheckBox mAgreamentCheckBox;

    @BindView(R.id.btn_clear_pad)
    Button mClearPadButton;

    @BindView(R.id.btn_submit)
    Button mSubmitButton;

    private Bitmap mSignImage;

    private BitmapParser mSignParser;

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
        mSignParser = new ByteArrayBitmapParser();
        setNavigator((Navigator) getActivity());

        mSubmitButton.setEnabled(false);
        mClearPadButton.setEnabled(false);

        mAgreamentCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSignaturePad.isEmpty() || !mAgreamentCheckBox.isChecked()) {
                    mSubmitButton.setEnabled(false);
                } else {
                    mClearPadButton.setEnabled(true);
                    mSubmitButton.setEnabled(true);
                }

            }
        });

        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

            @Override
            public void onStartSigning() {
                mClearPadButton.setEnabled(false);
            }

            @Override
            public void onSigned() {
                if (mAgreamentCheckBox.isChecked()) {
                    mClearPadButton.setEnabled(true);
                    mSubmitButton.setEnabled(true);
                } else {
                    Toast.makeText(getContext(), "Check the declaration agreement!", Toast.LENGTH_LONG)
                            .show();
                }

            }

            @Override
            public void onClear() {
                mSubmitButton.setEnabled(false);
                mClearPadButton.setEnabled(false);
            }
        });


        mClearPadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearOnClick();
            }
        });


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCompletionActivity(); // just for not empty!
            }
        });

        return view;
    }

    @OnClick(R.id.btn_clear_pad)
    public void clearOnClick() {
        mSignaturePad.clear();
    }

    @OnClick(R.id.btn_submit)
    public void goToCompletionActivity() {
        mSignImage = mSignaturePad.getSignatureBitmap();
        byte[] byteSign = mSignParser.fromBitmap(mSignImage);
        mRememberAll.setSignaturePicture(byteSign);
        mNavigator.navigateToActivity(CompletedApplicationActivity.class);
    }

    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }
}
