package com.maxml.exbundle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = "main-log";

    private final static String BUNDLE_NAME = "bundle-name";
    private final static String BUNDLE_EMAIL = "bundle-email";
    private final static String BUNDLE_PASSWORD = "bundle-pass";

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEmail = (EditText) findViewById(R.id.main_email);
        mName = (EditText) findViewById(R.id.main_name);
        mPassword = (EditText) findViewById(R.id.main_pass);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(LOG_TAG, "onSaveInstanceState");

        outState.putString(BUNDLE_NAME, mName.getText().toString());
        outState.putString(BUNDLE_EMAIL, mEmail.getText().toString());
        outState.putString(BUNDLE_PASSWORD, mPassword.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onRestoreInstanceState");

        mName.setText(savedInstanceState.getString(BUNDLE_NAME));
        mEmail.setText(savedInstanceState.getString(BUNDLE_EMAIL));
        mPassword.setText(savedInstanceState.getString(BUNDLE_PASSWORD));

        super.onRestoreInstanceState(savedInstanceState);
    }
}
