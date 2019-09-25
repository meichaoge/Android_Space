package com.meichao.textviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView  imageTextView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageTextView=findViewById(R.id.textView005);

        Drawable[] drawables=imageTextView.getCompoundDrawables();
        //0-3 依次代表左上右下 四张图片

       drawables[1].setBounds(100,0,200,200);
        imageTextView.setCompoundDrawables(drawables[0],drawables[1],drawables[2],drawables[3]);

        //自定义链接识别
        TextView autoLinkTextView=findViewById(R.id.textView006);
        autoLinkTextView.setAutoLinkMask(Linkify.ALL);  //设置识别链接的类型
        autoLinkTextView.setMovementMethod(LinkMovementMethod.getInstance());  //设置点击时候的效果 不设置的话没有效果


        //设置Html 富文本支持
        TextView textView007=findViewById(R.id.textView007);
        String message="<font color='blue'><b>百度一下，你就知道~：</b></font><br>";
        textView007.setText(Html.fromHtml(message));
        textView007.setAutoLinkMask(Linkify.ALL);
        textView007.setMovementMethod(LinkMovementMethod.getInstance());  //设置点击时候的效果 不设置的话没有效果

        //SpannableString 定制文本
        TextView textView008=findViewById(R.id.textView008);
        SpannableString span = new SpannableString("红色打电话斜体删除线绿色下划线图片:.");
        //1.设置背景色,setSpan时需要指定的flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //2.用超链接标记文本
        span.setSpan(new URLSpan("tel:4155551212"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //3.用样式标记文本（斜体）
        span.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //4.用删除线标记文本
        span.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //5.用下划线标记文本
        span.setSpan(new UnderlineSpan(), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //6.用颜色标记
        span.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        //7.//获取Drawable资源
//        Drawable d = getResources().getDrawable(R.drawable.ic_launcher_background);
//        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        //8.创建ImageSpan,然后用ImageSpan来替换文本
//        ImageSpan imgspan = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
//        span.setSpan(imgspan, 18, 19, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView008.setText(span);


//        TextView textView009=findViewById(R.id.textView009);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 20; i++) {
//            sb.append("好友" + i + "，");
//        }
//
//        String likeUsers = sb.substring(0, sb.lastIndexOf("，")).toString();
//        textView009.setMovementMethod(LinkMovementMethod.getInstance());
//        textView009.setText(addClickPart(likeUsers), TextView.BufferType.SPANNABLE);



    }

    /*
    创建部分可以点击的效果
     */
    private SpannableStringBuilder addClickPart(String str){
        //赞的图标，这里没有素材，就找个笑脸代替下~
        ImageSpan imgspan = new ImageSpan(MainActivity.this, R.drawable.ic_launcher_background);
        SpannableString spanStr = new SpannableString("p.");
        spanStr.setSpan(imgspan, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        //创建一个SpannableStringBuilder对象，连接多个字符串
        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(str);
        String[] likeUsers = str.split("，");
        if (likeUsers.length > 0) {
            for (int i = 0; i < likeUsers.length; i++) {
                final String name = likeUsers[i];
                final int start = str.indexOf(name) + spanStr.length();
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        //删除下划线，设置字体颜色为蓝色
                        ds.setColor(Color.BLUE);
                        ds.setUnderlineText(false);
                    }
                },start,start + name.length(),0);
            }
        }
        return ssb.append("等" + likeUsers.length + "个人觉得很赞");
    }

}
