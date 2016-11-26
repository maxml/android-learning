package com.maxml.exlisteners;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Maxml on 18.11.2016.
 */

public class ExListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
