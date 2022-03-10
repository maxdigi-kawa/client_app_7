package com.kawasdk.clientapp7.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.kawasdk.R;
import com.kawasdk.clientapp7.Utils.Common;

import java.util.Locale;
import java.util.regex.Pattern;

public class HomeActivity extends AppCompatActivity {
    Button startKawaBtn;
    EditText nameTxt, addressTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale();
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);

        startKawaBtn = findViewById(R.id.startKawaBtn);
        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        startKawaBtn.setOnClickListener(viewV -> gotoKawaSDK());

    }

    private void gotoKawaSDK() {
        String nameStr = nameTxt.getText().toString().trim();
        String addressStr = addressTxt.getText().toString().trim();
        String regexStr = "^[+][0-9]{10,13}$";
        if(!addressStr.matches("^\\d{10,13}$")){
            Toast.makeText(HomeActivity.this,getResources().getString(R.string.please_enter_valid_mobileno),Toast.LENGTH_LONG).show();
        }
//        if(!nameStr.matches("^[a-zA-Z ]+$") && !nameStr.matches("[\u0900-\u097F ]+$")&& !nameStr.matches("[{Devanagari} ]+$")){
//            Toast.makeText(HomeActivity.this,getResources().getString(R.string.farmer_name_must_string),Toast.LENGTH_LONG).show();
//        }
       else{
            Common.USER_NAME = nameTxt.getText().toString();
            Common.USER_ADDRESS = addressTxt.getText().toString();
            //segmentInit(HomeActivity.this);
            Intent intent = new Intent(HomeActivity.this, kawaHomeActivity.class);
            startActivity(intent);
        }
    }


    public void setLocale() {

        String languageToLoad = "hi"; // use hi fo hindi lanuage.
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

    }


}