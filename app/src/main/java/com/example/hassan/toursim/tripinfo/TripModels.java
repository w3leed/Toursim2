
package com.example.hassan.toursim.tripinfo;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TripModels {

    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

}
