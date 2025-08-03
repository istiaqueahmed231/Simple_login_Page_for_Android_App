package com.example.simpleloginpage;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> email=new MutableLiveData<>();
    public MutableLiveData<String> Password=new MutableLiveData<>();
    public MutableLiveData<String> loginResult=new MutableLiveData<>();
    public MutableLiveData<String> passwordHint = new MutableLiveData<>("");

    public MutableLiveData<String> emailHint = new MutableLiveData<>("");



    public LoginViewModel() {
        // Observe password changes and validate
        Password.observeForever(pw -> {
            if (pw == null || pw.length() < 8) {
                passwordHint.setValue("⚠️ Password must be at least 8 characters");
            } else {
                passwordHint.setValue(""); // or "✅ Password is valid"
            }
        });


        // Email validation
        email.observeForever(mail -> {
            if (mail != null && !mail.isEmpty()) {
                if (!mail.matches("[a-zA-Z0-9@._]*")) {
                    emailHint.setValue("⚠️ Email contains invalid characters");
                } else {
                    emailHint.setValue("");
                }
            } else {
                emailHint.setValue("");
            }
        });



    }


    public void onLoginClicked(){
        String userEmail=email.getValue();
        String userPassword=Password.getValue();

        if ("admin@example.com".equals(userEmail) && "12345678".equals(userPassword)) {

            loginResult.setValue("Successful");
        } else {
            loginResult.setValue("Failed");
        }

    }






}
