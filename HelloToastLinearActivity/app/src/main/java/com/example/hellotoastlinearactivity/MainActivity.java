package com.example.hellotoastlinearactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int nCount = 0;
    private TextView aShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aShowCount = findViewById(R.id.TextViewkontua);
    }

    public void showToast(View view){
        Toast toast = Toast.makeText( this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view){
        nCount++;
        if (aShowCount != null) {

            aShowCount.setText(Integer.toString(nCount));
        }
    }
}