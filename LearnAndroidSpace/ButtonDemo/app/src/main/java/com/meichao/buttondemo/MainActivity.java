package com.meichao.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statelistdrawable_button);

        final Button test001, test002;
        test001 = findViewById(R.id.testButton01);
        test002 = findViewById(R.id.testButton02);

        test002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = !isSelected;
                test001.setEnabled(isSelected);

                Log.i("test", "onClick: " + isSelected);
                Toast.makeText(getApplicationContext(),"onClick: " + isSelected,Toast.LENGTH_LONG).show();
            }
        });

    }
}
