package com.maxml.expermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);

        if (getIntent() != null) {
            ExEntity entity = getIntent()
                    .getParcelableExtra(ExConstants.INTENT_EXTRA_NAME);

            textView.setText(entity.toString());
        }
    }
}
