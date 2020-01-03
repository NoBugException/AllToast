package com.zyc.alltoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zyc.mytoast.AllToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_1, button_2, button_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        button_2 = findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        button_3 = findViewById(R.id.button_3);
        button_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:

                AllToast.with(getApplicationContext())
                        .text("提19")
                        .gravity(Gravity.CENTER, 0, 0)
                        .textSize(100)//文本大小，单位是sp
                        .textColor(Color.parseColor("#FF5E10E9"))
                        .textColor(new AllToast.ColorSpan(Color.parseColor("#CF7256"), 0, 1), new AllToast.ColorSpan(Color.parseColor("#CFF216"), 2, 4))
                        //.textBgColor(new AllToast.ColorSpan(Color.parseColor("#6FD5CA"), 2, 3), new AllToast.ColorSpan(Color.parseColor("#6FF5C1"), 5, 6))
                        //.radius(50)//单位为dp
                        //.backgroundColor(Color.BLUE)
                        //.background(getResources().getDrawable(R.drawable.toast_frame))
                        .background(R.drawable.toast_frame)
                        //.size(200, 200)//单位为dp
                        .duration(Toast.LENGTH_SHORT)//时长
                        .iconDrawable(R.drawable.search_animated_vector, 100, 100)
                        .orientation(AllToast.ORIENTATION.VERTICAL)
                        .typeface(AllToast.TYPEFACE.TYPEFACE_11)
                        .show();


                break;
            case R.id.button_2:
                AllToast.with(getApplicationContext())
                        .iconDrawable(R.drawable.search_animated_vector, 50, 50)//左边图标
                        .text("01234")//文本
                        .textSize(50)//文本大小，单位是sp
                        .textColor(new AllToast.ColorSpan(Color.parseColor("#CF7256"), 0, 2))//文本颜色
                        .textBgColor(new AllToast.ColorSpan(Color.parseColor("#6FD5CA"), 4, 5))//文本背景
//                        .typeface(Typeface.SANS_SERIF)//字体
                        .typeface(AllToast.TYPEFACE.TYPEFACE_9)
                        .backgroundColor(Color.BLUE)//背景色
                        .background(R.drawable.toast_frame)
                        .radius(100)//圆角矩形半径，单位为dp
                        .gravity(Gravity.CENTER, 0, 0)
                        .size(200, 200)//Toast大小
                        .orientation(AllToast.ORIENTATION.VERTICAL)
                        .duration(Toast.LENGTH_LONG)//时长
                        .show();
                break;
            case R.id.button_3:
                AllToast.with(getApplicationContext())
                        .iconDrawable(R.drawable.search_animated_vector, 50, 50)//左边图标
                        .text("01234")//文本
                        .textSize(50)//文本大小，单位是sp
                        .textColor(new AllToast.ColorSpan(Color.parseColor("#CF7256"), 0, 2))//文本颜色
                        .textBgColor(new AllToast.ColorSpan(Color.parseColor("#6FD5CA"), 4, 5))//文本背景
//                        .typeface(Typeface.SANS_SERIF)//字体
                        .typeface(AllToast.TYPEFACE.TYPEFACE_10)
                        .backgroundColor(Color.BLUE)//背景色
                        .background(R.drawable.toast_frame)
                        .radius(100)//圆角矩形半径，单位为dp
                        .gravity(Gravity.CENTER, 0, 0)
                        .size(200, 200)//Toast大小
                        .orientation(AllToast.ORIENTATION.VERTICAL)
                        .duration(Toast.LENGTH_LONG)//时长
                        .show();
                break;
        }
    }
}
