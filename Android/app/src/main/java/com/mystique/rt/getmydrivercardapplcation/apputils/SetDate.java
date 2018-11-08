package com.mystique.rt.getmydrivercardapplcation.apputils;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SetDate implements View.OnFocusChangeListener, DatePickerDialog.OnDateSetListener {

    private EditText mEditText;
    private Calendar mCalendar;
    private Context mContext;
    private FocusListener mFragment;

    public SetDate(EditText editText, Context ctx, FocusListener fragment){
        this.mEditText = editText;
        this.mEditText.setOnFocusChangeListener(this);
        mCalendar = Calendar.getInstance();
        mContext = ctx;
        mFragment = fragment;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)     {
        // this.mEditText.setText();

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdformat = new SimpleDateFormat(myFormat);
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, monthOfYear);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        mEditText.setText(sdformat.format(mCalendar.getTime()));

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            new DatePickerDialog(mContext, this, mCalendar
                    .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                    mCalendar.get(Calendar.DAY_OF_MONTH)).show();
        } else {
            mFragment.saveDateToObject();
        }
        //         v.clearFocus();
    }

}
