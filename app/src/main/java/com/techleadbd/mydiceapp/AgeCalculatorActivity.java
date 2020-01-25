package com.techleadbd.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Calendar;

public class AgeCalculatorActivity extends AppCompatActivity {


    public void calculateAge(View buttonView) {

        EditText petBornTextField = findViewById(R.id.etBorn);
        int yourAge = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(petBornTextField.getText().toString());
        TextView showAge = findViewById(R.id.showAge);
        showAge.setText("Your Actual age is: " + yourAge + " year's old");

        YoYo.with(Techniques.Wave)
                .duration(500)
                .repeat(0)
                .playOn(petBornTextField);

        YoYo.with(Techniques.Wave)
                .duration(500)
                .repeat(0)
                .playOn(showAge);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
    }
}
