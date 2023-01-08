package data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import provaembrionale.Constants;

import java.util.ArrayList;
import java.util.List;

import ItemsClassi.Item;

public class QuintoDatab extends SQLiteOpenHelper {
    public QuintoDatab(@Nullable Context context) {
        super(context, "DataVen",null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + "Venerdi" + " ("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY, "
                + Constants.KEY_EXERCISE + " TEXT, "
                + Constants.KEY_REPS + " TEXT, "
                + Constants.KEY_REST + " TEXT, "
                + Constants.KEY_WEIGHT + " TEXT); ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Venerdi");
        onCreate(sqLiteDatabase);

    }

    public void addItem(Item item){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.KEY_REST,item.getItemRest());
        values.put(Constants.KEY_EXERCISE,item.getItemName());
        values.put(Constants.KEY_REPS, item.getItemRep());
        values.put(Constants.KEY_WEIGHT, item.getItemPeso());



        sqLiteDatabase.insert("Venerdi",null,values);

        Log.d("DBHANDLER","added Item ");










    }
    @SuppressLint("Range")
    public Item getItem(int id){


        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.query("Venerdi",
                new String[]{Constants.KEY_ID,
                        Constants.KEY_EXERCISE,
                        Constants.KEY_REPS,
                        Constants.KEY_REST,
                        Constants.KEY_WEIGHT},
                Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        Item item=new Item();

        item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
        item.setItemName(cursor.getString(cursor.getColumnIndex(Constants.KEY_EXERCISE)));
        item.setItemRep(cursor.getString(cursor.getColumnIndex(Constants.KEY_REPS)));
        item.setItemPeso(cursor.getString(cursor.getColumnIndex(Constants.KEY_WEIGHT)));
        item.setItemRest(cursor.getString(cursor.getColumnIndex(Constants.KEY_REST)));



        return item;


    }

    @SuppressLint("Range")
    public List<Item> getAllItems(){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        List<Item> itemList = new ArrayList<>();


        Cursor cursor= sqLiteDatabase.query("Venerdi",
                new String[]{Constants.KEY_ID,
                        Constants.KEY_EXERCISE,
                        Constants.KEY_REPS,
                        Constants.KEY_REST,
                        Constants.KEY_WEIGHT},
                null,null,null,null,Constants.KEY_ID + " DESC");


        if(cursor.moveToFirst()){
            do {
                Item item=new Item();
                item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                item.setItemName(cursor.getString(cursor.getColumnIndex(Constants.KEY_EXERCISE)));
                item.setItemRep(cursor.getString(cursor.getColumnIndex(Constants.KEY_REPS)));
                item.setItemPeso(cursor.getString(cursor.getColumnIndex(Constants.KEY_WEIGHT)));
                item.setItemRest(cursor.getString(cursor.getColumnIndex(Constants.KEY_REST)));



                itemList.add(item);
            }while (cursor.moveToNext());
        }

        return itemList;


    }

    public int updateItem(Item item){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Constants.KEY_EXERCISE,item.getItemName());
        values.put(Constants.KEY_REPS, item.getItemRep());
        values.put(Constants.KEY_WEIGHT, item.getItemPeso());
        values.put(Constants.KEY_REST, item.getItemRest());



        return sqLiteDatabase.update("Venerdi",values,Constants.KEY_ID+ "=?",
                new String[]{String.valueOf(item.getId())});








    }
    public void deleteItem(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete("Venerdi",Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)});

        sqLiteDatabase.close();
    }

    public int getItemsCount(){
        String countQuery ="SELECT * FROM " + "Venerdi";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(countQuery,null);
        return cursor.getCount();
    }
}

