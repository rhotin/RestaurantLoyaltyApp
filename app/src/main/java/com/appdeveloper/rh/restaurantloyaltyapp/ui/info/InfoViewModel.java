package com.appdeveloper.rh.restaurantloyaltyapp.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Introduction: " +
                "\n\nImagine a restaurant has approached you to create a loyalty sign up screen. It will overlay on the screen where the user has clicked the sign up button. Once the user has supplied all of the required fields and pressed the submit button, it will be sent to the restaurant\'s web-service for storage. " +
                "\n\nIt will take the following fields: First name (required field) Last name (required field) email address (required field) phone number (optional field)" +
                "\n\nIf the supplied data is incorrect, it should notify the user, so they can correct it. Because this is just a test assignment, just pop up an alert dialog that says it was successful if all required data is correct when they press submit." +
                "\n\nExamples of incorrect data: First name not provided or contains invalid characters Last name not provided or contains invalid characters Email address not provided or contains invalid characters Phone number if provided, contains non-numeric characters" +
                "\n\nYour solution should be production quality. You may include a readme.md file in the project to detail the overall architecture of the app and reasons it was done the way it was. " +
                "\n\nThe app should be able to run on Jelly bean MR1 and above.\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}