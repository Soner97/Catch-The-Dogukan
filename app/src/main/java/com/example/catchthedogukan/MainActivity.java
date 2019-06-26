package com.example.catchthedogukan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView puanText;
    int puan;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageArray[];
    Handler handler;
    Runnable runnable;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        puanText= (TextView) findViewById(R.id.puanText);
        imageView= findViewById(R.id.imageView);
        imageView1= findViewById(R.id.imageView1);
        imageView2= findViewById(R.id.imageView2);
        imageView3= findViewById(R.id.imageView3);
        imageView4= findViewById(R.id.imageView4);
        imageView5= findViewById(R.id.imageView5);
        imageView6= findViewById(R.id.imageView6);
        imageView7= findViewById(R.id.imageView7);
        imageView8= findViewById(R.id.imageView8);

        imageArray= new ImageView[]{imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8};


        resimleriSakla();


        puan=0;





         new CountDownTimer(10000,100){

             @Override
             public void onTick(long millisUntilFinished) {
             textView1.setText("ZAMAN: "+ millisUntilFinished/1000);
             }

             @Override
             public void onFinish() {

                 textView1.setText("Zaman Bitti");
                 handler.removeCallbacks(runnable);


                 AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                 alert.setTitle("Yeniden?");
                 alert.setMessage("Yeniden Oynamak İster Misiniz?");
                 alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         //oyunu yeniden başlatma

                         Intent intent=getIntent();
                         finish();
                         startActivity(intent);
                     }
                 });


                 alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Toast.makeText(MainActivity.this,"Oyun Bitti",Toast.LENGTH_SHORT).show();
                     }
                 });

                 alert.show();


             }
         }.start();




    }


    public void puaniArttir (View view) {

        puan++;


      puanText.setText("PUAN: "+puan);

    }


    public void resimleriSakla(){

        handler = new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {


                for (ImageView  image: imageArray){

                    image.setVisibility(View.INVISIBLE);
                }

                Random random= new Random();
                int i= random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,300);


            }
        };


        handler.post(runnable);


    }
}
