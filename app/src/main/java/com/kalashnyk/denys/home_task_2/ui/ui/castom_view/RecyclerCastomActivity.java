package com.kalashnyk.denys.home_task_2.ui.ui.castom_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.ui.adapters.AdapterRecyclerView;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;

public class RecyclerCastomActivity extends AppCompatActivity {



    private ArrayList mData;
    private MoleskineRecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterRecyclerView mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initialise();
    }

    private void initialise(){
        setTitle(R.string.text_activity_recycler_title);
        Constants data = new Constants();
        mData = data.getBooksData();
        mRecyclerView = (MoleskineRecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new com.kalashnyk.denys.home_task_2.ui.ui.adapters.AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rec_menu_lin:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_LIN);
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.rec_menu_grid:
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_GRID);
                mRecyclerView.setAdapter(mAdapter);
        }
        return super.onOptionsItemSelected(item);
    }
}
//    private MoleskineRecyclerView recyclerView;
//    private GridLayoutManager lLayout;
//        lLayout = new GridLayoutManager(this, 4);
//
//        recyclerView = (MoleskineRecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(lLayout);
////        String [] titlebooks = getResources().getStringArray(R.array.title_books);
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, titlebooks);
//        ArrayList<String> photos = new ArrayList<>();
//        photos.addAll(Arrays.asList(getResources().getStringArray(R.array.authors_books)));
//        //Set adapter to RecyclerView
//        recyclerView.setAdapter(new AdapterRecyclerView(photos, this));
//        //Set Toasts to the Views