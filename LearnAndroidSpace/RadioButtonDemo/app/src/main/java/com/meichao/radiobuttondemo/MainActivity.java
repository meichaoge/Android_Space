package com.meichao.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinpleradiobutton001);

        Button commandButton = findViewById(R.id.commondButton);
        final RadioGroup sexRadioGroup = findViewById(R.id.radioGroup001);


//        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton select=findViewById(checkedId);
//                Toast.makeText(getApplicationContext(),"选择了"+select.getText(),Toast.LENGTH_SHORT).show();
//            }
//        });

        commandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("测试", "onClick: " + sexRadioGroup.getChildCount());

                for (int dex = 0; dex < sexRadioGroup.getChildCount(); ++dex) {
                    RadioButton childRadioGroup = (RadioButton) sexRadioGroup.getChildAt(dex);
                    Log.e("测试", "onClick: " + childRadioGroup.getText() + "::" + childRadioGroup.isChecked());

                    if (childRadioGroup.isChecked())
                        Toast.makeText(getApplicationContext(), "选择了" + childRadioGroup.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
