package com.example.hassan.toursim.ApiMange;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static Retrofit retrofitInstance;

    static Retrofit getInstacne(){

        // final Token t=new Token();
        if(retrofitInstance==null){



           /* OkHttpClient client=new OkHttpClient.Builder().addInterceptor(new Interceptor() {
              @Override
              public Response intercept(Chain chain) throws IOException {
                  Request newrewquest=chain.request().newBuilder()
                          .addHeader("Authorization","Bearer " + t.getToken()).build();
                  return chain.proceed(newrewquest);
              }
          }).build();*/

            //build retrofit
             retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://safari.love-physics.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofitInstance;

    }

   public static AppServices getAPIs(){

       return getInstacne().create(AppServices.class);
    }



}
