
package com.example.hassan.toursim.places_info;


import com.google.gson.annotations.SerializedName;


public class PlacesModel {

    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

}
