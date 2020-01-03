# 版本v2.0.1



##### 基本使用

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

##### 效果图

![sdk_list.png](http://to1.itplt.com:8102/zhouyunchong/gssdk-android/raw/master/image/sdk_list3.png)
