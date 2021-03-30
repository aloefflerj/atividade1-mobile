package com.andersonloeffler.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.andersonloeffler.atividade1.models.Album;

public class DetalheAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_album);

        Intent intent = getIntent();
        Album album = intent.getParcelableExtra("objAlbum");

        TextView tv = findViewById(R.id.tvAlbumUserId);
        tv.setText(album.getUserId()+"");
        tv = findViewById(R.id.tvAlbumId);
        tv.setText(album.getId()+"");
        tv = findViewById(R.id.tvAlbumTitle);
        tv.setText(album.getTitle());
    }
}