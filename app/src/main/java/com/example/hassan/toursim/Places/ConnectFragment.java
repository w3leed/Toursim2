package com.example.hassan.toursim.Places;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.R;
import com.example.hassan.toursim.places_info.PlacesInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectFragment extends Fragment {
    RecyclerView recyclerView;
    TripAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    List<Model> data;

    public ConnectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        recyclerView=rootView.findViewById(R.id.recycleview);
        getTrips();
        return rootView;
    }
    public  void setData()
    {
        adapter=new TripAdapter(data);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
       // recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter.setOnItemPlaces(new TripAdapter.OnItemPlaces() {
            @Override
            public void OnClickplaces(Model data, int postion) {
                PlacesInfo.id=data.getId();
                PlacesInfo.user_auth=data.getAuth();
                startActivity(new Intent(getContext(),PlacesInfo.class));
            }
        });
    }


    public void getTrips() {
       // String token = getIntent().getStringExtra("token");
       if(TripAdapter.id!=null) {
           ApiManager.getAPIs().GetAllTrip("Bearer " + TripAdapter.id).enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   data = new ArrayList<>();
                   if (response.isSuccessful()) {

                       try {
                           JSONObject jsonObject = new JSONObject(response.body().string());
                           JSONArray item = jsonObject.getJSONArray("data");

                           JSONObject each_item = item.getJSONObject(0);
                           JSONObject vi = each_item.getJSONObject("governorate");
                           Log.e("name", vi.getString("name") + 0);
                           String name = vi.getString("name");
                           String image = each_item.getString("featured_image");
                           int id=each_item.getInt("id");

                           data.add(new Model(name, image, 0,id,TripAdapter.token_use,""));
                           setData();


                           // Log.e("json",jsonObject.getJSONArray("data").toString());


                       } catch (JSONException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }


               }

               @Override
               public void onFailure(Call<ResponseBody> call, Throwable t) {
                   Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

               }
           });
       }

       else {

           ApiManager.getAPIs().GetAllTrip("Bearer " +TripAdapter.token_use).enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                   data = new ArrayList<>();
                   if (response.isSuccessful()) {

                       try {
                           JSONObject jsonObject = new JSONObject(response.body().string());
                           JSONArray item = jsonObject.getJSONArray("data");

                           JSONObject each_item = item.getJSONObject(0);
                           JSONObject vi = each_item.getJSONObject("governorate");
                           Log.e("name", vi.getString("name") + 0);
                           String name = vi.getString("name");
                           String image = each_item.getString("featured_image");
                           int id=each_item.getInt("id");
                           data.add(new Model(name, image, 0,id,TripAdapter.token_use,""));
                           setData();


                           // Log.e("json",jsonObject.getJSONArray("data").toString());


                       } catch (JSONException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }

               @Override
               public void onFailure(Call<ResponseBody> call, Throwable t) {
                   Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

               }
           });
       }

    }


}
