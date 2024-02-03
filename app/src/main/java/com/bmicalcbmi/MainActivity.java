package com.bmicalcbmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWt, edtHeightInch, edtFeetHeight;
        LinearLayout mainLayOut;
        Button btnCalcBmi;
        TextView txtResult, bmiResult;

        mainLayOut = findViewById(R.id.mainLayout);
        edtWt = findViewById(R.id.edtWeight);
        edtHeightInch = findViewById(R.id.edtInHeight);
        edtFeetHeight = findViewById(R.id.edtHeightFt);
        btnCalcBmi = findViewById(R.id.btnCalc);
        txtResult = findViewById(R.id.txtResult);
        bmiResult = findViewById(R.id.bmiResult);


        btnCalcBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt, Hf, Hi;

                if (edtWt.getText().toString().isEmpty()) {
                    txtResult.setText("Please provide weight.");
                   return;
                }
                if (edtFeetHeight.getText().toString().isEmpty()) {
                    txtResult.setText("Please provide feet height.");
                    return;
                }
                if (edtHeightInch.getText().toString().isEmpty()) {
                    txtResult.setText("Please provide inch height.");
                return;
                }

                wt = Integer.parseInt(edtWt.getText().toString());
                Hf = Integer.parseInt(edtFeetHeight.getText().toString());
                Hi = Integer.parseInt(edtHeightInch.getText().toString());

                int totalInch = Hf * 12 + Hi;
                double totalCm = totalInch * 2.54;
                double totalmt = totalCm / 100;
                double bmi = wt / (totalmt * totalmt);
                String formattedBmi = String.format("%.2f", bmi);

                if (bmi > 25) {
                    txtResult.setText("You are Overweight");
                    bmiResult.setText(formattedBmi);
                    mainLayOut.setBackgroundColor(getResources().getColor(R.color.Overweight));

                } else if (bmi < 18) {
                    txtResult.setText("You are UnderWeight");
                    bmiResult.setText(formattedBmi);
                    mainLayOut.setBackgroundColor(getResources().getColor(R.color.Underweight));
                } else {
                    txtResult.setText("You are healthy");
                    bmiResult.setText(formattedBmi);
                    mainLayOut.setBackgroundColor(getResources().getColor(R.color.Healthyweight));
                }
            }
        });
    }
}
