package com.example.hw13;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myApp";
    ArrayList<String> main = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText fio = findViewById(R.id.fio);
        final EditText age = findViewById(R.id.age);



        Button buttonSave = findViewById(R.id.save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fioValue = fio.getText().toString();
                final String ageValue = age.getText().toString();
                if ((fioValue.length() == 0) || (ageValue.length() == 0)) {
                    Toast.makeText(MainActivity.this, getString(R.string.small), Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    PatientData value = new PatientData(fioValue, Integer.parseInt(ageValue));

                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, getString(R.string.toastType), Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(MainActivity.this, getString(R.string.saved)+fioValue, Toast.LENGTH_LONG).show();
                main.add(fioValue);
                main.add(ageValue);
            }

        });



        Button buttonPressure = findViewById(R.id.buttonPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);

            }
        });

        Button buttonEtc = findViewById(R.id.buttonEtc);
        buttonEtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentEtc = new Intent(MainActivity.this, LifeActivity.class);
                try {
                    startActivity(intentEtc);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}

