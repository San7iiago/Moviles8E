package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2Activity extends AppCompatActivity {

    private EditText user_name, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        user_name = findViewById(R.id.txtUser);
        passwd = findViewById(R.id.txtPass);
    }

    public void btnLogin(View view){
        Database manager = new Database(this, "Market", null, 1);

        SQLiteDatabase market = manager.getWritableDatabase(); //Permite escribir en la base de datos


        String user = user_name.getText().toString();
        String password = passwd.getText().toString();
        Toast.makeText(this, "Welcome " + user + " your password is: " + password, Toast.LENGTH_SHORT).show();

        if (user.isEmpty() || password.isEmpty()){
            user_name.setError("");
            passwd.setError("");
        } else {
            Cursor row = market.rawQuery("select * from users where email = ? and password = ?", new String[]{user, password});

            if(row.getCount() < 1){
                Toast.makeText(this, "User was not found", Toast.LENGTH_SHORT).show();
                user_name.setError("");
            } else {
                Intent i = new Intent(this, ListProductsActivity.class);
                startActivity(i);
            }
        }
    }

    public void btnGotoRegisterForm (View view){
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
}
