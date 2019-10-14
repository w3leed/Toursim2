package com.example.hassan.toursim.Places;

public class Model {
    String txt;
    String image;
    int price;
     int id;
     String auth;
     String about;

    public Model(String txt, String image,int price,int id,String auth,String about) {
        this.txt = txt;
        this.image = image;
        this.price=price;
        this.id=id;
        this.auth=auth;
        this.about=about;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
