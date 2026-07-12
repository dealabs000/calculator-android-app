package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = 0;
    private boolean shouldResetDisplay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Number buttons
        int[] numberButtonIds = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
                R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(v -> onNumberClick(((Button) v).getText().toString()));
        }

        // Operator buttons
        findViewById(R.id.btn_add).setOnClickListener(v -> onOperatorClick("+"));
        findViewById(R.id.btn_subtract).setOnClickListener(v -> onOperatorClick("-"));
        findViewById(R.id.btn_multiply).setOnClickListener(v -> onOperatorClick("*"));
        findViewById(R.id.btn_divide).setOnClickListener(v -> onOperatorClick("/"));

        // Other buttons
        findViewById(R.id.btn_decimal).setOnClickListener(v -> onDecimalClick());
        findViewById(R.id.btn_equals).setOnClickListener(v -> onEqualsClick());
        findViewById(R.id.btn_clear).setOnClickListener(v -> onClearClick());
    }

    private void onNumberClick(String number) {
        if (shouldResetDisplay) {
            currentInput = number;
            shouldResetDisplay = false;
        } else {
            currentInput += number;
        }
        updateDisplay();
    }

    private void onDecimalClick() {
        if (!currentInput.contains(".")) {
            if (currentInput.isEmpty()) {
                currentInput = "0.";
            } else {
                currentInput += ".";
            }
            updateDisplay();
        }
    }

    private void onOperatorClick(String op) {
        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                onEqualsClick();
            }
            firstValue = Double.parseDouble(currentInput);
            operator = op;
            currentInput = "";
            shouldResetDisplay = true;
        }
    }

    private void onEqualsClick() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(currentInput);
            double result = calculate(firstValue, secondValue, operator);
            currentInput = formatResult(result);
            operator = "";
            shouldResetDisplay = true;
            updateDisplay();
        }
    }

    private void onClearClick() {
        currentInput = "";
        operator = "";
        firstValue = 0;
        shouldResetDisplay = false;
        updateDisplay();
    }

    private double calculate(double first, double second, String op) {
        switch (op) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return second != 0 ? first / second : 0;
            default:
                return 0;
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%.4f", result).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }

    private void updateDisplay() {
        display.setText(currentInput.isEmpty() ? "0" : currentInput);
    }
}
