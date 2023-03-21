package com.example.calcmate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, b_equal, b_multi, b_add, b_sub, b_clear, b_dot, b_bksp, b_modu;
    private TextView t1, t2;

    private double num1=0, num2=0, result=0;
    private String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (TextView) findViewById(R.id.button0);
        button1 = (TextView) findViewById(R.id.button1);
        button2 = (TextView) findViewById(R.id.button2);
        button3 = (TextView) findViewById(R.id.button3);
        button4 = (TextView) findViewById(R.id.button4);
        button5 = (TextView) findViewById(R.id.button5);
        button6 = (TextView) findViewById(R.id.button6);
        button7 = (TextView) findViewById(R.id.button7);
        button8 = (TextView) findViewById(R.id.button8);
        button9 = (TextView) findViewById(R.id.button9);
        b_equal = (TextView) findViewById(R.id.button_equal);
        b_multi = (TextView) findViewById(R.id.button_multi);
        b_add =(TextView) findViewById(R.id.button_add);
        b_sub =(TextView) findViewById(R.id.button_sub);
        b_clear =(TextView) findViewById(R.id.button_clear);
        b_dot =(TextView) findViewById(R.id.button_dot);
        b_bksp = (TextView) findViewById(R.id.button_bksp);
        b_modu = (TextView) findViewById(R.id.button_modu);
        t1 = (TextView) findViewById(R.id.input);
        t2 = (TextView) findViewById(R.id.output);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText().toString() + "9");
            }
        });


        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num2 = Double.parseDouble(t1.getText().toString());
                } catch (NumberFormatException e) {
                    // Handle the case where the input is invalid
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
            }
        });

        b_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Double.parseDouble(t1.getText().toString());
                } catch (NumberFormatException e) {
                    // Handle the case where the input is invalid
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                operator = "*";
                t2.setText(Double.toString(num1) + " *");
                t1.setText("");
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Double.parseDouble(t1.getText().toString());
                } catch (NumberFormatException e) {
                    // Handle the case where the input is invalid
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                operator = "+";
                t2.setText(Double.toString(num1) + " +");
                t1.setText("");
            }
        });

        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Double.parseDouble(t1.getText().toString());
                } catch (NumberFormatException e) {
                    // Handle the case where the input is invalid
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                operator = "-";
                t2.setText(Double.toString(num1) + " -");
                t1.setText("");
            }
        });

        b_modu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    num1 = Double.parseDouble(t1.getText().toString());
                } catch (NumberFormatException e) {
                    // Handle the case where the input is invalid
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                operator = "%";
                t2.setText(Double.toString(num1) + " %");
                t1.setText("");
            }
        });
        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("");
                t2.setText("");
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!t1.getText().toString().contains(".")) {
                    t1.setText(t1.getText().toString() + ".");
                }
            }
        });

        b_bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = t1.getText().toString();
                if (currentText.length() > 0) {
                    t1.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

    }
}