
package com.example.hassan.toursim.places_info;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {

    @SerializedName("content")
    private String mContent;
    @SerializedName("corporation")
    private Corporation mCorporation;
    @SerializedName("featured_image")
    private String mFeaturedImage;
    @SerializedName("governorate")
    private Governorate mGovernorate;
    @SerializedName("id")
    private Long mId;
    @SerializedName("media")
    private List<Medium> mMedia;
    @SerializedName("name")
    private String mName;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("tags")
    private String mTags;
    @SerializedName("type")
    private Type mType;
    @SerializedName("views")
    private Long mViews;

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
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

    public Governorate getGovernorate() {
        return mGovernorate;
    }

    public void setGovernorate(Governorate governorate) {
        mGovernorate = governorate;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Medium> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Medium> media) {
        mMedia = media;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public String getTags() {
        return mTags;
    }

    public void setTags(String tags) {
        mTags = tags;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

}
