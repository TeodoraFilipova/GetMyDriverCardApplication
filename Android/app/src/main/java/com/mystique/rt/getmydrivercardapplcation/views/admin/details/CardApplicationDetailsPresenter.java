package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.services.base.CardApplicationFormService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CardApplicationDetailsPresenter implements CardApplicationDetailsContracts.Presenter {
    private final CardApplicationFormService mFormService;
    private final SchedulerProvider mSchedulerProvider;

    private CardApplicationDetailsContracts.View mView;
    private int mCardApplicationFormId;

    @Inject
    public CardApplicationDetailsPresenter(
            CardApplicationFormService formService,
            SchedulerProvider schedulerProvider
    ) {
        mFormService = formService;
        mSchedulerProvider = schedulerProvider;
    }



    @Override
    public void subscribe(CardApplicationDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCardApplicationForm() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter ->
                        {CardApplicationForm form = mFormService.getFormById(mCardApplicationFormId);
                        emitter.onNext(form);
                        emitter.onComplete();
                        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showCardApplicationFormDetails);
    }

    @Override
    public void updateCardApplicationForm() {
        /*Disposable observable = Observable
                .create((ObservableOnSubscribe<CardApplicationForm>) emitter -> {
                    CardApplicationForm form = mFormService.getFormById(mCardApplicationFormId);
                    int newBought = newProduct.getBought() + 1;
                    newProduct.setBought(newBought);
                    mProductsService.updateProduct(mProductId, newProduct);

                    emitter.onNext(newProduct);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showAddedToWishList);*/
    }

    @Override
    public void setCardApplicationFormId(int id) { mCardApplicationFormId = id;

    }
}
