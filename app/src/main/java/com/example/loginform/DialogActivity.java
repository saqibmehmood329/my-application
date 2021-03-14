package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class DialogActivity extends AppCompatActivity {
    TextView dateTextView,timeTextView;
Button dateButton,timeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
     dateTextView=findViewById(R.id.tvDate);
     timeTextView=findViewById(R.id.tvTime);
     dateButton=findViewById(R.id.btnDate);
     timeButton=findViewById(R.id.btnTime);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateButton();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeButton();
            }
        });
    }
    private void handleDateButton(){
        Calendar calendar=Calendar.getInstance();
int YEAR=calendar.get(Calendar.YEAR);
int MONTH=calendar.get(Calendar.MONTH);
int DATE=calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
String dataString=year+":"+month+":"+dayOfMonth;
dateTextView.setText(dataString);
            }
        },YEAR,MONTH,DATE);
        datePickerDialog.show();
    }
    private void handleTimeButton(){
Calendar calendar=Calendar.getInstance();
int HOUR=calendar.get(Calendar.HOUR);
int MINUTE=calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString="hours: "+hourOfDay+" Minute: "+minute;
                timeTextView.setText(timeString);
            }
        },HOUR,MINUTE,false);
        timePickerDialog.show();
    }
}