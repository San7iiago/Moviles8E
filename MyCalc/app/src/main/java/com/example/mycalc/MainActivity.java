package com.example.mycalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.txtDisplay);
        display.setText("0");
    }

    public void insertar(String numero) {
        if (display.getText().toString()=="0" && numero == ","){
            display.setText(display.getText()+numero);
        } else if (display.getText().toString()=="0"){
            display.setText(numero);
        } else {
            display.setText(display.getText()+numero);
        }
    }

    public void btn0(View view){
        insertar("0");
    }
    public void btn1(View view){
        insertar("1");
    }
    public void btn2(View view){
        insertar("2");
    }
    public void btn3(View view){
        insertar("3");
    }
    public void btn4(View view){
        insertar("4");
    }
    public void btn5(View view){
        insertar("5");
    }
    public void btn6(View view){
        insertar("6");
    }
    public void btn7(View view){
        insertar("7");
    }
    public void btn8(View view){
        insertar("8");
    }
    public void btn9(View view){
        insertar("9");
    }
    public void btnMas(View view){
        insertar("+");
    }
    public void btnMenos(View view){
        insertar("-");
    }
    public void btnMultiplicacion(View view){
        insertar("*");
    }
    public void btnDivicion(View view){
        insertar("/");
    }
    public void btnPorcentaje(View view){
        insertar("%");
    }
    public void btnPunto(View view){
        insertar(",");
    }
    public void btnIgual(View view){
        display.setText("Hola!");
    }

    public void btnAC(View view){
        display.setText("0");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dark :
                Toast.makeText(this, "Dark", Toast.LENGTH_SHORT).show();
            case R.id.white :
                Toast.makeText(this, "White", Toast.LENGTH_SHORT).show();
            case R.id.classic :
                Toast.makeText(this, "Classic", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
