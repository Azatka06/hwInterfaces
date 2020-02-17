package com.example.hw13;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG = "myApp";
    ArrayList<String> pressureData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        final EditText top = findViewById(R.id.top);
        final EditText low = findViewById(R.id.low);
        final EditText bit = findViewById(R.id.bit);


        Button savePressure = findViewById(R.id.savePressure);
        savePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String topValue = top.getText().toString();
                final String lowValue = low.getText().toString();
                final String bitValue = bit.getText().toString();
                if ((topValue.length() == 0) || (lowValue.length() == 0) || (bitValue.length() == 0)) {
                    Toast.makeText(PressureActivity.this, getString(R.string.small), Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    PressureData value = new PressureData(Integer.parseInt(topValue), Integer.parseInt(lowValue), Integer.parseInt(bitValue));
                } catch (Exception ex) {
                    Toast.makeText(PressureActivity.this, getString(R.string.toastType), Toast.LENGTH_LONG).show();
                    return;
                }


                Toast.makeText(PressureActivity.this, getString(R.string.saved), Toast.LENGTH_LONG).show();

                pressureData.add(topValue);
                pressureData.add(lowValue);
                pressureData.add(bitValue);
            }
        });
    }
}
