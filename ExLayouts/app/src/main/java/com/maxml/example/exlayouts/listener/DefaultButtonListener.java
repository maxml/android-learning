package com.maxml.example.exlayouts.listener;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.maxml.example.exlayouts.util.Randomiser;

public class DefaultButtonListener implements OnClickListener {

    private Context context;

    public DefaultButtonListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String toastText = Randomiser.getRandomText();
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
    }

}
