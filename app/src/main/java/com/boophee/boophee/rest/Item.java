package com.boophee.boophee.rest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 31/1/18.
 */

public class Item {
    @SerializedName("front")
    @Expose
    private String front;
    @SerializedName("back")
    @Expose
    private String back;

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

}
