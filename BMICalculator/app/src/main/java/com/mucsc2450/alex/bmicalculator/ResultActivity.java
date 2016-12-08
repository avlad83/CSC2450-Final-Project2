package com.mucsc2450.alex.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent myIntent = getIntent(); // this is just for example purpose
       String result = myIntent.getStringExtra("resultText");
        mResult = (TextView) findViewById(R.id.result);
        mResult.setText(result);



    }
}
