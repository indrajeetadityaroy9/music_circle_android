package com.example.musiccircle.Fragments.Login;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.musiccircle.R;

public class WelcomeLoginRegistrationFragment extends Fragment {

    public WelcomeLoginRegistrationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Variables
    private Button RegisterButton;
    private Button LoginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome_login_registration, container, false);

        View registbtn = view.findViewById(R.id.btn_register);
        RegisterButton = (Button) registbtn;

        View loginbtn = view.findViewById(R.id.btn_login);
        LoginButton = (Button) loginbtn;

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_welcomeLoginRegistrationFragment_to_registrationFragment);
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_welcomeLoginRegistrationFragment_to_loginFragment);
            }
        });

        return view;
    }
}