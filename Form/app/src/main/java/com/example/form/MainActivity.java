package com.example.form;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button validateButton;
    TextView t1, t2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView5);
        spinner = findViewById(R.id.spinner);
        validateButton = findViewById(R.id.button1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        RadioGroup radioGroup = findViewById(R.id.radio_group);

        validateButton.setOnClickListener(v -> {
            String selectedCity = spinner.getSelectedItem().toString();
            if (selectedCity.equals("SELECT")) {
                Toast.makeText(MainActivity.this, "Please select a city", Toast.LENGTH_SHORT).show();
            }
            else if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
            }
            else {
                String finalRadioValue = "";
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int index = radioGroup.indexOfChild(radioButton);

                switch (index) {
                    case 0:
                        finalRadioValue = "Male";
                        break;
                    case 1:
                        finalRadioValue = "Female";
                        break;
                    case 2:
                        finalRadioValue = "Rather Not Say";
                        break;
                }
                t1.setText("Selected City = " + selectedCity);
                t2.setText("Selected Gender = " + finalRadioValue);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
            }
        });

    }
}