package com.kalashnyk.denys.home_task_2.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.ui.adapters.AdapterListView;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mListView;
    private ArrayList mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialise();
    }
    private void initialise(){
        Button followGridList = (Button) findViewById(R.id.follow_grid);
        followGridList.setOnClickListener(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Constants data = new Constants();
        mData = data.getBooksData();
        Bundle bundle = new Bundle();
        AdapterListView adapter = new AdapterListView(this, mData);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_grid:
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
