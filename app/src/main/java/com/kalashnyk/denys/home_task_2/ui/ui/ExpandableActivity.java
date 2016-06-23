package com.kalashnyk.denys.home_task_2.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.ui.castom_view.RecyclerCastomActivity;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 21.06.2016.
 */
public class ExpandableActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        initialise();
    }
    private void initialise(){
        Button followRecycler = (Button) findViewById(R.id.follow_recycler);
        followRecycler.setOnClickListener(this);

        setTitle(R.string.text_activity_exp_title);

        Map map;

        ArrayList<Map<String,String>> groupDataList = new ArrayList();
        for (String author: Constants.mGroupsAuthor){
            map = new HashMap();
            map.put(Constants.ATTR_GROUP_NAME,author);
            groupDataList.add(map);
        }

        String[] groupFrom = {Constants.ATTR_GROUP_NAME};
        int[] groupTo = {android.R.id.text1};
        String[] childFrom = {Constants.ATTR_CHILD_NAME};
        int[] childTo = {android.R.id.text1};

        ArrayList<ArrayList<Map<String,String>>> childDataList = new ArrayList<>();
        ArrayList<Map<String,String>> childDataItemList = new ArrayList<>();

        for (String book: Constants.mBulgakovBooks){
            map = new HashMap();
            map.put(Constants.ATTR_CHILD_NAME,book);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        childDataItemList = new ArrayList<>();
        for (String book: Constants.mHemiBooks){
            map = new HashMap();
            map.put(Constants.ATTR_CHILD_NAME,book);
            childDataItemList.add(map);
        }
        childDataList.add(childDataItemList);

        SimpleExpandableListAdapter adapter =
                new SimpleExpandableListAdapter(this,
                        groupDataList,android.R.layout.simple_expandable_list_item_1,groupFrom,groupTo,
                        childDataList,android.R.layout.simple_list_item_1,childFrom,childTo);

        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.expandable_list_view);
        expandableListView.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_recycler:
                Intent intent = new Intent(ExpandableActivity.this, RecyclerCastomActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
