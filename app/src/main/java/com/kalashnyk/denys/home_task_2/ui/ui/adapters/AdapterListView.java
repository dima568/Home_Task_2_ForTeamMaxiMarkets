package com.kalashnyk.denys.home_task_2.ui.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.model.Book;

import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class AdapterListView extends BaseAdapter{

    private Context mContext;
    private ArrayList<Book> mBooks;

    public AdapterListView(Context context, ArrayList<Book> books) {
        this.mContext = context;
        this.mBooks = books;
    }

    static class ViewHolder{
        private ImageView imgItem;
        private TextView txtItemTitle;
        private TextView txtItemAuthor;
        private RatingBar rbItem;
    }

    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return mBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.book,parent,false);
            holder = new ViewHolder();
            holder.imgItem = (ImageView)convertView.findViewById(R.id.img_book);
            holder.txtItemTitle = (TextView)convertView.findViewById(R.id.txt_book_title);
            holder.txtItemAuthor = (TextView)convertView.findViewById(R.id.txt_book_author);
            holder.rbItem = (RatingBar)convertView.findViewById(R.id.rating_book);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Book book = (Book)getItem(position);

        holder.imgItem.setImageResource(book.getImage());
        holder.txtItemTitle.setText(book.getTitle());
        holder.txtItemAuthor.setText(book.getAuthor());
        holder.rbItem.setProgress(book.getProgress());

        return convertView;
    }
}
