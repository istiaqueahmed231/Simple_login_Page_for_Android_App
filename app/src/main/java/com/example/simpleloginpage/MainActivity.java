package com.example.simpleloginpage;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.simpleloginpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginViewModel=new ViewModelProvider(this).get(LoginViewModel.class);

        activityMainBinding.setViewmodel(loginViewModel);
        activityMainBinding.setLifecycleOwner(this);

        // Observe login result
        loginViewModel.loginResult.observe(this, result -> {


            if (result.equals("Successful"))
            {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(MainActivity.this, "Invalid User Id/Password", Toast.LENGTH_SHORT).show();
            }
        });




    }
}