package com.andersonloeffler.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.andersonloeffler.atividade1.models.Comment;
import com.andersonloeffler.atividade1.models.User;

public class DetalheCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_comment);

        Intent intent = getIntent();
        Comment comment = intent.getParcelableExtra("objComment");

        TextView tv = findViewById(R.id.tvCommentPostId);
        tv.setText(comment.getPostId()+"");
        tv = findViewById(R.id.tvCommentId);
        tv.setText(comment.getId()+"");
        tv = findViewById(R.id.tvCommentName);
        tv.setText(comment.getName());
        tv = findViewById(R.id.tvCommentEmail);
        tv.setText(comment.getEmail());
        tv = findViewById(R.id.tvCommentBody);
        tv.setText(comment.getBody());

    }
}