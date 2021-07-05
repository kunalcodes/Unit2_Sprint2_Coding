package com.example.masai_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTvHomeUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvHomeUserName = findViewById(R.id.tvHomeUserName);
        if (getIntent() != null && getIntent().getExtras() != null){
            String name = getIntent().getStringExtra("Name");
            mTvHomeUserName.setText(name);
        }
    }
}