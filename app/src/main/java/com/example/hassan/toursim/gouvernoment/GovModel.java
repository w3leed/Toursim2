
package com.example.hassan.toursim.gouvernoment;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class GovModel {

    @SerializedName("data")
    private List<Datum> mData;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

}
