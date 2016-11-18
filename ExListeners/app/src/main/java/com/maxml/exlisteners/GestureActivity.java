package com.maxml.exlisteners;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GestureActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gestureDetector = new GestureDetector(this, new GestureListener());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
               return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean eventConsumed = gestureDetector.onTouchEvent(event);
        if (eventConsumed) {
            return true;
        } else
            return false;
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "single tap", Toast.LENGTH_SHORT).show();
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "long press", Toast.LENGTH_SHORT).show();
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Toast.makeText(GestureActivity.this, "scroll", Toast.LENGTH_SHORT).show();
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Toast.makeText(GestureActivity.this, "fling", Toast.LENGTH_SHORT).show();
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "show press", Toast.LENGTH_SHORT).show();
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "down", Toast.LENGTH_SHORT).show();
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "double tap", Toast.LENGTH_SHORT).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "double tap event", Toast.LENGTH_SHORT).show();
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "sngle tap confirmed", Toast.LENGTH_SHORT).show();
            return super.onSingleTapConfirmed(e);
        }
    }

}
