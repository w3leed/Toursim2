package com.example.hassan.toursim.Gouvernoment_places;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;

import org.json.JSONArray;
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

public class GoVPlaces extends AppCompatActivity {
    public  static int id;
    public  static String user_auth;
    LinearLayoutManager linearLayoutManager;
     GoInfoAdapter adapter;
    RecyclerView recyclerView;
    List<Model>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_vplaces);
        recyclerView=findViewById(R.id.recycle_go);
        //Log.e("t_id",id+"");
       //Log.e("user",user_auth+"");
        getgoplaces();



    }
    public void getgoplaces()
    {

        ApiManager.getAPIs().GetGovPlaces("Bearer "+ user_auth,id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                data=new ArrayList<>();
                if(response.isSuccessful())
                {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject=new JSONObject(response.body().string());
                        Log.e("places", jsonObject.getJSONArray("data").toString());
                        JSONArray eachitem=jsonObject.getJSONArray("data");
                        for (int i=0;i<eachitem.length();i++)
                        {
                            JSONObject item=eachitem.getJSONObject(i);
                            String image=item.getString("featured_image");
                            String title=item.getString("name");
                            data.add(new Model(title,image,0,0,"",""));

                        }
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
                Toast.makeText(GoVPlaces.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }
    public  void setData() {
        adapter = new GoInfoAdapter(data);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}
