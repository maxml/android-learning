package com.maxml.exdrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private final static String URL = "http://www.w3schools.com/css/img_fjords.jpg";
    //Wrong url
    private final static String ERROR_URL = "http://www.freeiconspng.com/uploads/error-icon-44678.png";

    private final static String CIRCULAR_URL = "https://support.files.wordpress.com/2009/07/pigeony.jpg?w=688";

    private ImageView simpleView;
    private ImageView viewWithPlaceholder;
    private ImageView viewWithResize;
    private ImageView circularView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleView = (ImageView) findViewById(R.id.simpleImage);
        viewWithPlaceholder = (ImageView) findViewById(R.id.imageWithPlaceholder);
        viewWithResize = (ImageView) findViewById(R.id.imageWithResize);
        circularView = (ImageView) findViewById(R.id.circularImage);

        setImageToBasicView();
        setImageWithPlaceholder();
        setImageWithResize();
        setCircularImage();
    }

    private void setCircularImage() {
        Picasso.with(this).load(CIRCULAR_URL)
                .placeholder(R.drawable.ic_placeholder)
                .transform(new CircularTransformation()) //optional for converting image in circular image
                .into(circularView);
    }

    private void setImageWithResize() {
        Picasso.with(this)
                .load(URL)
                .resize(500, 400)                        // optional for resizing image
                .rotate(90)                             // optional for rotating image
                .into(viewWithResize);

    }

    private void setImageWithPlaceholder() {
        Picasso.with(this)
                .load(ERROR_URL)
                .placeholder(R.drawable.ic_placeholder) // optional for adding placeholder
                .error(R.drawable.ic_error)         // optional for adding error fallback
                .into(viewWithPlaceholder);

    }

    private void setImageToBasicView() {
        Picasso.with(this)
                .load(URL)
                .into(simpleView);

    }
}