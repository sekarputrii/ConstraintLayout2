package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.LoginFilter;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView3, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan2);

        textView3 = findViewById(R.id.textView3);

        textView5 = findViewById(R.id.textView5);

        Bundle b2 = getIntent().getExtras();
        String Email = b2.getString("Parameter");
        String Password = b2.getString("Parameter2");

        textView3.setText(Email);
        textView5.setText(Password);
    }
}