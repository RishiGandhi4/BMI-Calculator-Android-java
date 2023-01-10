package com.riahi.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editWeight , editHeightInFt , editHeightInIn;
        TextView result;
        Button calculate;
        LinearLayout linLay;

        editWeight = findViewById(R.id.editWeight);
        editHeightInFt = findViewById(R.id.editHeightInFt);
        editHeightInIn = findViewById(R.id.editHeightInIn);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        linLay = findViewById(R.id.linLay);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int wt = Integer.parseInt(editWeight.getText().toString());
             int ht = Integer.parseInt(editHeightInFt.getText().toString());
             int in = Integer.parseInt(editHeightInIn.getText().toString());
             int totalIn = ht * 12 + in;
             double totalcm = totalIn * 2.53;
             double totalm = totalcm/100;

             double bmi = wt/(totalm*totalm);

             if (bmi>25){
                 result.setText("you are over Weighted");
                 linLay.setBackgroundColor(getResources().getColor( R.color.colorOW));
             }else if (bmi<18){
                 result.setText("you are under Weighted");
                 linLay.setBackgroundColor(getResources().getColor( R.color.colorUW));
             }else{
                 result.setText("you are healthy");
                 linLay.setBackgroundColor(getResources().getColor( R.color.colorH));
             }

            }
        });
    }
}