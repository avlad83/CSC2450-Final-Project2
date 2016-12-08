package com.mucsc2450.alex.bmicalculator;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.createChooser;

public class MetricActivity extends AppCompatActivity {

    private Button mButtonCalculate;
    private EditText editTextKilos, editTextMeters;
    private Double meters, kilos, BMI;
    private String resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric);

        mButtonCalculate = (Button) findViewById(R.id.button_calculate);
        editTextKilos = (EditText) findViewById(R.id.kilosInput);
        editTextMeters = (EditText) findViewById(R.id.metersInput);


        mButtonCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                meters = Double.parseDouble(editTextMeters.getText().toString());
                kilos = Double.parseDouble(editTextKilos.getText().toString());

                BMI = (kilos/(meters*meters));

                resultText = Double.toString(BMI);

                Intent i = new Intent(MetricActivity.this, ResultActivity.class);
                i.putExtra("resultText", resultText);
                MetricActivity.this.startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
            return true;
        }
        if (id == R.id.action_us) {
            Intent intent = new Intent(this, USActivity.class);
            startActivity(intent);
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
