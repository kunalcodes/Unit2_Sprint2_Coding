package com.example.masai_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText mEtSignInName;
    private EditText mEtSignInPassword;
    private Button mBtnSignIn;
    private TextView mTvSignUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mEtSignInName = findViewById(R.id.etSignInName);
        mEtSignInPassword = findViewById(R.id.etSignInPassword);
        mBtnSignIn = findViewById(R.id.btnSignIn);
        mTvSignUpLink = findViewById(R.id.tvSignUpLink);

        mTvSignUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(signUp);
            }
        });


        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNameValid() && isPasswordValid()){
                    Intent home = new Intent(SignInActivity.this, HomeActivity.class);
                    home.putExtra("Name", mEtSignInName.getText().toString());
                    startActivity(home);
                }
            }
        });
    }

    private boolean isNameValid(){
        if (mEtSignInName.getText().toString().length() >= 4){
            return true;
        } else {
            mEtSignInName.setError("Minimum 4 characters needed");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if (mEtSignInPassword.getText().toString().length() >= 6 &&
                mEtSignInPassword.getText().toString().matches("[0-9]+")){
            return true;
        } else {
            mEtSignInPassword.setError("Password is weak");
            return false;
        }
    }

}