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
import ItemsClassi.ItemScar;

public class DataBaseScarico extends SQLiteOpenHelper {

    private final Context context;

    public DataBaseScarico(@Nullable Context context) {
        super(context, "Scarico",null,Constants.DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + "Scarico" + " ("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY, "
                + Constants.KEY_DATA + " TEXT,"
                + Constants.KEY_BATTITO + " TEXT, "
                + Constants.KEY_SONNO + " TEXT, "
                + Constants.KEY_INTENSITA + " TEXT); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Scarico");
        onCreate(sqLiteDatabase);
    }
    public void addItem(ItemScar item){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_BATTITO,item.getBattito());
        values.put(Constants.KEY_INTENSITA,item.getIntensita());
        values.put(Constants.KEY_SONNO, item.getSonno());
        values.put(Constants.KEY_DATA,item.getData());
        sqLiteDatabase.insert("Scarico",null,values);
        Log.d("DBHANDLER","added Item ");
    }
    @SuppressLint("Range")
    public ItemScar getItem(int id){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.query("Scarico",
                new String[]{Constants.KEY_ID,
                        Constants.KEY_DATA,
                        Constants.KEY_BATTITO,
                        Constants.KEY_SONNO,
                        Constants.KEY_INTENSITA,},
                Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        ItemScar item=new ItemScar();
        item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
        item.setBattito(cursor.getString(cursor.getColumnIndex(Constants.KEY_BATTITO)));
        item.setSonno(cursor.getString(cursor.getColumnIndex(Constants.KEY_SONNO)));
        item.setIntensita(cursor.getString(cursor.getColumnIndex(Constants.KEY_INTENSITA)));
        item.setData(cursor.getString(cursor.getColumnIndex(Constants.KEY_DATA)));
        return item;
    }

    @SuppressLint("Range")
    public List<ItemScar> getAllItems(){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        List<ItemScar> itemList = new ArrayList<>();
        Cursor cursor= sqLiteDatabase.query("Scarico",
                new String[]{Constants.KEY_ID,
                        Constants.KEY_DATA,
                        Constants.KEY_BATTITO,
                        Constants.KEY_SONNO,
                        Constants.KEY_INTENSITA},
                null,null,null,null,Constants.KEY_ID + " DESC");
        if(cursor.moveToFirst()){
            do {
                ItemScar item=new ItemScar();
                item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                item.setBattito(cursor.getString(cursor.getColumnIndex(Constants.KEY_BATTITO)));
                item.setSonno(cursor.getString(cursor.getColumnIndex(Constants.KEY_SONNO)));
                item.setIntensita(cursor.getString(cursor.getColumnIndex(Constants.KEY_INTENSITA)));
                item.setData(cursor.getString(cursor.getColumnIndex(Constants.KEY_DATA)));
                itemList.add(item);
            }while (cursor.moveToNext());
        }
        return itemList;
    }

    public int updateItem(ItemScar item){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Constants.KEY_BATTITO,item.getBattito());
        values.put(Constants.KEY_SONNO, item.getSonno());
        values.put(Constants.KEY_INTENSITA, item.getIntensita());
        values.put(Constants.KEY_DATA,item.getData());
        return sqLiteDatabase.update("Scarico",values,Constants.KEY_ID+ "=?",
                new String[]{String.valueOf(item.getId())});
    }
    public void deleteItem(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete("Scarico",Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public int getItemsCount(){
        String countQuery ="SELECT * FROM " + "Scarico";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(countQuery,null);
        return cursor.getCount();
    }




}
