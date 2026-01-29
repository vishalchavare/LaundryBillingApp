package com.example.laundrymanagement;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    public static String DB_NAME="customer_data";
    public static String TABLE_NAME="customers";
    public static String TABLE_NAME1="transactions";
    public static int DATABASE_VERSION=1;
    public static String ID="id";
    public static String TID="tid";
    public static String NAME="name";
    public static String PHONE="phone";
    public static String ADDRESS="address";
    public static String BILL="bill";
    public static String query="create table "+TABLE_NAME+" ("+ID+" integer primary key autoincrement, "+NAME+" varchar(50) , "+PHONE+" varchar(50) , "+ADDRESS +" varchar(50),"+BILL+" double(20)  )";
    public static String query1="create table "+TABLE_NAME1+" ("+TID+" integer primary key autoincrement, "+NAME+" varchar(50) ,"+BILL+" double(20)  )";

    public DBManager(Context context) {
        super(context,DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public void insert_into(String name, String phone,String address,String bill)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("address",address);
        values.put("bill",bill);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public void insert_transaction(String name,String bill)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("bill",bill);
        db.insert(TABLE_NAME1,null,values);
    }

    public ArrayList<String> getUsers()
    {
        ArrayList<String> list=new ArrayList<>();
        String col[]={"name"};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,col,null,null,null,null,null);

        int iName = cursor.getColumnIndex("name");
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {
            list.add(cursor.getString(iName));
        }
        db.close();
        return list;
    }

    public ArrayList<String> getUnpaidUsers()
    {
        ArrayList<String> list=new ArrayList<>();
        String col[]={"name"};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.query(TABLE_NAME,col,"bill > ?",new String[]{"0"},null,null,null);

        int iName=cursor.getColumnIndex("name");
        {
            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext())
            {
                list.add(cursor.getString(iName));
            }
            db.close();
            return list;
        }
    }
    public Cursor fetch_data(String name)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        String s="select * from customers where name = "+"'"+name+"'";
        Cursor cursor=db.rawQuery(s,null);

        return cursor;

    }

    public void update_bill(String id,String bill)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(BILL,bill);
        db.update(TABLE_NAME,values,"id=?",new String[]{id});
        db.close();
    }
    public void update_data(String id,String name,String phone,String address)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, name);
        values.put(PHONE, phone);
        values.put(ADDRESS, address);
        db.update(TABLE_NAME, values, "id=?", new String[]{id});
        db.close();
    }
}