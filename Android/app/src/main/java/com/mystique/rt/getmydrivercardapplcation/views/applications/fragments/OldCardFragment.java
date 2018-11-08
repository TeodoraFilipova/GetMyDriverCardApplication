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
import com.mystique.rt.getmydrivercardapplcation.apputils.SetDate;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;
import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OldCardFragment extends Fragment implements FocusListener {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1890;

    @BindView(R.id.et_oldcard_number)
    EditText mOldCardNumberEditText;

    @BindView(R.id.et_oldcard_authority)
    EditText mOldCardAuthorityEditText;

    @BindView(R.id.et_oldcard_country)
    EditText mOldCardCountryEditText;

    @BindView(R.id.et_oldcard_date_of_expiry)
    EditText mOldCardDateOfExpiryEditText;

    @BindView(R.id.btn_oldcard_piccamera)
    Button mOldCardPicButton;

    @BindView(R.id.iv_picture)
    ImageView mOldCardPicImageView;

    private RememberAll mRememberAll;
    BitmapParser mOldCardPicParser;


    public OldCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_old_card, container, false);

        ButterKnife.bind(this, view);

        mOldCardPicParser = new ByteArrayBitmapParser();
        mRememberAll = RememberAll.getInstance();

        SetDate setDate = new SetDate(mOldCardDateOfExpiryEditText, getContext(), this);

        Context context = getActivity();

        PackageManager packageManager = Objects.requireNonNull(context).getPackageManager();

        checkRememberAllForCurrentData();

        // checking if camera exist
        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
        }

        // checking if camera is restricted to wark with the app and ask to change restricted permissions
        if (!checkPermissions(context)){
            showPermissionsAlert(context);

        } else {
            Toast.makeText(getActivity(), "The device a camera is checked.", Toast.LENGTH_SHORT)
                    .show();
        }

        mOldCardPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeOldCardPic();
            }
        });

        mOldCardNumberEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setOldCardNumber(mOldCardNumberEditText.getText().toString());
            }
        });

        mOldCardCountryEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setOldCardCountry(mOldCardCountryEditText.getText().toString());
            }
        });

        mOldCardAuthorityEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setOldCardAuthority(mOldCardAuthorityEditText.getText().toString());
            }
        });

        return view;
    }

    private void checkRememberAllForCurrentData() {
        if (mRememberAll.getOldCardPic().getPicture() != null) {
            Bitmap savedOldCardPic = mOldCardPicParser.toBitmap(mRememberAll.getOldCardPic().getPicture());
            mOldCardPicImageView.setImageBitmap(savedOldCardPic);
        }

        if (mRememberAll.getCardApplicationForm().getOldCardDateOfExpiry() != null) {
            DateFormat df = new SimpleDateFormat(getString(R.string.date_format));
            Date dateOfExpiry = mRememberAll.getCardApplicationForm().getOldCardDateOfExpiry();
            String dateOfExpiryString = df.format(dateOfExpiry);
            mOldCardDateOfExpiryEditText.setText(dateOfExpiryString);
        }

        if (mRememberAll.getCardApplicationForm().getOldCardAuthority() != null) {
            mOldCardAuthorityEditText.setText(mRememberAll.getCardApplicationForm().getOldCardAuthority());
        }

        if (mRememberAll.getCardApplicationForm().getOldCardCountry() != null) {
            mOldCardCountryEditText.setText(mRememberAll.getCardApplicationForm().getOldCardCountry());
        }

        if (mRememberAll.getCardApplicationForm().getOldCardNumber() != null) {
            mOldCardNumberEditText.setText(mRememberAll.getCardApplicationForm().getOldCardNumber());
        }
    }


    public void makeOldCardPic(){
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Objects.requireNonNull(getActivity()).startActivityFromFragment(OldCardFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
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
                        byte[] byteSelfie = mOldCardPicParser.fromBitmap(bmp);
                        mRememberAll.setOldCardPic(byteSelfie);

                        //for viewing
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    }

                    mOldCardPicImageView.setImageBitmap(bmp);
                }
            }
        }catch(Exception e){
            Toast.makeText(this.getActivity(), e+"Getting picture from camera fails. Make picture again!", Toast.LENGTH_LONG).show();

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


    @Override
    public void saveDateToObject() {
        DateFormat df = new SimpleDateFormat(getString(R.string.date_format));
        Date dateOfExpiry = null;
        try {
            dateOfExpiry = df.parse(mOldCardDateOfExpiryEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mRememberAll.setDateOfBirth(dateOfExpiry);
    }
}
