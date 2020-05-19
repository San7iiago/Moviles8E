package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    //Instance id's from XML form design
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View vieColors = null;
    private TextView color = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the id's from xml form design
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        vieColors = findViewById(R.id.vieColors);

        color = findViewById(R.id.selectColor);

        //Set Seekbar Change on moving
        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

        // Enable on context Menu on view component
        registerForContextMenu(vieColors);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int color = Color.argb(a,r,g,b);
        vieColors.setBackgroundColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void change(int red, int green, int blue, int alpha){
        sbrRed.setProgress(red);
        sbrGreen.setProgress(green);
        sbrBlue.setProgress(blue);
        sbrAlpha.setProgress(alpha);

        int color = Color.argb(sbrAlpha.getProgress(), sbrRed.getProgress(),sbrGreen.getProgress(),sbrBlue.getProgress());
        vieColors.setBackgroundColor(color);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.reset :
                change(0,0,0,0);
                return true;
            case R.id.btnHelp :
                startActivity(new Intent(MainActivity.this, Help.class));
                return true;
            case R.id.aboutOf :
                startActivity(new Intent(MainActivity.this, AboutOf.class));
                return true;
            case R.id.close :
                System.exit(0);
                return true;
            case R.id.btnRestart :
                change(0,0,0,0);
                color.setText("");
                return true;
            case R.id.iteTransparent :
                change(0,0,0,0);
                color.setText("Transparent");
                return true;
            case R.id.iteSemitransparent :
                change(0,0,0,125);
                color.setText("Semitransparent");
                return true;
            case R.id.iteOpaque :
                change(0,0,0,255);
                return true;
            case R.id.iteYellow :
                change(241,196,15,125);
                return true;
            case R.id.iteBlue :
                change(52,152,219,125);
                color.setText("Blue");
                return true;
            case R.id.iteRed :
                change(244,67,54,125);
                return true;
            case R.id.iteGreen :
                change(46,204,113,125);
                return true;
            case R.id.iteBrown :
                change(121,85,72,125);
                return true;
            case R.id.iteBlack :
                change(33, 33,33,125);
                return true;
            case R.id.itePink :
                change(245,0,87,125);
                return true;
            case R.id.itePurple :
                change(94,53,177,125);
                return true;
            case R.id.iteWhite :
                change(238,238,238,125);
                return true;
            case R.id.iteGray :
                change(158,158,158,125);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.reset :
                change(0,0,0,0);
                return true;
            case R.id.btnHelp :
                startActivity(new Intent(MainActivity.this, Help.class));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}

