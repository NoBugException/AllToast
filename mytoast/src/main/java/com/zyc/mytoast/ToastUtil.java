package com.zyc.mytoast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

import java.lang.ref.WeakReference;

/**
 * Toast 相关工具类
 */
public final class ToastUtil {
    /* 默认颜色 */
    private final int COLOR_DEFAULT = 0xFEFFFFFF;
    /* 无效的值 */
    private final int INVALID_VALUE = -1;
    /* 获取了主线程消息循环的 handler */
    private final Handler HANDLER = new Handler(Looper.getMainLooper());

    /* Toast 实例 */
    private Toast mToast;
    /* Toast 的布局 view */
    private WeakReference<View> mViewWeakRef;
    /* Toast layout 的 id */
    private int mLayoutId = INVALID_VALUE;
    /* Toast 位置 */
    private int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
    /* x 偏移 */
    private int xOffset = 0;
    /* y 偏移 */
    private static int yOffset;
    /* Toast 的背景色 */
    private int mBgColor = COLOR_DEFAULT;
    /* Toast 的背景资源 */
    private int mBgResource = INVALID_VALUE;
    /* Toast 的文字颜色 */
    private int mTextColor = COLOR_DEFAULT;
    /* Toast 的文字大小 */
    private int mTextSize = INVALID_VALUE;

    public static Context mContext;

    private ToastUtil() { }

    static class SingleHolder{
        public static ToastUtil instance = new ToastUtil();
    }

    public static ToastUtil with(Context context){
        mContext = context;
        yOffset = (int) (64 * mContext.getResources().getDisplayMetrics().density + 0.5);
        return SingleHolder.instance;
    }

    /**
     * 设置 Toast 显示位置
     *
     * @param gravity
     */
    public void setGravity(int gravity) {
        setGravity(gravity, 0, 0);
    }

    /**
     * 设置 Toast 显示位置
     *
     * @param mGravity 位置
     * @param xOffset x 偏移
     * @param yOffset y 偏移
     */
    public void setGravity(int mGravity, int xOffset, int yOffset) {
        this.mGravity = mGravity;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /**
     * 设置背景颜色
     *
     * @param backgroundColor 背景色
     */
    public void setBgColor(@ColorInt int backgroundColor) {
        mBgColor = backgroundColor;
    }

    /**
     * 设置背景资源
     *
     * @param bgResource 背景资源
     */
    public void setBgResource(@DrawableRes int bgResource) {
        mBgResource = bgResource;
    }

    /**
     * 设置文字颜色
     *
     * @param textColor 颜色
     */
    public void setTextColor(@ColorInt int textColor) {
        mTextColor = textColor;
    }

    /**
     * 设置文字大小
     *
     * @param textSize 文字大小
     */
    public void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    /**
     * 短时显示 Toast
     *
     * @param text 文本
     */
    public void show(CharSequence text) {
        show(text, Toast.LENGTH_SHORT);
    }

    /**
     * 短时显示 Toast
     *
     * @param resId 资源 Id
     */
    public void show(@StringRes int resId) {
        show(resId, Toast.LENGTH_SHORT);
    }

    /**
     * 显示 Toast
     *
     * @param resId    资源 Id
     * @param duration 显示时间
     */
    public void show(@StringRes int resId, int duration) {
        show(mContext.getResources().getText(resId).toString(), duration);
    }

    /**
     * 短时显示 Toast
     *
     * @param resId 资源 Id
     * @param args  参数
     */
    public void show(@StringRes int resId, Object... args) {
        show(resId, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示 Toast
     *
     * @param resId    资源 Id
     * @param duration 显示时间
     * @param args     格式化字符串中格式指定符引用的参数
     */
    private void show(@StringRes int resId, int duration, Object... args) {
        show(String.format(mContext.getResources().getString(resId), args), duration);
    }

    /**
     * 短时显示 Toast
     *
     * @param format 格式字符串
     * @param args   参数
     */
    public void show(@Nullable String format, Object... args) {
        show(format, Toast.LENGTH_SHORT, args);
    }

    /**
     * 显示 Toast
     *
     * @param format   格式字符串
     * @param duration 显示时间
     * @param args     格式字符串中格式指定符引用的参数
     */
    private void show(String format, int duration, Object... args) {
        show(String.format(format, args), duration);
    }

    /**
     * 短时显示自定义 Toast
     *
     * @param layoutId 布局资源 Id
     * @return Toast 的自定义布局
     */
    public View showCusView(@LayoutRes int layoutId) {
        return showCusView(layoutId, Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义布局的 Toast
     *
     * @param layoutId 布局资源 Id
     * @param duration 显示时间
     * @return Toast 的自定义布局
     */
    public View showCusView(@LayoutRes int layoutId, int duration) {
        final View view = getView(layoutId);
        show(view, duration);
        return view;
    }

    /**
     * 短时显示自定义 Toast
     *
     * @param view 自定义布局
     * @return Toast 的自定义布局
     */
    public View showCusView(View view) {
        return showCusView(view, Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义布局的 Toast
     *
     * @param view     自定义布局
     * @param duration 显示时间
     * @return Toast 的自定义布局
     */
    public View showCusView(View view, int duration) {
        show(view, duration);
        return view;
    }

    /**
     * 取消 Toast 显示
     */
    public void cancel() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    /**
     * 显示 Toast
     *
     * @param text     消息文本
     * @param duration 显示时间
     */
    public void show(final CharSequence text, final int duration) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                cancel();
                mToast = Toast.makeText(mContext, text, duration);
                TextView tvMessage = (TextView) mToast.getView().findViewById(android.R.id.message);
                TextViewCompat.setTextAppearance(tvMessage, android.R.style.TextAppearance);
                tvMessage.setTextColor(mTextColor);
                if (mTextSize != INVALID_VALUE) {
                    tvMessage.setTextSize(mTextSize);
                }
                mToast.setGravity(mGravity, xOffset, yOffset);
                setDefBg(tvMessage);
                mToast.show();
            }
        });
    }

    /**
     * 显示自定义布局 Toast
     *
     * @param view     Toast 布局
     * @param duration 显示时间
     */
    private void show(final View view, final int duration) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                cancel();
                mToast = new Toast(mContext);
                mToast.setView(view);
                mToast.setDuration(duration);
                mToast.setGravity(mGravity, xOffset, yOffset);
                setCusBg();
                mToast.show();
            }
        });
    }

    /**
     * 设置背景
     * <p>Toast 使用的是默认布局</p>
     *
     * @param tvMessage Toast 默认布局中的 textview
     */
    private void setDefBg(TextView tvMessage) {
        if (mToast == null) return;
        View toastView = mToast.getView();
        if (mBgResource != INVALID_VALUE) {
            toastView.setBackgroundResource(mBgResource);
            tvMessage.setBackgroundColor(Color.TRANSPARENT);
        } else if (mBgColor != COLOR_DEFAULT) {
            Drawable tvBg = toastView.getBackground();
            Drawable messageBg = tvMessage.getBackground();
            if (tvBg != null && messageBg != null) {
                tvBg.setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
                tvMessage.setBackgroundColor(Color.TRANSPARENT);
            } else if (tvBg != null) {
                tvBg.setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            } else if (messageBg != null) {
                messageBg.setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            } else {
                toastView.setBackgroundColor(mBgColor);
            }
        }
    }

    /**
     * 设置背景
     * <p>Toast 使用的是自定义布局</p>
     */
    private void setCusBg() {
        if (mToast == null) return;
        View toastView = mToast.getView();
        if (mBgResource != INVALID_VALUE) {
            toastView.setBackgroundResource(mBgResource);
        } else if (mBgColor != COLOR_DEFAULT) {
            Drawable background = toastView.getBackground();
            if (background != null) {
                background.setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            } else {
                ViewCompat.setBackground(toastView, new ColorDrawable(mBgColor));
            }
        }
    }

    /**
     * 获取布局 view
     *
     * @param layoutId 布局资源 id
     * @return view
     */
    private View getView(@LayoutRes int layoutId) {
        if (mLayoutId == layoutId) {
            if (mViewWeakRef != null) {
                final View toastView = mViewWeakRef.get();
                if (toastView != null) {
                    return toastView;
                }
            }
        }
        LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View toastView = inflate.inflate(layoutId, null);
        mViewWeakRef = new WeakReference<>(toastView);
        mLayoutId = layoutId;
        return toastView;
    }
}