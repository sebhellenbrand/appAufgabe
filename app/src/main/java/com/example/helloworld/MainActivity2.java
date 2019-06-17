package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = getIntent().getExtras();
        String weight = b.getString("weight");
        String size = b.getString("size");
        String fat = b.getString("bodyFat");

        TextView weightTextView = findViewById(R.id.weight);
        weightTextView.setText(weight);

        TextView sizeTextView = findViewById(R.id.size);
        sizeTextView.setText(size);

        TextView fatTextView = findViewById(R.id.fat);
        fatTextView.setText(fat);

        TextView resultTextView = findViewById(R.id.result);
        String ffmi = String.valueOf(
                calculateFFMI(
                        Double.parseDouble(weight),
                        Double.parseDouble(size),
                        Double.parseDouble(fat)
                )
        );
        resultTextView.setText(ffmi);


    }

    public double calculateFFMI(double weight, double size, double bodyFat){
        double ffm = weight * (1 - (bodyFat/100));
        double counter = size / 100 * size / 100 + 6.3 * (1.8 - size / 100);

        double ffmi = ffm / counter;

        return ffmi;
    }
}
