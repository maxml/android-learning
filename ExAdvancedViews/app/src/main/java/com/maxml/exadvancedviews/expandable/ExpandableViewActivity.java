package com.maxml.exadvancedviews.expandable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.maxml.exadvancedviews.R;

import java.util.ArrayList;

public class ExpandableViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_view);

        // Находим наш list
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandableListView);

        //Создаем набор данных для адаптера
        ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
        ArrayList<String> children1 = new ArrayList<String>();
        ArrayList<String> children2 = new ArrayList<String>();
        children1.add("Child_1");
        children1.add("Child_2");
        groups.add(children1);
        children2.add("Child_1");
        children2.add("Child_2");
        children2.add("Child_3");
        groups.add(children2);

        //Создаем адаптер и передаем context и список с данными
        ExpListAdapter adapter = new ExpListAdapter(getApplicationContext(), groups);
        listView.setAdapter(adapter);
    }

    public class ExpListAdapter extends BaseExpandableListAdapter {

        private ArrayList<ArrayList<String>> mGroups;
        private Context mContext;

        public ExpListAdapter(Context context, ArrayList<ArrayList<String>> groups) {
            mContext = context;
            mGroups = groups;
        }

        @Override
        public int getGroupCount() {
            return mGroups.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mGroups.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mGroups.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mGroups.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.expandable_group_view, null);
            }

            if (isExpanded) {
                //Изменяем что-нибудь, если текущая Group раскрыта
            } else {
                //Изменяем что-нибудь, если текущая Group скрыта
            }

            TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
            textGroup.setText("Group " + Integer.toString(groupPosition));

            return convertView;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.expandable_child_view, null);
            }

            TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
            textChild.setText(mGroups.get(groupPosition).get(childPosition));

            Button button = (Button) convertView.findViewById(R.id.buttonChild);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "button is pressed", Toast.LENGTH_LONG).show();
                }
            });

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}
