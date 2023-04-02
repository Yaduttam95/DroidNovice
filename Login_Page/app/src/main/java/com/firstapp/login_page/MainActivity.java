package com.firstapp.login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Declare
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextUserId);
        ed3 = findViewById(R.id.editTextPassword);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(ed1.getText().toString().length()>0 && ed2.getText().toString().length()>0 && ed3.getText().toString().length()>0){
                    Toast.makeText(MainActivity.this, "Redirecting", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Redirected.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter Details", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}