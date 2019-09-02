package com.appdeveloper.rh.restaurantloyaltyapp.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Boolean> viewShow;

    public HomeViewModel() {
        viewShow = new MutableLiveData<>();
        viewShow.setValue(false);
    }

    public MutableLiveData<Boolean> getViewShow() {
        return viewShow;
    }

    public void setViewShow(Boolean viewShow) {
        if (getViewShow().getValue() != null)
            if (!getViewShow().getValue())
                this.viewShow.setValue(viewShow);
            else
                this.viewShow.setValue(!viewShow);
    }
}