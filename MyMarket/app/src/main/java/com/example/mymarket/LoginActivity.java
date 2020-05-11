package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user_name, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.txtUsername);
        passwd = findViewById(R.id.txtPassword);
    }

    public void btnLogin(View view){
        String user = user_name.getText().toString();
        String password = passwd.getText().toString();
        Toast.makeText(this, "Welcome " + user + " your password is: " + password, Toast.LENGTH_SHORT).show();
    }
}
