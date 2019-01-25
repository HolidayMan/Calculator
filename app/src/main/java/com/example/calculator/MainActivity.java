package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumInput;
    private EditText secondNumInput;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumInput = findViewById(R.id.firstNum);
        secondNumInput = findViewById(R.id.secondNum);
        answer = findViewById(R.id.answer);
    }

    public void checker(View view) {
        String firstNum = firstNumInput.getText().toString();
        String secondNum = secondNumInput.getText().toString();

        if (firstNum.equals("") || secondNum.equals("")) { // checking if both inputs are empty
            answer.setText(R.string.answer_text);
        } else {
            if (firstNum.replaceAll("[+-.]", "").length() > 9 || secondNum.replaceAll("[+-.]", "").length() > 9) { // checking if input is longer than 9 symbols excepting ".", "+", "-"
                answer.setText(R.string.too_big_number);
            } else {
                int operation = view.getId(); // getting clicked button

                switch (operation) {
                    // all the ternary operators in switch case are used to convert double numbers like 1.0 to int
                    case R.id.sum:
                        double ans1 = Double.valueOf(firstNum) + Double.valueOf(secondNum);
                        answer.setText(ans1 != Math.round(ans1) ? Double.toString(ans1): Long.toString(Math.round(ans1)));
                        break;
                    case R.id.sub:
                        double ans2 = Double.valueOf(firstNum) - Double.valueOf(secondNum);
                        answer.setText(ans2 != Math.round(ans2) ? Double.toString(ans2): Long.toString(Math.round(ans2)));
                        break;
                    case R.id.mul:
                        double ans3 = Double.valueOf(firstNum) * Double.valueOf(secondNum);
                        answer.setText(ans3 != Math.round(ans3) ? Double.toString(ans3): Long.toString(Math.round(ans3)));
                        break;
                    case R.id.div:
                        if (secondNum.equals("0")) answer.setText(R.string.zero_division); // if divided by zero
                        else {
                            double ans4 = Double.valueOf(firstNum) / Double.valueOf(secondNum);
                            answer.setText(ans4 != Math.round(ans4) ? Double.toString(ans4): Long.toString(Math.round(ans4)));
                        }
                        break;
                }
            }
        }
    }
}
