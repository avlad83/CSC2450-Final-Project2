package com.mucsc2450.alex.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.createChooser;

public class USActivity extends AppCompatActivity {

    private Button mButtonCalculate;
    private EditText editTextPounds, editTextInches;
    private Double inches, pounds, BMI;
    private String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_us);


        mButtonCalculate = (Button) findViewById(R.id.button_calculate);
        editTextPounds = (EditText) findViewById(R.id.poundsInput);
        editTextInches = (EditText) findViewById(R.id.inchesInput);


        mButtonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inches = Double.parseDouble(editTextInches.getText().toString());
                pounds = Double.parseDouble(editTextPounds.getText().toString());

                BMI = ((pounds / (inches * inches))*703);

                resultText = Double.toString(BMI);

                Intent i = new Intent(USActivity.this, ResultActivity.class);
                i.putExtra("resultText", resultText);
                USActivity.this.startActivity(i);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        if (id == R.id.action_metric) {
            Intent intent = new Intent(this, MetricActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_us) {
            return true;
        }

        if (id == R.id.action_contact) {
            /* Create the Intent */
            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

/* Fill it with Data */
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"to@email.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

/* Send it off to the Activity-Chooser */
            startActivity(createChooser(emailIntent, "Send mail..."));
        }
        return super.onOptionsItemSelected(item);
    }
}
