package com.kalashnyk.denys.home_task_2.ui.utils;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.model.Book;
import com.kalashnyk.denys.home_task_2.ui.model.Genre;
import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class Constants {
    public static final String ATTR_GROUP_NAME = "authorName";
    public static final String ATTR_CHILD_NAME = "bookName";
    public static final int ATTR_LAYOUT_LIN = 1;
    public static final int ATTR_LAYOUT_GRID = 2;
    public static String[] mGroupsAuthor =  {"Михаил Булгаков","Эрнест Хемингуей"};

    public static String[] mBulgakovBooks = {"Белаая гвардия","Собачье сердце"};
    public static String[] mHemiBooks = {"Прощай оружие","По ком звонит колокол"};

    private static final String[] AUTHORS = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов", "J R R Tolkien","J R R Tolkien","J R R Tolkien"};

    private static final String[] BOOKS = {
            "Морфий","Белая гвардия","Прощай оружие","По ком звонит колокол",
            "Заводной апельсин","1984","Тихий Дон",
            "Игра престолов","Пикник на обочине","Трудно быть богом",
            "Палата №6","Жалобная книга", "Lord of the Rings: The Fellowship of the Ring",
            "Lord of the Rings: The Two Towers",
            "Lord of the Rings: The Return of the King"};

    private static final int[] IMAGES_BOOK = {
            R.drawable.img_book_morphine,
            R.drawable.img_book_white,
            R.drawable.img_book_farewell_to_arms,
            R.drawable.img_book_fom_whom,
            R.drawable.img_book_orange,
            R.drawable.img_book_1984,
            R.drawable.img_book_don,
            R.drawable.img_book_game,
            R.drawable.img_book_picnic,
            R.drawable.img_book_hard_to_be,
            R.drawable.img_book_ward,
            R.drawable.img_book_comp,
            R.drawable.fellowship_of_the_ring,
            R.drawable.the_two_towers,
            R.drawable.return_of_the_king
    };

    private static final int[] RATING = {4,4,5,8,7,8,9,4,8,7,8,8,6,6,6};

    private static final String[] GENRE = {"Фэнтези","Приключения","Детектив","Фантастика",
            "История","Киберпанк","Антиутопия","Сатира"};

    private static final int[] IMAGES_GENRE = {
            R.drawable.img_genre_fantasy22,
            R.drawable.img_genre_adv,
            R.drawable.img_genre_detec,
            R.drawable.img_genre_fantastic,
            R.drawable.img_genre_history,
            R.drawable.img_genre_cyber,
            R.drawable.img_genre_anti,
            R.drawable.img_genre_sat};

    public ArrayList getBooksData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<AUTHORS.length; i++){
            arrayList.add(new Book()
                    .setImage(IMAGES_BOOK[i])
                    .setTitle(BOOKS[i])
                    .setAuthor(AUTHORS[i])
                    .setProgress(RATING[i]));
        }
        return arrayList;
    }

    public ArrayList getGenreData(){
        ArrayList arrayList = new ArrayList();
        for (int i=0; i<GENRE.length; i++){
            arrayList.add(new Genre()
                    .setImage(IMAGES_GENRE[i])
                    .setName(GENRE[i]));
        }
        return arrayList;
    }
}
