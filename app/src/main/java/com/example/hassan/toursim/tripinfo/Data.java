
package com.example.hassan.toursim.tripinfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {

    @SerializedName("about")
    private String mAbout;
    @SerializedName("corporation")
    private Corporation mCorporation;
    @SerializedName("featured_image")
    private String mFeaturedImage;
    @SerializedName("id")
    private Long mId;
    @SerializedName("places")
    private List<Place> mPlaces;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("title")
    private String mTitle;

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public Corporation getCorporation() {
        return mCorporation;
    }

    public void setCorporation(Corporation corporation) {
        mCorporation = corporation;
    }

    public String getFeaturedImage() {
        return mFeaturedImage;
    }

    public void setFeaturedImage(String featuredImage) {
        mFeaturedImage = featuredImage;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Place> getPlaces() {
        return mPlaces;
    }

    public void setPlaces(List<Place> places) {
        mPlaces = places;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
