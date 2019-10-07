package com.meichao.activitydemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);


        final EditText nameView = findViewById(R.id.editTextName);
        final RadioGroup sexRadioGroup = findViewById(R.id.RadioGroupSex);
        Button registerButton = findViewById(R.id.RegisterButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterInforActivity.class);
                Bundle bundle = new Bundle();

                String nameInfor = nameView.getText().toString();
                Toast.makeText(getApplicationContext(), "nameInfor=" + nameInfor, Toast.LENGTH_SHORT).show();
                bundle.putString("Name", nameInfor);

                String sexInfor = "";
                for (int dex = 0; dex < sexRadioGroup.getChildCount(); ++dex) {
                    RadioButton button = (RadioButton) sexRadioGroup.getChildAt(dex);
                    if (button.isChecked()) {
                        sexInfor = button.getText().toString();
                        break;
                    }
                }
                bundle.putString("Sex", sexInfor);
                intent.putExtras(bundle);
               // startActivity(intent);
                startActivityForResult(intent,0x123);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult: "+requestCode+";;"+resultCode);
        if(requestCode==0x123&resultCode==0x110){
            Bundle bundle=data.getExtras();
            String infor=bundle.getString("Infor");
            Toast.makeText(getApplicationContext(),infor,Toast.LENGTH_SHORT).show();
        }
    }
}
