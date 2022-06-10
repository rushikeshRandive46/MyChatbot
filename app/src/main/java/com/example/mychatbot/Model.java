package com.example.mychatbot;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Model {

    @SerializedName("cnt")
    @Expose
    private String cnt;

    public Model(String cnt)
    {
        this.cnt=cnt;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

}