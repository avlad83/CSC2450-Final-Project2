package com.mucsc2450.alex.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.createChooser;

public class MainActivity extends AppCompatActivity {
    private Button mButtonMetric, mButtonUS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonMetric = (Button) findViewById(R.id.button_metric);
        mButtonUS = (Button) findViewById(R.id.button_US);

        mButtonMetric.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, MetricActivity.class);
                MainActivity.this.startActivity(i);
            }

        });

        mButtonUS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, USActivity.class);
                MainActivity.this.startActivity(i);
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
            return true;
        }
        if (id == R.id.action_metric) {
            Intent intent = new Intent(this, MetricActivity.class);
            startActivity(intent);
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
