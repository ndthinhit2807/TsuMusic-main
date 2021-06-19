package com.example.tsumusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.tsumusic.R;

public class UserguideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userguide);
        Anhxa();

    }

    private void Anhxa() {
        Toolbar toolbar = findViewById(R.id.toolbarguide);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Các tính năng chính");
        TextView txtuserguide = (TextView) findViewById(R.id.textviewguide);
        String userguide = getResources().getString(R.string.guide);
        txtuserguide.setText(Html.fromHtml(userguide));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideLeft(UserguideActivity.this);
            }
        });
    }
}