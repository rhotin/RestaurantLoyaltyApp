package com.appdeveloper.rh.restaurantloyaltyapp.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.appdeveloper.rh.restaurantloyaltyapp.Model.home.LoyaltyForm;
import com.appdeveloper.rh.restaurantloyaltyapp.R;
import com.appdeveloper.rh.restaurantloyaltyapp.databinding.FragmentLoyaltyBinding;

public class LoyaltyFragment extends Fragment {

    private LoyaltyFormViewModel loyaltyFormViewModel;
    private FragmentLoyaltyBinding binding;

    private HomeViewModel homeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loyaltyFormViewModel = ViewModelProviders.of(getActivity()).get(LoyaltyFormViewModel.class);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_loyalty, container, false);
        binding.setLifecycleOwner(this);
        binding.setLoyaltyFormViewModel(loyaltyFormViewModel);

        loyaltyFormViewModel.getLoyaltyUser().observe(this, new Observer<LoyaltyForm>() {
            @Override
            public void onChanged(LoyaltyForm loyaltyForm) {
                if (loyaltyForm.getmCancel()) {
                    loyaltyForm.setmCancel(false);
                    homeViewModel.setViewShow(true);
                } else if (loyaltyForm.getmFirstName() == null) {
                    binding.txtFirstName.setError("Enter a Name");
                    binding.txtFirstName.requestFocus();
                } else if (!loyaltyForm.validName()) {
                    binding.txtFirstName.setError("Enter a Valid Name");
                    binding.txtFirstName.requestFocus();
                } else if (loyaltyForm.getmLastName() == null) {
                    binding.txtLastName.setError("Enter a Last Name");
                    binding.txtLastName.requestFocus();
                } else if (!loyaltyForm.validLastName()) {
                    binding.txtLastName.setError("Enter a Valid Last Name");
                    binding.txtLastName.requestFocus();
                } else if (loyaltyForm.getmEmail() == null) {
                    binding.txtEmailAddress.setError("Enter an E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                } else if (!loyaltyForm.validEmail()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    binding.txtEmailAddress.requestFocus();
                } else if (loyaltyForm.getmPhone() != null && !loyaltyForm.validPhone()) {
                    binding.txtPhone.setError("Enter a Valid Phone Number");
                    binding.txtPhone.requestFocus();
                } else {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(R.string.dialog_message)
                            .setTitle(R.string.dialog_title)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    homeViewModel.setViewShow(true);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        });

        return binding.getRoot();
    }

}
