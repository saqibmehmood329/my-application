package com.example.loginform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class imagecapture extends AppCompatActivity {
private Button btnCamera;
private ImageView ivimageView;
private int  requestcode=14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagecapture);

                btnCamera=findViewById(R.id.button6);
                ivimageView=findViewById(R.id.imageView);

                btnCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(CheckSelfPermission()){
                            requestPermission();
                        }
                        else{
                            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,requestcode);
                        }

                    }
                });
    }

    public boolean CheckSelfPermission(){
        if(ContextCompat.checkSelfPermission(imagecapture.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            return false;
        }
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions(imagecapture.this,new String[]{Manifest.permission.CAMERA},requestcode);
    }
    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode==14){
            if(resultcode==RESULT_OK){
                Bundle b=data.getExtras();
                Bitmap bitmap=(Bitmap)b.get("data");
                ivimageView.setImageBitmap(bitmap);
            }
        }
    }
}