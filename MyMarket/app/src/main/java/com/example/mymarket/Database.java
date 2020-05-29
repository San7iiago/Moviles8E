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
                "id integer primary key autoincrement not null, " +
                "email text not null unique, " +
                "password text not null)");

        market.execSQL("create table products (" +    //Crear tabla productos y sus campos
                "id integer primary key autoincrement not null, " +
                "prod_name text not null, " +
                "description text not null, " +
                "unit_price float, " +
                "quantity integer)");

        market.execSQL("create table cities (" +    //Crear tabla productos y sus campos
                "id integer primary key autoincrement not null, " +
                "city_name text not null, " +
                "description text not null, " +
                "abrev text not null)");

        market.execSQL("insert into " +
                "products (prod_name, description, unit_price, quantity) " +
                "values ('TENNIS','TENNIS ADIDAS WHITE T40',100000,50)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
