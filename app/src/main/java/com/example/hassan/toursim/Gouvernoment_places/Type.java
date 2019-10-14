
package com.example.hassan.toursim.Gouvernoment_places;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Type {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
