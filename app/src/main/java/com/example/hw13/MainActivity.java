package com.example.hw13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "myApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fio = findViewById(R.id.fio);
                String fioValue = fio.getText().toString();
                EditText age = findViewById(R.id.age);
                String ageValue = age.getText().toString();

                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    insert value = new insert(fioValue, Integer.parseInt(ageValue));

                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Неверный формат", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button buttonPressure = findViewById(R.id.buttonPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, pressure.class);
                startActivity(intent);

            }
        });

        Button buttonEtc = findViewById(R.id.buttonEtc);
        buttonEtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intentEtc=new Intent(MainActivity.this, etc.class);
                try {
                    startActivity(intentEtc);
                }

                catch (Exception ex)
                {
                    Toast.makeText(MainActivity.this, "ошибка", Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}

