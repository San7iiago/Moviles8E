package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLDataException;

public class SignupActivity extends AppCompatActivity {

    private EditText username, passwd, rpasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.txtUsername);
        passwd = findViewById(R.id.txtPassword);
        rpasswd = findViewById(R.id.txtRPassword);
    }

    //Method to create a new user
    public void btnSignUp(View view){
        Database manager = new Database(this, "Market", null, 1);

        SQLiteDatabase market = manager.getWritableDatabase(); //Permite escribir en la base de datos

        //Obtener valores
        String usrname = username.getText().toString();
        String password = passwd.getText().toString();
        String rpassword = rpasswd.getText().toString();

        if (usrname.equals("") || password.equals("") || rpassword.equals("")){
            Toast.makeText(this, "There are empty fields", Toast.LENGTH_SHORT).show();
            username.setError("");
            passwd.setError("");
            rpasswd.setError("");
        } else {
            if (!password.equals(rpassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                passwd.setError("");
                rpasswd.setError("");
            } else {

                Cursor row = market.rawQuery("select * from users where email = ? LIMIT 1", new String[]{usrname});

                if (row.moveToNext()){ //row.getCount() > 0
                    Toast.makeText(this, "The user already exist", Toast.LENGTH_SHORT).show();
                    username.setError("");
                } else {
                    ContentValues data = new ContentValues(); //Data es como un array list pero contiene los valores
                    data.put("email", usrname);//Campo como se llama en la BD, variable
                    data.put("password", password);
                    market.insert("users", null, data);
                    market.close();

                    Toast.makeText(this, "Has been register", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Login2Activity.class);
                    startActivity(i);
                }
            }
        }
    }
}
