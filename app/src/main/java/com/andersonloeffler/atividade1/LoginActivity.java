package com.andersonloeffler.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView userName;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userName.getText().toString().equals(password.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //Passando dados
                    intent.putExtra("usuario", userName.getText().toString());
                    startActivity(intent);
                    finish();
                }

            }
        });
    }


}