package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class form_baru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_baru);
    }

    public class ActivityMenu1 extends AppCompatActivity {

        EditText Nama, Alamat, eEmail, ePassword, erPassword;

        FloatingActionButton fab;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form_baru);

            Nama = findViewById(R.id.Nama);
            Alamat = findViewById(R.id.Alamat);
            eEmail = findViewById(R.id.eEmail);
            ePassword = findViewById(R.id.ePassword);
            erPassword = findViewById(R.id.erPassword);
            fab = findViewById(R.id.floatingActionButton);
            fab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (Nama.getText().toString().isEmpty() ||
                            Alamat.getText().toString().isEmpty() ||
                            eEmail.getText().toString().isEmpty() ||
                            ePassword.getText().toString().isEmpty() ||
                            erPassword.getText().toString().isEmpty()) {
                        Snackbar.make(view, "WAJIB!!! (Mengisikan Seluruh Data)", Snackbar.LENGTH_LONG).show();
                    } else {
                        if (ePassword.getText().toString().equals(erPassword.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Pendaftaran yang Dilakukan Berhasil",
                                    Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Snackbar.make(view, "Password pertama dan Password kedua harus sama !!!!",
                                    Snackbar.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
    }
}