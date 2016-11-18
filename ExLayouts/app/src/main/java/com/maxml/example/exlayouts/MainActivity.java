package com.maxml.example.exlayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.maxml.example.exlayouts.listener.DefaultButtonListener;
import com.maxml.example.exlayouts.util.Randomiser;

public class MainActivity extends AppCompatActivity {

    private final static int ROW_SIZE = 5;
    private final static int TABLE_SIZE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout);
        OnClickListener listener = new DefaultButtonListener(this);

        for (int i = 0; i < TABLE_SIZE; i++) {
            TableRow tRow = new TableRow(this);
            for (int j = 0; j < ROW_SIZE; j++) {

                Button button = new Button(this);
                button.setText(Randomiser.getRandomText());
                button.setOnClickListener(listener);

                tRow.addView(button, j);
            }

            tableLayout.addView(tRow, i);
        }
    }

}
