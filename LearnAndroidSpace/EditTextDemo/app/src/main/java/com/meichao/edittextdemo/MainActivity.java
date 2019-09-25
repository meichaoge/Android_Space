package com.meichao.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleloginlayout);

        EditText passwordEditText=findViewById(R.id.loginTip_usePasswordEditText);

        passwordEditText.requestFocus();  //请求获取焦点
     //   passwordEditText.clearFocus();   //清除焦点
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0,InputMethodManager.SHOW_IMPLICIT);


       // inputMethodManager.showSoftInput(MainActivity.this,InputMethodManager.SHOW_FORCED);
     //   inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }
}
