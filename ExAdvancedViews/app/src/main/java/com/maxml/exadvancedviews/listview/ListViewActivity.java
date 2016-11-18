package com.maxml.exadvancedviews.listview;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.maxml.exadvancedviews.R;
import com.maxml.exadvancedviews.entity.ModelObject;
import com.maxml.exadvancedviews.expandable.ExpActivity;

public class ListViewActivity extends ActionBarActivity {

    public String[] titles = new String[]{"Strawberry", "Banana", "Orange",
            "Mixed"};

    public String[] descriptions = new String[]{
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits"};

    private View viewContainer;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ListView lView = (ListView) findViewById(R.id.listView1);
        viewContainer = findViewById(R.id.undobar);
        viewContainer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(ListViewActivity.this, "Deletion undone",
                        Toast.LENGTH_LONG).show();
                viewContainer.setVisibility(View.GONE);
            }
        });

        final ArrayList<ModelObject> models = new ArrayList<ModelObject>();
        for (int i = 0; i < titles.length; i++) {
            ModelObject mObject = new ModelObject(R.mipmap.ic_launcher,
                    titles[i], descriptions[i]);
            models.add(mObject);
        }

        //choices
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titles);

        adapter = new CustomAdapter(this, R.layout.ex_list_item, models);

        lView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.testArray,
                android.R.layout.simple_list_item_multiple_choice);
        //end choices

        lView.setAdapter(adapter);
        lView.setOnItemClickListener(new OnItemClickListener() {

            @SuppressLint("NewApi")
            private void showUndo() {
                viewContainer.setVisibility(View.VISIBLE);
                viewContainer.setAlpha(1);
                viewContainer.animate().alpha(0.4f).setDuration(5000)
                        .withEndAction(new Runnable() {

                            @Override
                            public void run() {
                                viewContainer.setVisibility(View.GONE);
                            }
                        });

            }

            @SuppressLint("NewApi")
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                final ModelObject item = (ModelObject) parent
                        .getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                models.remove(position);
                                models.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);

                                showUndo();
                            }
                        });
            }

        });

        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewActivity.this,
                        ExpActivity.class);
                startActivity(intent);
            }
        });
    }
}
