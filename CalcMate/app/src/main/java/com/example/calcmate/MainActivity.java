package com.example.calcmate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView t1, t2;

    private double num1=0, num2=0, result=0;
    private String operator="";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView button0 = (TextView) findViewById(R.id.button0);
        TextView button1 = (TextView) findViewById(R.id.button1);
        TextView button2 = (TextView) findViewById(R.id.button2);
        TextView button3 = (TextView) findViewById(R.id.button3);
        TextView button4 = (TextView) findViewById(R.id.button4);
        TextView button5 = (TextView) findViewById(R.id.button5);
        TextView button6 = (TextView) findViewById(R.id.button6);
        TextView button7 = (TextView) findViewById(R.id.button7);
        TextView button8 = (TextView) findViewById(R.id.button8);
        TextView button9 = (TextView) findViewById(R.id.button9);
        TextView b_equal = (TextView) findViewById(R.id.button_equal);
        TextView b_multi = (TextView) findViewById(R.id.button_multi);
        TextView b_add = (TextView) findViewById(R.id.button_add);
        TextView b_div = (TextView) findViewById(R.id.button_divide);
        TextView b_sub = (TextView) findViewById(R.id.button_sub);
        TextView b_clear = (TextView) findViewById(R.id.button_clear);
        TextView b_dot = (TextView) findViewById(R.id.button_dot);
        TextView b_bksp = (TextView) findViewById(R.id.button_bksp);
        TextView b_modu = (TextView) findViewById(R.id.button_modu);
        t1 = (TextView) findViewById(R.id.input);
        t2 = (TextView) findViewById(R.id.output);

        button0.setOnClickListener(v -> t1.setText(t1.getText().toString() + "0"));
        button1.setOnClickListener(v -> t1.setText(t1.getText().toString() + "1"));
        button2.setOnClickListener(v -> t1.setText(t1.getText().toString() + "2"));
        button3.setOnClickListener(v -> t1.setText(t1.getText().toString() + "3"));
        button4.setOnClickListener(v -> t1.setText(t1.getText().toString() + "4"));
        button5.setOnClickListener(v -> t1.setText(t1.getText().toString() + "5"));
        button6.setOnClickListener(v -> t1.setText(t1.getText().toString() + "6"));
        button7.setOnClickListener(v -> t1.setText(t1.getText().toString() + "7"));
        button8.setOnClickListener(v -> t1.setText(t1.getText().toString() + "8"));
        button9.setOnClickListener(v -> t1.setText(t1.getText().toString() + "9"));
        b_equal.setOnClickListener(v -> {
            try {
                num2 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }
            switch(operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                default:
                    // Handle the case where the operator is not set
                    Toast.makeText(MainActivity.this, "No operator selected", Toast.LENGTH_SHORT).show();
                    return;
            }
            t2.setText(Double.toString(result));
            t1.setText(Double.toString(result));
        });

        b_div.setOnClickListener(v -> {
            try {
                num1 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            operator = "/";
            t2.setText(num1 + " /");
            t1.setText("");
        });

        b_multi.setOnClickListener(v -> {
            try {
                num1 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            operator = "*";
            t2.setText(num1 + " *");
            t1.setText("");
        });

        b_add.setOnClickListener(v -> {
            try {
                num1 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            operator = "+";
            t2.setText(num1 + " +");
            t1.setText("");
        });

        b_sub.setOnClickListener(v -> {
            try {
                num1 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            operator = "-";
            t2.setText(num1 + " -");
            t1.setText("");
        });

        b_modu.setOnClickListener(v -> {
            try {
                num1 = Double.parseDouble(t1.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                return;
            }

            operator = "%";
            t2.setText(num1 + " %");
            t1.setText("");
        });
        b_clear.setOnClickListener(v -> {
            t1.setText("");
            t2.setText("");
        });

        b_dot.setOnClickListener(v -> {
            if (!t1.getText().toString().contains(".")) {
                t1.setText(t1.getText().toString() + ".");
            }
        });

        b_bksp.setOnClickListener(v -> {
            String currentText = t1.getText().toString();
            if (currentText.length() > 0) {
                t1.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

    }
}