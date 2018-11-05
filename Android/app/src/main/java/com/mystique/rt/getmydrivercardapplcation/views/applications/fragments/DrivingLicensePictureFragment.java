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
import android.widget.ImageView;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.BuildConfig;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrivingLicensePictureFragment extends Fragment {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1889;


    @BindView(R.id.btn_licensepiccamera)
    Button drivingLicPicButton;

    @BindView(R.id.iv_licensepicview)
    ImageView drivingLicPicImageView;


    BitmapParser mDrivingPicParser;


    public DrivingLicensePictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driving_license_picture, container, false);

        ButterKnife.bind(this, view);

        mDrivingPicParser = new ByteArrayBitmapParser();

        Context context = getActivity();

        PackageManager packageManager = Objects.requireNonNull(context).getPackageManager();

        checkCurrentRememberAllforData();

        // checking if camera exist
        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
        }

        // checking if camera is restricted to wark with the app and ask to change restricted permissions
        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
        }

        if (!checkPermissions(context)){
            showPermissionsAlert(context);

        } else {
            Toast.makeText(getActivity(), "The device a camera is checked.", Toast.LENGTH_SHORT)
                    .show();
        }

        drivingLicPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeDrivingLicPicture();
            }
        });


        return view;
    }

    // TODO waiting for the class
    private void checkCurrentRememberAllforData() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void makeDrivingLicPicture() {
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Objects.requireNonNull(getActivity()).startActivityFromFragment(DrivingLicensePictureFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
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
                        byte[] byteSelfie = mDrivingPicParser.fromBitmap(bmp);

                        //for viewing
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

                    }
                    drivingLicPicImageView.setImageBitmap(bmp);
                }
            }
        }catch(Exception e){
            Toast.makeText(this.getActivity(), e+"Something went wrong", Toast.LENGTH_LONG).show();

        }

    }

    static boolean checkPermissions(Context context) {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void showPermissionsAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Permissions required!")
                .setMessage("Camera needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", (dialog, which) -> openSettings(Objects.requireNonNull(getActivity())))
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
