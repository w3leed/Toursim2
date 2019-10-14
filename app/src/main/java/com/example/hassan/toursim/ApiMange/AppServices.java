package com.example.hassan.toursim.ApiMange;

import com.example.hassan.toursim.Userregister.Data;
import com.example.hassan.toursim.userlogin.UserLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface   AppServices {


    @FormUrlEncoded
    @POST("/api/oauth/register")
    Call<Data> SetUserregistr(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("confirm_password") String confirm_password);

    @FormUrlEncoded
    @POST("/api/oauth/login")
    Call<UserLogin> SetUserLogin(@Field("email") String email, @Field("password") String password);


    @GET("/api/places")
    Call<ResponseBody>GetAllTrip(@Header("Authorization") String auth);

    @GET("/api/trips")
    Call<ResponseBody>GetAllPlaces(@Header("Authorization") String auth);

    @GET("/api/govs")
    Call<ResponseBody>GetAllGov(@Header("Authorization") String auth);
    @GET("/api/govs/{govId}/places")
    Call<ResponseBody>GetGovPlaces(@Header("Authorization") String auth,@Path("govId") long id);
    @GET("/api/places/{placeId}")
    Call<ResponseBody>GetdetailsPlaces(@Header("Authorization") String auth,@Path("placeId") long id);
    @GET("/api/trips/{tripId}")
    Call<ResponseBody>Getdetailstrips(@Header("Authorization") String auth,@Path("tripId") long id);


}
