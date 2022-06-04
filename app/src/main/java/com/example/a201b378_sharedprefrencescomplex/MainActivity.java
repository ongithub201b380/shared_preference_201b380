package com.example.a201b378_sharedprefrencescomplex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    String []winnerArray={"Rahul","Rohan","Priya"};
    public void storedPrefrences(View view){
        sharedPreferences.edit().putString("players",new Gson().toJson(winnerArray)).apply();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.a201b378_sharedprefrencescomplex", Context.MODE_PRIVATE);
        String[] temp=new Gson().fromJson(sharedPreferences.getString("players",null),winnerArray.getClass());
        textView.setText(Arrays.toString(temp));
    }
}