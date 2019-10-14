
package com.example.hassan.toursim.Gouvernoment_places;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GouverPlaces {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("links")
    private Links mLinks;
    @SerializedName("meta")
    private Meta mMeta;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        mLinks = links;
    }

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

}
