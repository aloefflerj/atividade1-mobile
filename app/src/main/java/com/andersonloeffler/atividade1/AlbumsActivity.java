package com.andersonloeffler.atividade1;

import android.os.Bundle;

import com.andersonloeffler.atividade1.adapter.AlbumAdapter;
import com.andersonloeffler.atividade1.adapter.TodoAdapter;
import com.andersonloeffler.atividade1.models.Album;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity
        extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<Album> albums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        callJson();
    }


    public void callJson(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";

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
                Album obj = new Album(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title")
                );
                albums.add(obj);
            }

            LinearLayoutManager llm = new LinearLayoutManager(this);
            RecyclerView rvAlbums = findViewById(R.id.rvAlbums);
            rvAlbums.setLayoutManager(llm);
            AlbumAdapter albumAdapter = new AlbumAdapter(albums);
            rvAlbums.setAdapter(albumAdapter);

            /*
            Toast.makeText(
                    getApplicationContext(),
                    "Quantidade: " + albums.size(),
                    Toast.LENGTH_SHORT
            ).show();
            LinearLayout linearLayout = findViewById(R.id.layoutVerticalItemsAlbums);
            for(Album obj1: albums){
                Button btn = new Button(this);
                btn.setText(obj1.getTitle());
                btn.setTag(obj1);
                btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Button btn = (Button) v;
                        Album album = (Album) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), DetalheAlbumActivity.class);

                        intent.putExtra("objAlbum", album);
                        startActivity(intent);
                    }
                });
                linearLayout.addView(btn);
            }*/
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