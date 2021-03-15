package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView OnCreate,OnStart,OnResume,OnRestart;
    private Button btnStartActivityOne;
    private int create,start,resume,restart=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        create++;
        OnCreate=findViewById(R.id.OnCreate);
        OnCreate.setText("OnCreate Calls"+create);
        Log.i("MainActivity3","OnCreate is called");
        btnStartActivityOne=findViewById(R.id.btnStartActivityTwo);
        btnStartActivityOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,ActivityLifeCycle.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        start++;
        OnStart=findViewById(R.id.OnStart);
        OnStart.setText("Onstart() Calls:"+start);
        Log.i("MainActivity3","OnStart is called");
    }
    protected void onResume(){
        super.onResume();
        resume++;
        OnResume=findViewById(R.id.OnResume);
        OnResume.setText("OnResume() Calls:"+resume);
        Log.i("MainActivity3","OnResume method is called");
    }
    protected void onRestart(){
        super.onRestart();
        restart++;
        OnRestart=findViewById(R.id.OnRestart);
        OnRestart.setText("OnRestart() Calls:"+restart);
        Log.i("MainActivity3","OnRestart method is called");
    }
    protected void onPause(){
        super.onPause();
        Log.i("MainActivity3","OnPause is called");
    }
    protected void onStop(){
        super.onStop();
        Log.i("MainActivity3","OnStop is called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i("MainActivity3","OnDestroy is called");
    }
}