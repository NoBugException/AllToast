package com.zyc.mytoast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Toast 相关工具类
 */
public final class AllToast {

    //主线程消息循环的handler
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    //Toastsh实例
    private static Toast result;
    //默认颜色
    private static final int COLOR_DEFAULT = 0xFEFFFFFF;
    //上下文
    private static Context mContext = null;
    //文本
    private static WeakReference<CharSequence> toastText = null;
    //Toast的文字大小
    private static float toastTextSize = 14;//单位为sp
    //Toast的文字颜色
    private static int toastTextColor = COLOR_DEFAULT;
    //Toast设置颜色的文字位置
    private static List<ColorSpan> toastTextColorSpans = new ArrayList<>();
    //Toast设置颜色背景的文字位置
    private static List<ColorSpan> toastTextBgColorSpans = new ArrayList<>();
    //Toast的字体
    private static WeakReference<Typeface> toastTypeface = new WeakReference<>(Typeface.DEFAULT);//单位为sp
    //时长
    private static int toastDuration = Toast.LENGTH_LONG;
    //设置图标
    private static WeakReference<Drawable> toastIconDrawable = null;
    //图标宽度
    private static int toastDrawableWidth = -1;
    //图标高度
    private static int toastDrawableHeight = -1;
    //设置背景颜色
    private static int toastBackgroundColor = Color.parseColor("#E65F6368");
    //背景
    private static WeakReference<Drawable> toastBgDrawable = null;
    //圆角矩形的半径
    private static float toastRadius = 8;
    //方位
    private static int toastGravity = Gravity.BOTTOM;
    //x轴偏移量
    private static int toastXOffset = 0;
    //y轴偏移量
    private static int toastYOffset = -1;
    //设置Toast的宽度
    private static int toastWidth = 0;
    //设置Toast的高度
    private static int toastHeight = 0;
    //设置Toast布局的方向
    private static Enum toastOrientation = ORIENTATION.HORIZONTAL;

    private AllToast() { }

    //单例模式,保证AllToast对象在内存中唯一
    static class SingleHolder{
        public static AllToast instance = new AllToast();
    }

    //传递上下文
    public static AllToast with(Context context){
        mContext = context;
        return SingleHolder.instance;
    }

    //设置文本
    public AllToast text(CharSequence text){
        toastText = new WeakReference<>(text);
        return SingleHolder.instance;
    }

    //设置文本大小
    public AllToast textSize(float size){
        toastTextSize = size;
        return SingleHolder.instance;
    }

    //设置文本颜色
    public AllToast textColor(int color){
        toastTextColor = color;
        return SingleHolder.instance;
    }

    //设置部分文本颜色
    public AllToast textColor(ColorSpan... colorSpans){
        for(int i=0;i<colorSpans.length;i++){
            toastTextColorSpans.add(colorSpans[i]);
        }
        return SingleHolder.instance;
    }

    //设置文本背景颜色
    public AllToast textBgColor(ColorSpan... colorSpans){
        for(int i=0;i<colorSpans.length;i++){
            toastTextBgColorSpans.add(colorSpans[i]);
        }
        return SingleHolder.instance;
    }

    //设置文本颜色
    public AllToast typeface(Typeface typeface){
        toastTypeface = new WeakReference<>(typeface);
        return SingleHolder.instance;
    }

    //设置文本颜色
    public AllToast typeface(Enum typeface){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        if(typeface == TYPEFACE.TYPEFACE_1){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_1.otf"));
        }else if(typeface == TYPEFACE.TYPEFACE_2){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_2.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_3){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_3.ttc"));
        }else if(typeface == TYPEFACE.TYPEFACE_4){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_4.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_5){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_5.otf"));
        }else if(typeface == TYPEFACE.TYPEFACE_6){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_6.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_7){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_7.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_8){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_8.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_9){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_9.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_10){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_10.ttf"));
        }else if(typeface == TYPEFACE.TYPEFACE_11){
            toastTypeface = new WeakReference<>(Typeface.createFromAsset(mContext.getAssets(), "typeface_11.ttf"));
        }

        return SingleHolder.instance;
    }

    /**
     * 设置时长
     * @param duration  Toast.LENGTH_LONG、LENGTH_SHORT
     * @return
     */
    public AllToast duration(int duration){
        toastDuration = duration;
        return SingleHolder.instance;
    }

    //设置图标
    public AllToast iconDrawable(int drawableInt){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        toastIconDrawable = new WeakReference<Drawable>(mContext.getResources().getDrawable(drawableInt));
        return SingleHolder.instance;
    }

    //设置图标
    public AllToast iconDrawable(Drawable drawable){
        toastIconDrawable = new WeakReference<>(drawable);
        return SingleHolder.instance;
    }

    //设置图标
    public AllToast iconDrawable(int drawableInt, int width, int height){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        toastIconDrawable = new WeakReference<Drawable>(mContext.getResources().getDrawable(drawableInt));
        toastDrawableWidth = (int) (mContext.getResources().getDisplayMetrics().density * width + 0.5f);
        toastDrawableHeight = (int) (mContext.getResources().getDisplayMetrics().density * height + 0.5f);
        return SingleHolder.instance;
    }

    //设置图标
    public AllToast iconDrawable(Drawable drawable, int width, int height){
        toastIconDrawable = new WeakReference<>(drawable);
        toastDrawableWidth = (int) (mContext.getResources().getDisplayMetrics().density * width + 0.5f);
        toastDrawableHeight = (int) (mContext.getResources().getDisplayMetrics().density * height + 0.5f);
        return SingleHolder.instance;
    }

    //设置背景颜色
    public AllToast backgroundColor(@ColorInt int color){
        toastBackgroundColor = color;
        return SingleHolder.instance;
    }

    //设置背景
    public AllToast background(int drawableInt){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        toastBgDrawable = new WeakReference<Drawable>(mContext.getResources().getDrawable(drawableInt));
        return SingleHolder.instance;
    }

    //设置背景
    public AllToast background(Drawable drawable){
        toastBgDrawable = new WeakReference<>(drawable);
        return SingleHolder.instance;
    }

    //设置圆角矩形的半径
    public AllToast radius(float radius){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        toastRadius = mContext.getResources().getDisplayMetrics().density * radius + 0.5f;
        return SingleHolder.instance;
    }

    //设置圆角矩形的半径
    public AllToast gravity(int gravity, int xOffset, int yOffset){
        toastGravity = gravity;
        toastXOffset = xOffset;
        toastYOffset = yOffset;
        return SingleHolder.instance;
    }

    //设置Toast的宽度和高度
    public AllToast size(int width, int height){
        toastWidth = (int) (mContext.getResources().getDisplayMetrics().density * width + 0.5f);
        toastHeight = (int) (mContext.getResources().getDisplayMetrics().density * height + 0.5f);
        return SingleHolder.instance;
    }
    //设置Toast布局方向
    public AllToast orientation(Enum orientation){
        toastOrientation = orientation;
        return SingleHolder.instance;
    }

    /**
     * 通用
     */
    public void show(){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                cancel();
                makeText(mContext, toastText !=null ? toastText.get() : "", toastIconDrawable != null ? toastIconDrawable.get() : null, toastDuration).show();
                reset();
            }
        });
    }

    //布局方向
    public enum ORIENTATION{
        HORIZONTAL,//横向
        VERTICAL//纵向
    }

    //字体大全
    public enum TYPEFACE{
        TYPEFACE_1,//造字工房劲黑常规体
        TYPEFACE_2,//书体坊兰亭体I
        TYPEFACE_3,//华康POP3体W12-GB
        TYPEFACE_4,//方正粗谭黑简体
        TYPEFACE_5,//蒙纳繁方点阵
        TYPEFACE_6,//方正尚酷简体FZSHANGKJW
        TYPEFACE_7,//禹卫书法行书字体
        TYPEFACE_8,//led数字液晶字体1
        TYPEFACE_9,//led数字液晶字体2
        TYPEFACE_10,//led数字液晶字体3
        TYPEFACE_11,//led数字液晶字体4
    }

    public static class ColorSpan{

        private int color;//颜色
        private int start;//起始位置
        private int end;//结束位置

        public ColorSpan(int color, int start, int end) {
            this.color = color;
            this.start = start;
            this.end = end;
        }
    }

    //重置
    private static void reset(){
        //默认颜色
        //上下文
        mContext = null;
        //文本
        toastText = null;
        //Toast的文字大小
        toastTextSize = 14;//单位为sp
        //Toast的文字颜色
        toastTextColor = COLOR_DEFAULT;
        //Toast颜色的文字位置
        toastTextColorSpans.clear();
        //Toast颜色背景的文字位置
        toastTextBgColorSpans.clear();
        //Toast的字体
        toastTypeface = new WeakReference<>(Typeface.DEFAULT);//单位为sp
        //时长
        toastDuration = Toast.LENGTH_LONG;
        //设置图标
        toastIconDrawable = null;
        //图标宽度
        toastDrawableWidth = -1;
        //图标高度
        toastDrawableHeight = -1;
        //设置背景颜色
        toastBackgroundColor = Color.parseColor("#E65F6368");
        //背景
        toastBgDrawable = null;
        //圆角矩形的半径
        toastRadius = 8;
        //方位
        toastGravity = Gravity.BOTTOM;
        //x轴偏移量
        toastXOffset = 0;
        //y轴偏移量
        toastYOffset = -1;
        //设置Toast的宽度
        toastWidth = 0;
        //设置Toast的高度
        toastHeight = 0;
        //设置Toast布局的方向
        toastOrientation = ORIENTATION.HORIZONTAL;
    }

    //取消
    private static void cancel() {

        if (toastIconDrawable instanceof Animatable && ((Animatable)toastIconDrawable.get()).isRunning()){
            //停止动画
            ((Animatable)toastIconDrawable.get()).stop();
        }

        if (result != null) {
            result.cancel();
            result = null;
        }
    }

    /**
     * 通用Toast显示
     * @param context
     * @param text
     * @param duration
     * @return
     */
    private Toast makeText(@NonNull Context context, @NonNull CharSequence text, @NonNull Drawable toastDrawable, int duration) {
        result = new Toast(context);

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View toastLayout = inflate.inflate(R.layout.toast_layout, null);
        final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);
        final LinearLayout toast_root = toastLayout.findViewById(R.id.toast_root);
        if(toastOrientation == ORIENTATION.HORIZONTAL){
            toast_root.setOrientation(LinearLayout.HORIZONTAL);
            if(toastDrawable != null){
                ((LinearLayout.MarginLayoutParams)toastIcon.getLayoutParams()).setMarginStart((int) (8 * mContext.getResources().getDisplayMetrics().density + 0.5f));
                ((LinearLayout.MarginLayoutParams)toastIcon.getLayoutParams()).setMarginEnd((int) (-8 * mContext.getResources().getDisplayMetrics().density + 0.5f));
                ((LinearLayout.MarginLayoutParams)toastTextView.getLayoutParams()).setMarginStart((int) (8 * mContext.getResources().getDisplayMetrics().density + 0.5f));
                ((LinearLayout.MarginLayoutParams)toastTextView.getLayoutParams()).setMarginEnd((int) (-8 * mContext.getResources().getDisplayMetrics().density + 0.5f));
            }
        }else{
            toast_root.setOrientation(LinearLayout.VERTICAL);
            ((LinearLayout.MarginLayoutParams)toastIcon.getLayoutParams()).setMarginStart(0);
            ((LinearLayout.MarginLayoutParams)toastIcon.getLayoutParams()).setMarginEnd(0);
            ((LinearLayout.MarginLayoutParams)toastTextView.getLayoutParams()).setMarginStart(0);
            ((LinearLayout.MarginLayoutParams)toastTextView.getLayoutParams()).setMarginEnd(0);
            if(toastDrawable != null){
                ((LinearLayout.MarginLayoutParams) toastTextView.getLayoutParams()).topMargin = (int) (8 * mContext.getResources().getDisplayMetrics().density + 0.5f);
            }
        }
        //设置文本
        toastTextView.setText(text);
        //设置文本大小
        toastTextView.setTextSize(toastTextSize);
        //设置文本颜色
        toastTextView.setTextColor(toastTextColor);
        //设置字体
        toastTextView.setTypeface(toastTypeface.get());

        SpannableStringBuilder style = new SpannableStringBuilder(text);
        for(ColorSpan colorSpan : toastTextColorSpans){
            int start = colorSpan.start;
            int end = colorSpan.end;
            if(start < 0){
                start = 0;
            }
            if(start > text.length()){
                start = text.length();
            }
            if(end < 0){
                end = 0;
            }
            if(end > text.length()){
                end = text.length();
            }
            if(start > end){
                start = end;
            }
            style.setSpan(new ForegroundColorSpan(colorSpan.color),start,end,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        for(ColorSpan colorSpan : toastTextBgColorSpans){
            int start = colorSpan.start;
            int end = colorSpan.end;
            if(start < 0){
                start = 0;
            }
            if(start > text.length()){
                start = text.length();
            }
            if(end < 0){
                end = 0;
            }
            if(end > text.length()){
                end = text.length();
            }
            if(start > end){
                start = end;
            }
            style.setSpan(new BackgroundColorSpan(colorSpan.color),start,end,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        //设置文本样式
        toastTextView.setText(style);

        if(toastWidth != 0 && toastHeight != 0){
            //设置Toast的宽度和高度
            toast_root.setLayoutParams(new LinearLayout.LayoutParams(toastWidth, toastHeight));
        }
        //设置布局
        result.setView(toastLayout);
        //设置时长
        result.setDuration(duration);
        //设置图标
        if(toastDrawable != null){
            toastIcon.setVisibility(View.VISIBLE);
            if(toastDrawableWidth != -1 && toastDrawableHeight != -1){
                //如果表图标的宽度和高度是正常值
                toastIcon.getLayoutParams().width = toastDrawableWidth;//设置图标的宽度
                //设置图标的高度
                toastIcon.getLayoutParams().height = toastDrawableHeight;//设置图标的高度
            }
            toastIcon.setImageDrawable(toastDrawable);
            //执行动画
            if (toastDrawable instanceof Animatable){
                if(((Animatable)toastDrawable).isRunning()){
                    ((Animatable)toastDrawable).stop();
                }
                ((Animatable)toastDrawable).start();
            }
        }else{
            toastIcon.setVisibility(View.GONE);
        }

        if(toastBgDrawable != null){
            //设置背景
            toast_root.setBackground(toastBgDrawable.get());
        }else{
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            // 外部矩形弧度
            float[] outerR = new float[] { toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius };
            // 内部矩形与外部矩形的距离
//            RectF inset = new RectF(0, 0, toastLayout.getWidth(), toastLayout.getHeight());
            RectF inset = new RectF(0, 0, toastLayout.getWidth(), toastLayout.getHeight());
            // 内部矩形弧度
            float[] innerRadii = new float[] { toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius, toastRadius };
            RoundRectShape shape = new RoundRectShape(outerR, inset, innerRadii);
            //抗锯齿
            shapeDrawable.getPaint().setAntiAlias(true);
            //指定填充颜色
            shapeDrawable.getPaint().setColor(toastBackgroundColor);
            // 指定填充模式
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
            shapeDrawable.setShape(shape);
            //设置背景
            toast_root.setBackground(shapeDrawable);
        }

        //方向
        if(toastYOffset == -1){
            Point size = new Point();
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Activity.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getSize(size);
            result.setGravity(toastGravity, toastXOffset, size.y / 8);
        }else{
            result.setGravity(toastGravity, toastXOffset, toastYOffset);
        }

        return result;
    }

}