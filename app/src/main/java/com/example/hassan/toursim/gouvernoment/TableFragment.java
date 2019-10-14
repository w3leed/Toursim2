package com.example.hassan.toursim.gouvernoment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassan.toursim.ApiMange.ApiManager;
import com.example.hassan.toursim.Gouvernoment_places.GoVPlaces;
import com.example.hassan.toursim.Places.Model;
import com.example.hassan.toursim.R;

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


public class TableFragment extends Fragment {
    RecyclerView recyclerView;
    GoAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    List<Model> data;


    public TableFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_table, container, false);
        recyclerView=rootView.findViewById(R.id.go_recycleview);
        getAllgo();

        return rootView;
    }


    public  void setData()
    {
        adapter=new GoAdapter(data);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));
        adapter.notifyDataSetChanged();
        adapter.setOnGovItemClick(new GoAdapter.OnGovItemClick() {
            @Override
            public void OnItemclick(Model data, int postion) {
                GoVPlaces.id=data.getId();
                GoVPlaces.user_auth=data.getAuth();
                startActivity(new Intent(getContext(),GoVPlaces.class));

            }
        });


    }


    public void getAllgo()
    {
        if(GoAdapter.go_id!=null){
        ApiManager.getAPIs().GetAllGov("Bearer " + GoAdapter.go_id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                data=new ArrayList<>();
                if (response.isSuccessful())
                {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        Log.e("jom", jsonObject.getJSONArray("data").toString());

                        JSONArray item = jsonObject.getJSONArray("data");
                        for (int i=0;i<item.length();i++)
                        {
                            JSONObject each_item = item.getJSONObject(i);
                            String name=each_item.getString("name");
                            String logo=each_item.getString("logo");
                            int id=each_item.getInt("id");
                            Log.e("noon",each_item.getString("name"));
                            Log.e("Goa",GoAdapter.go_id);
                            data.add(new Model(name,logo,0,id,GoAdapter.go_id,""));

                        }
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
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
    else {

            ApiManager.getAPIs().GetAllGov("Bearer " + GoAdapter.token_go).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    data=new ArrayList<>();
                    if (response.isSuccessful())
                    {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response.body().string());
                            Log.e("jom", jsonObject.getJSONArray("data").toString());

                            JSONArray item = jsonObject.getJSONArray("data");
                            for (int i=0;i<item.length();i++)
                            {
                                JSONObject each_item = item.getJSONObject(i);
                                String name=each_item.getString("name");
                                String logo=each_item.getString("logo");
                                int id=each_item.getInt("id");
                                Log.e("noon",each_item.getString("name"));
                                data.add(new Model(name,logo,0,id,GoAdapter.token_go,""));

                            }
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
                    Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });


        }
    }



}
