package com.meichao.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplecheckbox001);

        CheckBox checkBox01=findViewById(R.id.Apple);
        CheckBox checkBox02=findViewById(R.id.banana);
        CheckBox checkBox03=findViewById(R.id.pineapple);

        checkBox01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),"选择了"+buttonView.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        checkBox02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),"选择了"+buttonView.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        checkBox03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),"选择了"+buttonView.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
