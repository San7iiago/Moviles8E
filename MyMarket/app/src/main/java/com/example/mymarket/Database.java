package com.example.mymarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) { //market es el nombre de la BD
        market.execSQL("create table users (" +    //Crear tabla usuarios y sus campos
                "id int primary key autoincrement not null, " +
                "email text not null, " +
                "password text not null)");

        market.execSQL("create table products (" +    //Crear tabla productos y sus campos
                "id int primary key autoincrement not null, " +
                "prod_name text not null, " +
                "description text not null, " +
                "unit_price, " +
                "quantity)");

        /*market.execSQL("insert into products (" +
                "prod_name, description, unit_price, quantity," +
                "quantity)");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
