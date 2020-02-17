package com.example.hw13;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LifeActivity extends AppCompatActivity {

    private static final String TAG = "myApp";
    ArrayList<String> lifeData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc);
        final EditText weidth = findViewById(R.id.weidth);
        final EditText steps = findViewById(R.id.steps);

        Button saveEtc = findViewById(R.id.saveEtc);
        saveEtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String weidthValue = weidth.getText().toString();
                final String stepsValue = steps.getText().toString();
                if ((weidthValue.length() == 0) || (stepsValue.length() == 0)) {
                    Toast.makeText(LifeActivity.this, getString(R.string.small), Toast.LENGTH_LONG).show();
                    return;
                }
                Log.i(TAG, "Ошибка в формате при нажатии на сохранить");
                try {
                    PatientData value = new PatientData(weidthValue, Integer.parseInt(stepsValue));

                } catch (Exception ex) {
                    Toast.makeText(LifeActivity.this, getString(R.string.toastType), Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(LifeActivity.this, getString(R.string.saved), Toast.LENGTH_LONG).show();
                lifeData.add(weidthValue);
                lifeData.add(stepsValue);

            }
        });
    }
}
