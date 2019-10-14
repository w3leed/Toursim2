
package com.example.hassan.toursim.gouvernoment;

import com.google.gson.annotations.SerializedName;


public class Datum {

    @SerializedName("about")
    private String mAbout;
    @SerializedName("id")
    private Long mId;
    @SerializedName("logo")
    private String mLogo;
    @SerializedName("name")
    private String mName;

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
