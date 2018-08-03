package io.github.sagar15795.meetupsampleapp.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class BookOkHttpClient {


    public OkHttpClient getBookOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //Enable Full Body Logging
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Interceptor :> Full Body Logger
        builder.addInterceptor(logger);

        return builder.build();

    }
}