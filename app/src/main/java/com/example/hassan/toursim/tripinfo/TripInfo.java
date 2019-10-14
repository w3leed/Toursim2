package com.example.hassan.toursim.tripinfo;

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

public class TripInfo extends AppCompatActivity {
    public  static int id;
    public  static String user_auth;
    LinearLayoutManager linearLayoutManager;
    TripInfoAdapter adapter;
    RecyclerView recyclerView;
    List<Model>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_info);
       recyclerView=findViewById(R.id.recycle_tipinf);
       // Log.e("user",user_auth+"");
        getdeatilsTrip();


    }
    public void getdeatilsTrip()
    {
        ApiManager.getAPIs().Getdetailstrips("Bearer "+ user_auth,id).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                data=new ArrayList<>();
                if(response.isSuccessful())
                {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject=new JSONObject(response.body().string());
                        JSONObject eachitem=jsonObject.getJSONObject("data");
                        Log.e("trip", jsonObject.getJSONObject("data").toString());
                        String name=eachitem.getString("title");
                        String about=eachitem.getString("about");
                        int price=eachitem.getInt("price");
                        data.add(new Model(name,"",price,0,"",about));
                        setData();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TripInfo.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }
    public void setData()
    {

        adapter = new TripInfoAdapter(data);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}
