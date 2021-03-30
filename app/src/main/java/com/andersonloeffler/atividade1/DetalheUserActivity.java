package com.andersonloeffler.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.andersonloeffler.atividade1.models.User;

public class DetalheUserActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_user);
        Intent intent = getIntent();
        User user = intent.getParcelableExtra("objUser");

        TextView tv = findViewById(R.id.tvUserId);
        tv.setText(user.getId()+"");
        tv = findViewById(R.id.tvUserName);
        tv.setText(user.getName()+"");
        tv = findViewById(R.id.tvUserUsername);
        tv.setText(user.getUsername());
        tv = findViewById(R.id.tvUserEmail);
        tv.setText(user.getEmail());

    }
}