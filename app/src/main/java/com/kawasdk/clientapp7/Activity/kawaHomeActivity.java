package com.kawasdk.clientapp7.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.JsonObject;
import com.kawasdk.clientapp7.Fragment.fragmentFarmLocation;
import com.kawasdk.R;
import com.kawasdk.clientapp7.Utils.InterfaceKawaEvents;
import com.kawasdk.clientapp7.Utils.KawaMap;

import org.json.JSONObject;

public class kawaHomeActivity extends AppCompatActivity implements InterfaceKawaEvents {
    public static final String TAG = "Kawa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kawa_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        KawaMap.initSmartlook(getResources().getString(R.string.smartlook_api_key));
        KawaMap.initSegment(kawaHomeActivity.this,getResources().getString(R.string.segment_api_key));
        KawaMap.startKawaSDK(kawaHomeActivity.this, getResources().getString(R.string.kawa_api_key));
    }

    @Override
    public void initKawaMap(boolean isValid) {
        Log.e("TAG", "initKawaMap: >>> " + isValid);
        KawaMap.setFooterBtnBgColorAndTextColor(kawaHomeActivity.this.getResources().getColor(R.color.colorPrimary), Color.WHITE);
        KawaMap.setInnerBtnBgColorAndTextColor(Color.WHITE, Color.BLACK);
        KawaMap.setHeaderBgColorAndTextColor(Color.WHITE,kawaHomeActivity.this.getResources().getColor(R.color.colorPrimary));


    }

    @Override
    public void onkawaSubmit(String data) {
        //Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.e(TAG, "SubmitJson: " + data);
    }

    @Override
    public void onkawaDestroy() {
        KawaMap.exitKawaSDK(this, HomeActivity.class.getName());
    }

    @Override
    public void onkawaSelect(JsonObject data) {
        //Toast.makeText(this, String.valueOf(data), Toast.LENGTH_LONG).show();
        Log.e(TAG, "SelectJson: " + data);
        //KawaMap.exitKawaSDK(this, HomeActivity.class.getName());
    }

    @Override
    public void onkawaUpdate(JSONObject data) {
        Log.e(TAG, String.valueOf(data));
    }
}