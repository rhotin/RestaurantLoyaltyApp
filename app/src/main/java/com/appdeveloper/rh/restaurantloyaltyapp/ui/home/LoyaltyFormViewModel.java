package com.appdeveloper.rh.restaurantloyaltyapp.ui.home;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appdeveloper.rh.restaurantloyaltyapp.Model.home.LoyaltyForm;
import com.appdeveloper.rh.restaurantloyaltyapp.R;

public class LoyaltyFormViewModel extends ViewModel {

    public MutableLiveData<String> FirstName = new MutableLiveData<>();
    public MutableLiveData<String> LastName = new MutableLiveData<>();
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> PhoneNumber = new MutableLiveData<>();

    private MutableLiveData<LoyaltyForm> loyaltyFormMutableLiveData;

    public MutableLiveData<LoyaltyForm> getLoyaltyUser() {
        if (loyaltyFormMutableLiveData == null) {
            loyaltyFormMutableLiveData = new MutableLiveData<>();
        }
        return loyaltyFormMutableLiveData;
    }

    public void onClick(View view) {
        LoyaltyForm loyaltyForm = new LoyaltyForm(FirstName.getValue(), LastName.getValue(), EmailAddress.getValue());
        switch (view.getId()) {
            case (R.id.btnSubmit): {
                if (PhoneNumber.getValue() != null)
                    loyaltyForm.setmPhone(PhoneNumber.getValue());
                loyaltyFormMutableLiveData.setValue(loyaltyForm);
                break;
            }
            case (R.id.btnCancel): {
                loyaltyForm.setmCancel(true);
                loyaltyFormMutableLiveData.setValue(loyaltyForm);
                break;
            }
        }
    }
}
