package com.maxml.expermission;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ExEntity mainEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainEntity = new ExEntity();
        mainEntity.setId(123);
        mainEntity.setName("entityName");
        mainEntity.setDescription("idDesc");
        mainEntity.setLocation("Kyiv");

        ArrayList<String> photos = new ArrayList<>();
        photos.add("photo1");
        photos.add("photo2");

        mainEntity.setImageUrls(photos);
        mainEntity.setTimeStart(new Date().getTime());
        mainEntity.setTimeEnd(new Date().getTime());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(ExConstants.INTENT_EXTRA_NAME, mainEntity);
                startActivity(intent);
            }
        });
    }
}
