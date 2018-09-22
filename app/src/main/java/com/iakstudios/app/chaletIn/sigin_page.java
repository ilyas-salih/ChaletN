package com.iakstudios.app.chaletIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sigin_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_page);
    }

    public void Goregister(View view) {
        Intent intent=new Intent(sigin_page.this, MainActivity.class);
        startActivity(intent);
    }
}
