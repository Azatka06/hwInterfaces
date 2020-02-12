package com.example.hw13;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class etc extends AppCompatActivity {

    private static final String TAG = "myApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc);

        Button saveEtc = findViewById(R.id.saveEtc);
        saveEtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText weidth = findViewById(R.id.weidth);
                String weidthValue = weidth.getText().toString();
                EditText steps = findViewById(R.id.steps);
                String stepsValue = steps.getText().toString();

                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    insert value = new insert(weidthValue, Integer.parseInt(stepsValue));

                } catch (Exception ex) {
                    Toast.makeText(etc.this, "Неверный формат", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
