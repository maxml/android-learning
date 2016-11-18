package com.maxml.expainter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class PlayActivity extends Activity {

    private DrawingView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (DrawingView) findViewById(R.id.signature_canvas);
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }

}
