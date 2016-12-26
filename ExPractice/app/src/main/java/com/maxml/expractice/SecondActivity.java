package com.maxml.expractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.maxml.expractice.asdfv.User;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ListView mUsers;
    private ArrayList<User> users;
    private boolean isHeaderOpened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mUsers = (ListView) findViewById(R.id.main_listview);
        users = new ArrayList<>();
        users.add(new User("name", true, 23, "town"));

        mUsers.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users));
        final View header = getLayoutInflater().inflate(R.layout.header_layout, null);
        mUsers.addHeaderView(header);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isHeaderOpened) {

//                    getCreateUser();

                    header.setVisibility(View.VISIBLE);

                } else {
                    header.setVisibility(View.GONE);

                }
                isHeaderOpened = !isHeaderOpened;
            }
        });
    }

    private void getCreateUser(View... editTexts) {
        String[] res = new String[4];
        for (int i = 0; i < 4; i++) {
            EditText buff = (EditText) editTexts[i];

            res[i] = buff.getText().toString();
        }

    }

}
