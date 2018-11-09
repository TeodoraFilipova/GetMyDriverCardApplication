package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CardApplicationFormsListAdapter
        extends RecyclerView.Adapter<CardApplicationFormsListAdapter.CardAppFormViewHolder> {

    private List<CardApplicationForm> mCardApplicationForms;

    private OnProductClickListener mOnProductClickListener;

    @Inject
    public CardApplicationFormsListAdapter() {
        mCardApplicationForms = new ArrayList<>();
    }



    @NonNull
    @Override
    public CardAppFormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardapplicationform_item, parent, false);
        int height = parent.getMeasuredHeight() / 2;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new CardAppFormViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAppFormViewHolder holder, int position) {
        holder.setOnClickListener(mOnProductClickListener);
        holder.bind(mCardApplicationForms.get(position));
    }

    @Override
    public int getItemCount() {
        return mCardApplicationForms.size();
    }

    public CardApplicationForm getItem(int position) {
        return mCardApplicationForms.get(position);
    }

    public void clear() {
        mCardApplicationForms.clear();
    }

    public void addAll(List<CardApplicationForm> products) {
        mCardApplicationForms.addAll(products);
    }

    public void setOnProductClickListener(OnProductClickListener onProductClickListener) {
        this.mOnProductClickListener = onProductClickListener;
    }

    public static class CardAppFormViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_cardappformid)
        TextView mCardAppFormIDTextView;

        @BindView(R.id.tv_firstname)
        TextView mFirstNameTextView;

        @BindView(R.id.tv_lastname)
        TextView mLastNameTextView;

        @BindView(R.id.tv_personalnumber)
        TextView mPersonalNumberTextView;

        @BindView(R.id.tv_dateofsubmission)
        TextView mDateofSubmissionTextView;

        @BindView(R.id.tv_status)
        TextView mStatusTextView;

        private OnProductClickListener mOnClickListener;
        private CardApplicationForm mForm;

        CardAppFormViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        void bind(CardApplicationForm form) {
            mCardAppFormIDTextView.setText(String.valueOf(form.getCardApplicationFormId()));
            mFirstNameTextView.setText(form.getDriver().getFirstName());
            mLastNameTextView.setText(form.getDriver().getLastName());
            mPersonalNumberTextView.setText(form.getDriver().getPersonalNumber());

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String reportDate = df.format(form.getDateOfSubmission());

            mDateofSubmissionTextView.setText(reportDate);
            mStatusTextView.setText(form.getStatus());

            mForm = form;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mForm);
        }

        public void setOnClickListener(OnProductClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnProductClickListener {
        void onClick(CardApplicationForm form);
    }
}