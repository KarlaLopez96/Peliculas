package com.karla00058615.peliculas;

import android.graphics.drawable.Drawable;

/**
 * Created by Karla on 21/4/2018.
 */

public class Peliculas {

    private int id,fav;
    private String title, desc;
   // Drawable img;

    public Peliculas(int id, String title, String desc,int fav) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.fav = fav;
     //   this.img = img;
    }

    public int getId() {
        return id;
    }

    public int getFav() {
        return fav;
    }

//    public Drawable getImg() {
  //      return img;
  //  }

    public void setId(int id) {
        this.id = id;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    //public void setImg(Drawable img) {
      //  this.img = img;
    //}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
