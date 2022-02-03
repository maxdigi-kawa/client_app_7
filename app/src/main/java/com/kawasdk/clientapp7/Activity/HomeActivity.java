package com.kawasdk.clientapp7.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.kawasdk.R;
import com.kawasdk.clientapp7.Utils.Common;

public class HomeActivity extends AppCompatActivity {
    Button startKawaBtn;
    EditText nameTxt, addressTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        startKawaBtn = findViewById(R.id.startKawaBtn);
        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        startKawaBtn.setOnClickListener(viewV -> gotoKawaSDK());

    }

    private void gotoKawaSDK() {
        String nameStr = nameTxt.getText().toString().trim();
        String addressStr = addressTxt.getText().toString().trim();
        if (nameStr.isEmpty()) {
            Toast.makeText(HomeActivity.this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }else if (addressStr.isEmpty()) {
            Toast.makeText(HomeActivity.this,"Please enter mobile number",Toast.LENGTH_LONG).show();
            return;
        }else{
            Common.USER_NAME = nameTxt.getText().toString();
            Common.USER_ADDRESS = addressTxt.getText().toString();
            //segmentInit(HomeActivity.this);
            Intent intent = new Intent(HomeActivity.this, kawaHomeActivity.class);
            startActivity(intent);
        }


    }

}