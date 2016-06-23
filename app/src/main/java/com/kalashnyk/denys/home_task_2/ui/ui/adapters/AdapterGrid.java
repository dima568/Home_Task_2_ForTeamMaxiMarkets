package com.kalashnyk.denys.home_task_2.ui.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.model.Genre;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class AdapterGrid extends BaseAdapter {
    private Context mContext;
    private ArrayList mGenres;

    public AdapterGrid(Context context, ArrayList genres) {
        this.mContext = context;
        this.mGenres = genres;
    }

    static class ViewHolder{
        private ImageView imgItem;
        private TextView txtItem;
    }

    @Override
    public int getCount() {
        return mGenres.size();
    }

    @Override
    public Object getItem(int position) {
        return mGenres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.genre,parent,false);
            holder = new ViewHolder();
            holder.imgItem = (ImageView)convertView.findViewById(R.id.img_genre);
            holder.txtItem = (TextView)convertView.findViewById(R.id.txt_genre);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Genre genre = (Genre)getItem(position);
        Picasso
                .with(mContext)
                .load(genre.getImage())
                .resize(150,150)
                .into(holder.imgItem);
        holder.imgItem.setImageResource(genre.getImage());
        holder.txtItem.setText(genre.getName());

        return convertView;
    }
}
