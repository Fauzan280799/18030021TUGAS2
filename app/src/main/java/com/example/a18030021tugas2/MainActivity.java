package com.example.a18030021tugas2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private ImageView myImage;
    private Button buttonfoto;
    private Button buttonkeluar;
    private Uri file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonkeluar = (Button) findViewById(R.id.buttonkeluar);
        buttonkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });

        myImage = (ImageView) findViewById(R.id.myImage);
        buttonfoto = (Button) findViewById(R.id.buttonfoto);
        buttonfoto.setOnClickListener(new View.OnClickListener() { //buat tombol foto
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
    }
    private void takePicture() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //file = Uri.fromFile(getOutputMediaFile());
        //i.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(i, 0);
    }

    private void exit() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bitmap b = (Bitmap) data.getExtras().get("data");
            myImage.setImageBitmap(b);
        }
    }
    //private static File getOutputMediaFile() {
      //  File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Camera");
        //if (!mediaStorageDir.exists()) {
          //  if (!mediaStorageDir.mkdirs()) {
            //    return null;
            //}
        //}
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_MMmmss").format(new Date());
        //return new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
    //}

}
