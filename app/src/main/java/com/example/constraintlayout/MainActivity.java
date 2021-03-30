package com.example.constraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTextPersonName, editTextTextPassword;
    Button button;
    String Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = editTextTextPersonName.getText().toString();
                Password = editTextTextPassword.getText().toString();

                //Mengecek apakah isi dari email dan password sudah sama dengan email dan login
                if (Username.equals("sekarputri@gmail.com") && Password.equals("Sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Success, \nUsername : " + Username + "\nPassword : " + Password, Toast.LENGTH_LONG);
                    s.show();
                    Bundle b = new Bundle();
                    b.putString("Parameter", Username.trim());
                    b.putString("Parameter2", Password.trim());


                    Intent NewIntent = new Intent(MainActivity.this, MainActivity2.class);
                    NewIntent.putExtras(b);
                    startActivity(NewIntent);
                } else if (!Username.equals("sekarputri@gmail.com") && Password.equals("Sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Login Failed (Wrong Username Entered)", Toast.LENGTH_LONG);
                    s.show();
                } else if (Username.equals("sekarputri@gmail.com") && !Password.equals("Sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Login Failed (Wrong Password Entered)", Toast.LENGTH_LONG);
                    s.show();
                } else {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Failed", Toast.LENGTH_LONG);
                    s.show();
                }
            }
        });
    }

    public boolean validasiData() {
        //Mengeset email yang benar
        String nameActive = "sekarputri@gmail.com";
        //Mengeset password yang benar
        String passwordActive = "Sekar83";
        //Mengecek apakah isi dari email dan password sudah sama dengan email dan login
        if (nameActive.equals(editTextTextPersonName.getText().toString()) && passwordActive.equals(editTextTextPassword.getText().toString())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.formulir) {
            Intent intent = new Intent(getApplicationContext(), Home_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}