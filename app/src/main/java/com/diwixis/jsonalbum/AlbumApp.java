package com.diwixis.jsonalbum;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diwixis on 23.10.2017.
 */

public class AlbumApp extends Application{
    private static IAlbumApi api;
    private Retrofit retrofit;
    private static int columnsCount = 2;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(AlbumUrls.BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(IAlbumApi.class); //Создаем объект, при помощи которого будем выполнять запросы
        if (getResources().getConfiguration().smallestScreenWidthDp>= 600){
            columnsCount = 3;
        }
    }

    public static IAlbumApi getApi() {
        return api;
    }

    public static int getColumnCounts() {
        return columnsCount;
    }
}
