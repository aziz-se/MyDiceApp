package com.techleadbd.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final ImageView diceImage1 = findViewById(R.id.imgDice1);
         final ImageView diceImage2 = findViewById(R.id.imgDice2);

         final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        final Button btnRoll = findViewById(R.id.btnRollTheDice);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("MyDiceApp","btnRoll is tapped now!");

                Random rnd = new Random();

                int randomNumber = rnd.nextInt(6);//0....5
                diceImage1.setImageResource(diceImages[randomNumber]);

                randomNumber = rnd.nextInt(6);
                diceImage2.setImageResource(diceImages[randomNumber]);

                YoYo.with(Techniques.Wobble)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);

                YoYo.with(Techniques.Wobble)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);

                YoYo.with(Techniques.RollIn)
                        .duration(500)
                        .repeat(0).playOn(btnRoll);
                mp.start();

            }

        });


    }

    public void ageFinder(View view) {
        Intent intent = new Intent(MainActivity.this, AgeCalculatorActivity.class);
        startActivity(intent);
    }
}
