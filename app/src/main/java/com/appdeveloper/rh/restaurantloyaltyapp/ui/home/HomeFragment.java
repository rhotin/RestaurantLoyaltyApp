package com.appdeveloper.rh.restaurantloyaltyapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.appdeveloper.rh.restaurantloyaltyapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    View LoyaltyFrame;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        LoyaltyFrame = root.findViewById(R.id.LoyaltyFrame);
        Button loyaltySignUp = root.findViewById(R.id.signUpBtn);
        loyaltySignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("HomeFrag", "Click");
                homeViewModel.setViewShow(true);
                //LoyaltyFrame.setVisibility(View.VISIBLE);
            }
        });

        homeViewModel.getViewShow().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.e("LoyaltyFrag", "Click" + aBoolean);
                if (!aBoolean) {
                    LoyaltyFrame.setVisibility(View.GONE);
                } else {
                    LoyaltyFrame.setVisibility(View.VISIBLE);
                    LoyaltyFrame.bringToFront();
                }
            }
        });

        return root;
    }
}