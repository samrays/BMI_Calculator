package com.example.sam.bmi_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView mWeight;
    EditText mWeightEdit;
    TextView mHeight;
    EditText mHeightEdit;
    Button mBmiButton;
    TextView mBmiResult;
    EditText mDisplayResult;
    TextView mBmiCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeight = findViewById(R.id.weightTextView);
        mWeightEdit = findViewById(R.id.weightEditText);
        mHeight = findViewById(R.id.heightTextView);
        mHeightEdit = findViewById(R.id.heightEditText);
        mBmiButton = findViewById(R.id.bmiButton);
        mBmiResult = findViewById(R.id.bmiResult);
        mDisplayResult = findViewById(R.id.displayBmi);
        mBmiCategory = findViewById(R.id.bmiCategory);

        mBmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = mWeightEdit.getText().toString();
                double weightDouble = Double.parseDouble(weightStr);

                String heightStr = mHeightEdit.getText().toString();
                double heightDouble = Double.parseDouble(heightStr);

                double bmiResult = ((weightDouble) / (heightDouble*heightDouble));
                DecimalFormat decimalFormat = new DecimalFormat("#.#");
                double bmiResultTrimmed = Double.parseDouble(decimalFormat.format(bmiResult));

                mDisplayResult.setText(Double.toString(bmiResultTrimmed));
                //mDisplayResult.setText(Double.toString(bmiResult));

                String BMI_Category;
                if (bmiResult < 15)
                    BMI_Category = "Very severely underweight";
                else if (bmiResult < 16)
                    BMI_Category = "Severely underweight";
                else if (bmiResult < 18.5)
                    BMI_Category = "Underweight";
                else if (bmiResult < 25)
                    BMI_Category = "Normal";
                else if (bmiResult < 30)
                    BMI_Category = "Overweight";
                else if (bmiResult < 35)
                    BMI_Category = "Obese Class 1 - Moderately Obese";
                else if (bmiResult < 40)
                    BMI_Category = "Obese Class 2 - Severely Obese";
                else
                    BMI_Category = "Obese Class 3 - Very Severely Obese";

                mBmiCategory.setText(BMI_Category);

            }


        });
    }
}
