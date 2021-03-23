package com.andersonloeffler.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greetingsText = findViewById(R.id.userGreetings);
        Button goBackToSplashButton = findViewById(R.id.goBackToSplash);
        Button goBackToLoginButton = findViewById(R.id.goBackToLogin);

        //Recuperando valores do login
        Bundle dados = getIntent().getExtras();
        String userName = dados.getString("usuario");

        greetingsText.setText("Olá, " + userName);

        /*AÇÕES DOS BOTÕES------------------->*/
        //Botão de voltar para splash screen
        goBackToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Botão de voltar para splash screen
        goBackToSplashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SplashScreenActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}