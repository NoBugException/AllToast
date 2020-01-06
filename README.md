# 版本v2.0.1

##### 引用

    allprojects {
        allprojects {
            repositories {
                ...
                maven { url "https://jitpack.io" }
            }
        }
        dependencies {
            ...
            implementation 'com.github.NoBugException:AllToast:2.0.1'
        }


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
##### 封装文档

[Github项目之Toast封装](https://www.jianshu.com/p/cfc6370d028b)

##### 效果图
![image1.png](https://github.com/NoBugException/AllToast/blob/master/image/image1.png)
![image2.png](https://github.com/NoBugException/AllToast/blob/master/image/image2.png)
![image3.png](https://github.com/NoBugException/AllToast/blob/master/image/image3.png)
![image4.png](https://github.com/NoBugException/AllToast/blob/master/image/image4.png)
![image5.png](https://github.com/NoBugException/AllToast/blob/master/image/image5.png)
![image6.png](https://github.com/NoBugException/AllToast/blob/master/image/image6.png)
![image7.png](https://github.com/NoBugException/AllToast/blob/master/image/image7.png)
![image8.png](https://github.com/NoBugException/AllToast/blob/master/image/image8.png)
![image9.png](https://github.com/NoBugException/AllToast/blob/master/image/image9.png)
![image10.png](https://github.com/NoBugException/AllToast/blob/master/image/image10.png)
![image11.png](https://github.com/NoBugException/AllToast/blob/master/image/image11.png)
![image12.png](https://github.com/NoBugException/AllToast/blob/master/image/image12.png)
![image13.png](https://github.com/NoBugException/AllToast/blob/master/image/image13.png)
![image14.png](https://github.com/NoBugException/AllToast/blob/master/image/image14.png)
![image15.png](https://github.com/NoBugException/AllToast/blob/master/image/image15.png)
![image16.png](https://github.com/NoBugException/AllToast/blob/master/image/image16.png)
![image17.png](https://github.com/NoBugException/AllToast/blob/master/image/image17.png)
![image18.png](https://github.com/NoBugException/AllToast/blob/master/image/image18.png)
![image19.png](https://github.com/NoBugException/AllToast/blob/master/image/image19.png)
![image20.png](https://github.com/NoBugException/AllToast/blob/master/image/image20.png)
![image21.png](https://github.com/NoBugException/AllToast/blob/master/image/image21.png)
![image22.png](https://github.com/NoBugException/AllToast/blob/master/image/image22.png)
![image23.png](https://github.com/NoBugException/AllToast/blob/master/image/image23.gif)
