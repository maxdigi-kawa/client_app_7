package com.kawasdk.clientapp7.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ReportServiceManager {
    private static ReportServiceManager instance;

    private WebService webService;

    public static ReportServiceManager getInstance() {
        if (instance == null) {
            instance = new ReportServiceManager();
        }
        return instance;
    }

    public ReportServiceManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Common.REPORT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webService = retrofit.create(WebService.class);
    }

    public WebService getKawaService() {
        return webService;
    }
}