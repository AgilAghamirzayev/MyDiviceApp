package com.aqil.mydiviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImg1 = findViewById(R.id.imgDice1);
        final ImageView diceImg2 = findViewById(R.id.imgDice2);

        final int [] diceImage = {R.drawable.dice1,R.drawable.dice2, R.drawable.dice3, R.drawable.dice4,
        R.drawable.dice5, R.drawable.dice6};

        Button btnRoll = findViewById(R.id.btn);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rndObject = new Random();
                int myRandomNumber = rndObject.nextInt(6);
                diceImg1.setImageResource(diceImage[myRandomNumber]);

                myRandomNumber = rndObject.nextInt(6);
                diceImg2.setImageResource(diceImage[myRandomNumber]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));


                mp.start();
            }
        });



    }
}
