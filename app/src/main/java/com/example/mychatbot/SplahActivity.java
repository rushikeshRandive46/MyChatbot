package com.example.mychatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SplahActivity extends AppCompatActivity {

    TextInputEditText editText;
    String name;
    Button proceed;
    AlphaAnimation animation;
    TextInputLayout holder;
    ImageView bot;
    TinyDB tinyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);
        proceed=findViewById(R.id.btnPro);
        bot=findViewById(R.id.botimage);
        holder=findViewById(R.id.textholder);
        editText=findViewById(R.id.nametxt);
       // name=savedInstanceState.getString("name");
        tinyDB=new TinyDB(getApplicationContext());
        name=getname();

        if(name.isEmpty())
        {
            holder.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
            proceed.setVisibility(View.VISIBLE);
            proceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  //  editText.setVisibility(View.INVISIBLE);
                    //proceed.setVisibility(View.INVISIBLE);
                    name=editText.getText().toString();
                    save(name);
                    //onSaveInstanceState(savedInstanceState);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            });

        }
        else
        {
            holder.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);
            proceed.setVisibility(View.INVISIBLE);
            animation=new AlphaAnimation(0,100);
            animation.setDuration(1000);
            bot.setAnimation(animation);
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            },2000);
        }



    }

    void save(String name)
    {
        tinyDB.putString("name",name);
    }


    String getname()
    {
        String name;
        name=tinyDB.getString("name");
        return name;
    }
}