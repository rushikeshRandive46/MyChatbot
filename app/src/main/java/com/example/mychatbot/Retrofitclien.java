package com.example.mychatbot;

import android.speech.tts.TextToSpeech;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclien {
   public  static  Retrofitclien retrofitclien =null;
   private  RetrofitInterface retrofitInterface;
   String msg="hello";
   public Retrofitclien(String msg)
   {
      this.msg=msg;
      setRetrofitclien();
   }

    public void setRetrofitclien() {
       Retrofit retrofit = new Retrofit.Builder().baseUrl("\n" +
               "api with key")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

   public  static synchronized Retrofitclien getInstance(String msg)
   {
      if (retrofitclien==null) {
      retrofitclien =new Retrofitclien(msg);
      }
      return retrofitclien;
   }

   public RetrofitInterface getapi()
   {
      return  retrofitInterface;
   }
}
