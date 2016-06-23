package com.saas.findthepercent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageTxt;
    EditText numberTxt;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageTxt = (EditText) findViewById(R.id.percentageTxt);
        numberTxt = (EditText) findViewById(R.id.numberTxt);

        calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(percentageTxt.getText().toString().trim().length() > 0){
                    if(numberTxt.getText().toString().trim().length() > 0){
                        System.out.println("Percentage Text: " + percentageTxt.getText().toString());
                        float percentage = Float.parseFloat(percentageTxt.getText().toString());
                        float dec = percentage / 100;
                        float number = Float.parseFloat(numberTxt.getText().toString());
                        float total = dec * number;
                        totalTextView.setText(Float.toString(total));
                    }else {
                        Toast.makeText(MainActivity.this, "Number field can not be blank", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Percentage field can not be blank", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
