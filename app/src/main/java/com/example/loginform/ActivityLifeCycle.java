package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLifeCycle extends AppCompatActivity {
private TextView OnCreate,OnStart,OnResume,OnRestart;   // initializes TextViews
private Button btnStartActivityTwo;                     // Initialize Button for starting Activity Two
private int create,start,resume,restart=0;              // Variables for counting
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        create++;
        OnCreate=findViewById(R.id.OnCreate);
        OnCreate.setText("OnCreate Calls"+create);
        Log.i("ActivityLifeCycle","OnCreate is called");
        btnStartActivityTwo=findViewById(R.id.btnStartActivityTwo);
        btnStartActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityLifeCycle.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart(){               // OnStart Method
        super.onStart();
        start++;
        OnStart=findViewById(R.id.OnStart);
        OnStart.setText("Onstart() Calls:"+start);
        Log.i("ActivityLifeCycle","OnStart method is called");
    }
    protected void onResume(){
        super.onResume();
        resume++;
        OnResume=findViewById(R.id.OnResume);
        OnResume.setText("OnResume() Calls:"+resume);
        Log.i("ActivityLifeCycle","OnResume method is called");
    }
    protected void onRestart(){
        super.onRestart();
        restart++;
        OnRestart=findViewById(R.id.OnRestart);
        OnRestart.setText("OnRestart() Calls:"+restart);
        Log.i("ActivityLifeCycle","OnRestart method is called");
    }
    protected void onPause(){
        super.onPause();
        Log.i("ActivityLifeCycle","OnPause is called");
    }
    protected void onStop(){
        super.onStop();
        Log.i("ActivityLifeCycle","OnStop is called");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i("ActivityLifeCycle","OnDestroy is called");
    }
}