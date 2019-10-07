package com.meichao.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RegisterInforActivity extends Activity {
    private final String TAG = "RegisterInforActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerinforlayout);

        TextView registerInfor = findViewById(R.id.textViewRegisterInfor);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String infor = "名字" + bundle.getString("Name") + "  性别：" + bundle.getString("Sex");
        registerInfor.setText(infor);


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInfor = new Intent(RegisterInforActivity.this, MainActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Infor", infor);

                intentInfor.putExtras(bundle1);
                setResult(0x110,intentInfor);
                finish();
            }
        });


    }


}
