package com.example.mychatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    Model model;
    RecyclerView recyclerView;
    EditText editText;
    CardView button;
    String que;
    RvAdapter adapter;
    ArrayList<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.minAc_rv);
        editText=findViewById(R.id.tvmsg);
        button=findViewById(R.id.semd);
        models=new ArrayList<>();
        model=new Model("hi");
        models.add(model);
        adapter=new RvAdapter(models);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(adapter);
        model=new Model("hi");
        models.add(model);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                que=editText.getText().toString();
                editText.setText("");
//                model=new Model(que);
//                models.add(model);
               // adapter.notifyDataSetChanged();
                 getAns(que);
                Toast.makeText(MainActivity.this, "called", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private  void getAns(String msg)
    {
       /* Call<Model> call=Retrofitclien.getInstance(msg).getapi().getAns();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                model=response.body();
                models.add(model);
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, ""+model.getCnt(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "some error", Toast.LENGTH_SHORT).show();
            }
        });*/

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://api.brainshop.ai/get?bid=165946&key=0KiXSBDeXZ4wZQtb&uid=[uid]&msg=[hello]/";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        updateui();
                        // Display the first 500 characters of the response string.textView.setText("Response is: " + response.substring(0,500));
                       // Toast.makeText(MainActivity.this, response.substring(0,500), Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                updateui();
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

       JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
                    updateui();
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();//
           }
       });

// Add the request to the RequestQueue.
        queue.add(request);
    }


    void updateui()
    {
        model=new Model(que);
         adapter.add(model);
         adapter.notifyDataSetChanged();
    }
}