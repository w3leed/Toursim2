package com.example.hassan.toursim.places_info;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesInfo extends AppCompatActivity {
    public  static int id;
    public  static String user_auth;
    LinearLayoutManager linearLayout;
    PlacesInfoAdapter adapter;
    List<Model> data;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_info);
        Log.e("user",user_auth+"");
        recyclerView=findViewById(R.id.recycle_placesinfo);
        getplacesdeatils();

    }

    public void getplacesdeatils()
    {

        ApiManager.getAPIs().GetdetailsPlaces("Bearer "+ user_auth,id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                data=new ArrayList<>();
                if(response.isSuccessful())
                {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject=new JSONObject(response.body().string());
                        Log.e("places", jsonObject.getJSONObject("data").toString());
                        JSONObject eachitem=jsonObject.getJSONObject("data");
                        String image=eachitem.getString("featured_image");
                        String name=eachitem.getString("content");
                        data.add(new Model(name,image,0,0,"",""));
                           setData();
                    }

                    catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(PlacesInfo.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
    public  void setData() {
        adapter = new PlacesInfoAdapter(data);
        linearLayout=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayout);

    }
}
