package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListProductsActivity extends AppCompatActivity {

    //Llamar coneccion con la base de datos
    Database Market;
    //Crear una variable list view
    private ListView productList;
    //Crear un array list
    ArrayList<String> listItem;
    //Crear un adaptador para cada producto
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        listItem = new ArrayList<>();
        productList = findViewById(R.id.lvListProducts);

        viewProducts();
    }

    //este metodo lista todos los productos en listView
    private void viewProducts(){
        Database manager = new Database(this, "Market", null, 1);

        SQLiteDatabase market = manager.getWritableDatabase();

        Cursor row = market.rawQuery("select * from products", null);

        if (row.getCount()>0){
            while(row.moveToNext()){
                listItem.add(row.getString(1));
                listItem.add(row.getString(2));
                listItem.add(row.getString(3));
                listItem.add(row.getString(4));
            }
            adapter = new ArrayAdapter(
                    this, android.R.layout.simple_list_item_1, listItem
            );
            productList.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No hay productos", Toast.LENGTH_SHORT).show();
        }
    }
}
