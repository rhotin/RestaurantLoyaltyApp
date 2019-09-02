package com.appdeveloper.rh.restaurantloyaltyapp.Model.home;

import android.util.Patterns;

public class LoyaltyForm {
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mPhone;
    private Boolean mCancel;

    public LoyaltyForm(String mFirstName, String mLastName, String mEmail) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mPhone = "";
        this.mCancel = false;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public Boolean getmCancel() {
        return mCancel;
    }

    public void setmCancel(Boolean mCancel) {
        this.mCancel = mCancel;
    }

    public boolean validName() {
        return mFirstName.matches("[A-Za-z][a-z]*");
    }

    public boolean validLastName() {
        return mLastName.matches("[A-Za-z][a-z]*");
    }

    public boolean validEmail() {
        return Patterns.EMAIL_ADDRESS.matcher(getmEmail()).matches();
    }

    public boolean validPhone() {
        boolean result = false;
        if (getmPhone() != null && getmPhone().length() >= 10 && getmPhone().length() <= 11) {
            result = Patterns.PHONE.matcher(getmPhone()).matches();
        } else if (getmPhone() == null || getmPhone().isEmpty()) {
            result = true;
        }
        return result;
    }


}
