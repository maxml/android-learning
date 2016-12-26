package com.maxml.expractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView);

//        User entity = new User("", 20);
//        User entity2 = new User("", 20);

//        if(entity.equals(entity2)) {
//            Log.e(MainActivity.class.getName(), "first");
//        }
//
//        if(entity.equals(entity)) {
//            Log.e(MainActivity.class.getName(), "second");
//        }
//
//        if(entity == entity2) {
//            Log.e(MainActivity.class.getName(), "third");
//        }


        final EditText editText = (EditText) findViewById(R.id.editText2);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("".equals(editText.getText())) {
                    return;
                }
                if (TextUtils.isEmpty(editText.getText())) {
                    return;
                }

                double neededValue = Double.valueOf(editText.getText().toString());

                textView.setText("" + neededValue % 10);

                Toast.makeText(MainActivity.this, "" + neededValue / 10, Toast.LENGTH_SHORT).show();

                Log.e(MainActivity.class.getName(), "" + (neededValue * 1234));

                Snackbar.make(findViewById(android.R.id.content), "" + 23, Snackbar.LENGTH_SHORT).show();

            }
        });
    }
}
