package com.meichao.scrollviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    ScrollView scrollView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplescrollview001);

         scrollView=findViewById(R.id.test001);
         textView=findViewById(R.id.test002);

        StringBuilder builder=new StringBuilder();
        for (int dex=0;dex  <100;++dex  )
            builder.append("test="+dex+"\n"  );
        textView.setText(builder.toString());

        findViewById(R.id.buttonUp).setOnClickListener(this);
        findViewById(R.id.buttonDown).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case  R.id.buttonUp:
             //  scrollView.fullScroll(ScrollView.FOCUS_UP);
               scrollToTop(scrollView,textView);
               break;
           case  R.id.buttonDown:
           //    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
               scrollToBottom(scrollView,textView);
               break;
       }
    }


    //***下面两种方法是自定义的实现 使用 scrollTo

    public static void scrollToBottom(final View scroll, final View inner) {
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                if (scroll == null || inner == null) {
                    return;
                }
                int offset = inner.getMeasuredHeight() - scroll.getHeight();
                if (offset < 0) {
                    offset = 0;
                }
                scroll.scrollTo(0, offset);
            }
        });
    }

    public static void scrollToTop(final View scroll, final View inner) {
        Handler mHandler = new Handler();
        mHandler.post(new Runnable() {
            public void run() {
                if (scroll == null || inner == null) {
                    return;
                }
                scroll.scrollTo(0,   0);
            }
        });
    }

}
