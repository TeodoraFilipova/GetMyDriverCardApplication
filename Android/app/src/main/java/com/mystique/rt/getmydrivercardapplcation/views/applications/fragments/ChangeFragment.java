package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.BuildConfig;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangeFragment extends Fragment {

    private RememberAll mRememberAll;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1891;

    @BindView(R.id.et_new_firstname)
    EditText mNewFirstNameEditText;

    @BindView(R.id.et_new_lastname)
    EditText mNewLastNameEditText;

    @BindView(R.id.et_new_address)
    EditText mNewAddressEditText;

    @BindView(R.id.btn_newselfie_camera)
    Button newSelfieButton;


    @BindView(R.id.iv_newselfie_picture)
    ImageView newSelfieImageView;


    BitmapParser mChangeParser;


    public ChangeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change, container, false);

        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();

        mChangeParser = new ByteArrayBitmapParser();

        Context context = getActivity();

        PackageManager packageManager = Objects.requireNonNull(context).getPackageManager();

        mNewFirstNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setNewFirstName(mNewFirstNameEditText.getText().toString());
            }
        });

        mNewLastNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setNewLastName(mNewLastNameEditText.getText().toString());
            }
        });

        mNewAddressEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setNewAddress(mNewAddressEditText.getText().toString());
            }
        });

        checkRememberAllForCurrentData();

        // checking if camera exist
        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
        }

        // checking if camera is restricted to work with the app and ask to change restricted permissions
        if (!checkPermissions(context)){
            showPermissionsAlert(context);

        } else {
            Toast.makeText(getActivity(), "The device camera is checked.", Toast.LENGTH_SHORT)
                    .show();
        }

        newSelfieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNewSelfiePic();
            }
        });

        return view;
    }

    private void checkRememberAllForCurrentData() {
        if (mRememberAll.getNewSelfiePic().getPicture() != null) {
            Bitmap savedSelfie = mChangeParser.toBitmap(mRememberAll.getNewSelfiePic().getPicture());
            newSelfieImageView.setImageBitmap(savedSelfie);
        }

        if (mRememberAll.getCardApplicationForm().getNewAddress() != null) {
            mNewAddressEditText.setText(mRememberAll.getCardApplicationForm().getNewAddress());
        }

        if (mRememberAll.getCardApplicationForm().getNewFirstName() != null) {
            mNewFirstNameEditText.setText(mRememberAll.getCardApplicationForm().getNewFirstName());
        }

        if (mRememberAll.getCardApplicationForm().getNewLastName() != null) {
            mNewLastNameEditText.setText(mRememberAll.getCardApplicationForm().getNewLastName());
        }
    }


    public void makeNewSelfiePic(){
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Objects.requireNonNull(getActivity()).startActivityFromFragment(ChangeFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK && data != null) {

                    Bitmap bmp = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    if (bmp != null) {

                        //for saving in database
                        byte[] byteSelfie = mChangeParser.fromBitmap(bmp);
                        mRememberAll.setNewSelfiePicture(byteSelfie);

                        //for viewing
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    }

                    newSelfieImageView.setImageBitmap(bmp);
                }
            }
        }catch(Exception e){
            Toast.makeText(this.getActivity(), e+"Getting picture from camera failed. Take picture again!", Toast.LENGTH_LONG).show();

        }
    }

    static boolean checkPermissions(Context context) {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void showPermissionsAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Permissions required!")
                .setMessage("Camera needs a few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GO TO SETTINGS", (dialog, which) -> openSettings(Objects.requireNonNull(getActivity())))
                .setNegativeButton("CANCEL", (dialog, which) -> {
                }).show();
    }

    static void openSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID, null));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
