package com.iakstudios.app.chaletIn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sigin_page extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    EditText loginEmail, loginPass;
    String logEmail, logPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_page);

        loginEmail = findViewById(R.id.edit_logemail);
        loginPass = findViewById(R.id.edit_logpass);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.btn_signin).setOnClickListener(this);
    }

    public void Goregister(View view) {
        Intent intent=new Intent(sigin_page.this, signup_page.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        userLogin();
    }

    // Method to sign-in
    @SuppressLint("ResourceType")
    public void userLogin(){
        logEmail = loginEmail.getText().toString().trim();
        logPassword = loginPass.getText().toString().trim();

        // Validating fields
        if (logEmail.isEmpty()) {
            loginEmail.setError("Email is required");
            loginEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(logEmail).matches()) {
            loginEmail.setError("Please enter a valid email");
            loginEmail.requestFocus();
            return;
        }

        if (logPassword.isEmpty()) {
            loginPass.setError("Password is required");
            loginPass.requestFocus();
            return;
        }

        if (logPassword.length() < 6) {
            loginPass.setError("Minimum length of password should be 6");
            loginPass.requestFocus();
            return;
        }


        // Signing the user based on his credentials entered during login
        mAuth.signInWithEmailAndPassword(logEmail, logPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent mainPage = new Intent(sigin_page.this, MainActivity.class);
                    startActivity(mainPage);

                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}

