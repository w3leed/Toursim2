
package com.example.hassan.toursim.places_info;

import com.google.gson.annotations.SerializedName;


public class Medium {

    @SerializedName("path")
    private String mPath;
    @SerializedName("type")
    private String mType;

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
