package com.example.hassan.toursim.Trip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;
import com.example.hassan.toursim.tripinfo.TripInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FixturesFragment extends Fragment {
    RecyclerView recyclerView;
    PlacesAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    List<Model> data;

    public FixturesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fixtures, container, false);
        recyclerView=rootView.findViewById(R.id.places_recycleview);
        getPlaces();
        return rootView;
    }

    public  void setData()
    {
        adapter=new PlacesAdapter(data);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter.setOnTripclickItem(new PlacesAdapter.OnTripclickItem() {
            @Override
            public void OnitemTrip(Model data, int postion) {
                TripInfo.id=data.getId();
                TripInfo.user_auth=data.getAuth();
                startActivity(new Intent(getContext(),TripInfo.class));
            }
        });

    }
    public void getPlaces()
    {
       if(PlacesAdapter.places_id!=null) {
           ApiManager.getAPIs().GetAllPlaces("Bearer " + PlacesAdapter.places_id).enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   data = new ArrayList<>();

                   if (response.isSuccessful()) {
                       try {
                           JSONObject jsonObject = new JSONObject(response.body().string());
                           Log.e("jom", jsonObject.getJSONArray("data").toString());
                           JSONArray item = jsonObject.getJSONArray("data");
                           JSONObject each_item = item.getJSONObject(0);
                           String places_name = each_item.getString("title");
                           int places_price = each_item.getInt("price");
                           String plcaes_image = each_item.getString("featured_image");
                           int id=each_item.getInt("id");
                           Log.e("places_name", each_item.getString("title"));
                           data.add(new Model(places_name, plcaes_image, places_price,id,PlacesAdapter.places_id,""));
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
                   Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
               }
           });
       }
       else {

           ApiManager.getAPIs().GetAllPlaces("Bearer " + PlacesAdapter.token_places).enqueue(new Callback<ResponseBody>() {
               @Override
               public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                   data = new ArrayList<>();

                   if (response.isSuccessful()) {
                       try {
                           JSONObject jsonObject = new JSONObject(response.body().string());
                           Log.e("jom", jsonObject.getJSONArray("data").toString());
                           JSONArray item = jsonObject.getJSONArray("data");
                           JSONObject each_item = item.getJSONObject(0);
                           String places_name = each_item.getString("title");
                           int places_price = each_item.getInt("price");
                           String plcaes_image = each_item.getString("featured_image");
                           int id=each_item.getInt("id");
                           Log.e("places_name", each_item.getString("title"));
                           data.add(new Model(places_name, plcaes_image, places_price,id,PlacesAdapter.token_places,""));
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
                   Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
               }
           });

       }

    }

}
