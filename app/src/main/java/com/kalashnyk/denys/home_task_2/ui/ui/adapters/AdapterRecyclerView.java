package com.kalashnyk.denys.home_task_2.ui.ui.adapters;

import android.content.Context;
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

/**
 * Created by User on 21.06.2016.
 */
public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.BookViewHolder> {

    private Context mContext;
    private ArrayList mBooksData;
    private int mAttrLayout;

    public AdapterRecyclerView(Context context, ArrayList booksData, int attrLayout) {
        this.mContext = context;
        this.mBooksData = booksData;
        this.mAttrLayout = attrLayout;
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem;
        TextView titleItem;
        TextView authorItem;
        RatingBar rbItem;

        public BookViewHolder(View itemView) {
            super(itemView);
            this.imgItem = (ImageView) itemView.findViewById(R.id.img_book);
            this.titleItem = (TextView) itemView.findViewById(R.id.txt_book_title);
            this.authorItem = (TextView) itemView.findViewById(R.id.txt_book_author);
            this.rbItem = (RatingBar) itemView.findViewById(R.id.rating_book);
        }
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (mAttrLayout) {
            case Constants.ATTR_LAYOUT_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_grid, parent, false);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_lin, parent, false);
        }

        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = (Book) mBooksData.get(position);
//        ImageView imageView = holder.imgItem;
//        Picasso
//                .with(mContext)
//                .load(book.getImage())
//                .into(imageView);
        holder.imgItem.setImageResource(book.getImage());
        holder.titleItem.setText(book.getTitle());
        holder.authorItem.setText(book.getAuthor());
        holder.rbItem.setProgress(book.getProgress());
    }

    @Override
    public int getItemCount() {
        return mBooksData.size();
    }
}
