package com.example.hw13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pressure extends AppCompatActivity {

    private static final String TAG = "myApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        Button savePressure = findViewById(R.id.savePressure);
        savePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText top = findViewById(R.id.top);
                String  topValue = top.getText().toString();
                EditText low = findViewById(R.id.low);
                String lowValue = low.getText().toString();
                EditText bit = findViewById(R.id.bit);
                String bitValue = bit.getText().toString();

                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    pressureEnter value = new pressureEnter(Integer.parseInt(topValue), Integer.parseInt(lowValue),Integer.parseInt(bitValue));
                }
                catch (Exception ex) {
                    Toast.makeText(pressure.this, "Неверный формат", Toast.LENGTH_LONG).show();
                }






            }
        });
    }
}
