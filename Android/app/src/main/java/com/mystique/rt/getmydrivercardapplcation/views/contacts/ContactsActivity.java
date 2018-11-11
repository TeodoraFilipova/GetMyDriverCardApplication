/**
 * <h1>Contact Activity</h1>
 *
 * <b>Description: </b> Contains information for the receiving offices
 * with address, telephone and view-on-map button.
 *
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.views.contacts;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.BuildConfig;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactsActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 547;


    @BindView(R.id.btn_london_central)
    Button mLondonCentralButton;

    @BindView(R.id.btn_london_bromley)
    Button mLondonBromleyButton;

    @BindView(R.id.btn_london_hillingdon)
    Button mLondonHillingdonButton;

    @BindView(R.id.btn_glasgow)
    Button mGlasgowButton;

    @BindView(R.id.btn_leeds)
    Button mLeedsButton;

    @BindView(R.id.btn_cambridge)
    Button mCambridgeButton;

    String officename = "";
    int officenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ButterKnife.bind(this);

        if (!checkPermissions(this)) {
            showPermissionsAlert(this);
        } else {
            Toast.makeText(this, "The device location tool is checked.", Toast.LENGTH_SHORT)
                    .show();
        }

        mLondonCentralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "LondonCentral";
                officenumber = 1;
                openMapClick();
            }
        });

        mLondonBromleyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "LondonBromley";
                officenumber = 2;
                openMapClick();
            }
        });

        mLondonHillingdonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "LondonHillingdon";
                officenumber = 3;
                openMapClick();
            }
        });

        mGlasgowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "Glasgow";
                officenumber = 4;
                openMapClick();
            }
        });

        mLeedsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "Leeds";
                officenumber = 5;
                openMapClick();
            }
        });

        mCambridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                officename = "Cambridge";
                officenumber = 6;
                openMapClick();
            }
        });
    }

    //@OnClick(R.id.btn_london_central)
    public void openMapClick() {
        Intent viewMap = new Intent(this, MapsActivity.class);
        viewMap.putExtra("name", officename);
        startActivity(viewMap);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    static boolean checkPermissions(Context context) {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void showPermissionsAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Permissions required!")
                .setMessage("Location find tool needs few permissions to work properly. Grant them in settings.")
                .setPositiveButton("GOTO SETTINGS", (dialog, which) -> openSettings(Objects.requireNonNull(this)))
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
