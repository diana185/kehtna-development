package com.example.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalcBtn(View view) {
        Button btn = (Button) view;
        String txt = btn.getText().toString();

        Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_SHORT).show();
    }
}
