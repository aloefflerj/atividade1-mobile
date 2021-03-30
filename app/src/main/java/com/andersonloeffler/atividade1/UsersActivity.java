package com.andersonloeffler.atividade1;

import android.content.Intent;
import android.os.Bundle;

import com.andersonloeffler.atividade1.models.Todo;
import com.andersonloeffler.atividade1.models.User;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity
        extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        callJson();
    }


    public void callJson(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                this,
                this
        );

        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try{
            for(int i = 0; i < response.length(); i ++){
                JSONObject json = response.getJSONObject(i);
                User obj = new User(
                json.getInt("id"),
                json.getString("name"),
                json.getString("username"),
                json.getString("email"),
                json.getJSONObject("address")
                );
                users.add(obj);
            }
            Toast.makeText(
                    getApplicationContext(),
                    "Quantidade: " + users.size(),
                    Toast.LENGTH_SHORT
            ).show();
            LinearLayout linearLayout = findViewById(R.id.layoutVerticalItemsUsers);
            for(User obj1: users){
                Button btn = new Button(this);
                btn.setText(obj1.getName());
                btn.setTag(obj1);
                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Button btn = (Button) v;
                        User user = (User) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheUserActivity.class);

                        intent.putExtra("objUser", user);
                        startActivity(intent);
//                        Toast.makeText(getApplicationContext(), "oi", Toast.LENGTH_SHORT).show();
                    }
                });
                linearLayout.addView(btn);
            }
        }catch (JSONException e) {
            Log.e("Erro: ", e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(), "Erro: "+ msg, Toast.LENGTH_SHORT).show();
    }

}