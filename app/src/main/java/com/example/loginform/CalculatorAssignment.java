package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorAssignment extends AppCompatActivity {
private EditText et1,et2;
private TextView tv1;
private Spinner spin;
private Button calculate;
String check="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_assignment);
et1=findViewById(R.id.etVal1);
et2=findViewById(R.id.etVal2);
tv1=findViewById(R.id.result);
spin=findViewById(R.id.sp1);
calculate=findViewById(R.id.btnCalculate);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.operation, android.R.layout.simple_spinner_item);//new ArrayAdapter<String>(CalculatorAssignment.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.funs));
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        try {
                            Toast.makeText(CalculatorAssignment.this,"select",Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(CalculatorAssignment.this,"Select",Toast.LENGTH_SHORT).show();
                        }
                    case 1:
                        check="Add";
                        break;
                    case 2:
                        check="Subtract";
                        break;
                    case 3:
                        check="Multiply";
                        break;
                    case 4:
                        check="Divide";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(CalculatorAssignment.this,"Nothing Selected",Toast.LENGTH_SHORT).show();
            }
        });
try {
    calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String val1 = et1.getText().toString();
            String val2 = et2.getText().toString();

            float val1Int = 0;
            float val2Int = 0;
            val1Int = Float.parseFloat(val1);
            val2Int = Float.parseFloat(val2);


            if (check.equals("Add")) {

                Add a = new Add();
                float x = a.Add(val1Int, val2Int);


                tv1.setText(String.valueOf(x));
            }
            if (check.equals("Subtract")) {

                Subtract s = new Subtract();
                float x = s.subtract(val1Int, val2Int);
                tv1.setText(String.valueOf(x));
            }

        }
    });
}catch (Exception e){
    Toast.makeText(CalculatorAssignment.this, "pleae select correct", Toast.LENGTH_SHORT).show();
}
    }
}