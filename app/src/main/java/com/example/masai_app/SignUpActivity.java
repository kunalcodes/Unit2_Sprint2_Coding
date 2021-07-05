package com.example.masai_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtSignUpName;
    private EditText mEtSignUpEmail;
    private EditText mEtSignUpPassword;
    private Button mBtnSignUp;
    private TextView mTvSignInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mEtSignUpName = findViewById(R.id.etSignUpName);
        mEtSignUpEmail = findViewById(R.id.etSignUpEmail);
        mEtSignUpPassword = findViewById(R.id.etSignUpPassword);
        mBtnSignUp = findViewById(R.id.btnSignUp);
        mTvSignInLink = findViewById(R.id.tvSignInLink);

        mTvSignInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(signIn);
            }
        });


        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNameValid() && isEmailValid() && isPasswordValid()){
                Intent home = new Intent(SignUpActivity.this, HomeActivity.class);
                home.putExtra("Name", mEtSignUpName.getText().toString());
                startActivity(home);
                }
            }
        });
    }

    private boolean isEmailValid(){
        if (mEtSignUpEmail.getText().toString().length() >= 1 &&
                mEtSignUpEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            return true;
        } else {
            mEtSignUpEmail.setError("Invalid email");
            return false;
        }
    }
    private boolean isNameValid(){
        if (mEtSignUpName.getText().toString().length() >= 4){
            return true;
        } else {
            mEtSignUpName.setError("Minimum 4 characters needed");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if (mEtSignUpPassword.getText().toString().length() >= 6 &&
                mEtSignUpPassword.getText().toString().matches("[0-9]+")){
            return true;
        } else {
            mEtSignUpPassword.setError("Password is weak");
            return false;
        }
    }

}