package com.example.loginform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {
private TextView tvListItem;
private ListView listView;
private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        data=new ArrayList<>();
        for(int i=0;i<20;i++) {
            data.add("android");
            data.add("IOS");
            data.add("Mac");
            data.add("Linux");
            data.add("Unix");
            data.add("windows");
            data.add("Dos");
            tvListItem = findViewById(R.id.tvlistitem);
            listView = findViewById(R.id.listView);
            ArrayAdapter arrayAdapter = new ArrayAdapter(Listview.this, R.layout.list_item, R.id.tvlistitem, data);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(Listview.this);
                    builder.setTitle("Delete").setMessage("Are you sure you want to delete").setIcon(R.mipmap.ic_launcher);
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            data.remove(position);
                            arrayAdapter.notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Listview.this, "User don't want to delete this item", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                    return false;
                }
            });
        }

    }
}