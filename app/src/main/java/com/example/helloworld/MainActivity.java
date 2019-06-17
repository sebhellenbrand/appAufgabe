package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yourButton = (Button) findViewById(R.id.continueButton);

        yourButton.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                TextView weightTextView = findViewById(R.id.weight);
                TextView sizeTextView = findViewById(R.id.size);
                TextView bodyFatTextView = findViewById(R.id.bodyfat);

                intent.putExtra("weight", weightTextView.getText().toString());
                intent.putExtra("size", sizeTextView.getText().toString());
                intent.putExtra("bodyFat", bodyFatTextView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
