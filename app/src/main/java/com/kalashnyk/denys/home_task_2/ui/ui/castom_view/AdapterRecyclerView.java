package com.kalashnyk.denys.home_task_2.ui.ui.castom_view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.model.Book;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ClassViewHolder>
{
    private Context mContext;
    private ArrayList mData;
    private int mAttrLayout;

    public AdapterRecyclerView(Context context, ArrayList booksData, int attrLayout) {
        this.mContext = context;
        this.mData = booksData;
        this.mAttrLayout = attrLayout;
    }

    static class ClassViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView imgItem;
        TextView titleItem;
        TextView authorItem;
        RatingBar rbItem;

        public ClassViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            this.imgItem = (ImageView) itemView.findViewById(R.id.img_book);
            this.titleItem = (TextView) itemView.findViewById(R.id.txt_book_title);
            this.authorItem = (TextView) itemView.findViewById(R.id.txt_book_author);
            this.rbItem = (RatingBar) itemView.findViewById(R.id.rating_book);
        }
    }
    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (mAttrLayout) {
            case Constants.ATTR_LAYOUT_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_grid, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_lin, parent, false);
        }

        ClassViewHolder classViewHolder = new ClassViewHolder(view);
        return classViewHolder;
    }
    @Override
    public void onBindViewHolder(ClassViewHolder holder, final int position) {
        Book book = (Book) mData.get(position);
        holder.imgItem.setImageResource(book.getImage());
        holder.titleItem.setText(book.getTitle());
        holder.authorItem.setText(book.getAuthor());
        holder.rbItem.setProgress(book.getProgress());
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
}