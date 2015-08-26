# AndroidCommonMethod
此项目中包含一些能够提高android开发效率的方法

#### 1.TintedBitmapDrawable

本方法可以给白色的图片着不同的颜色
使用很简单：

	tintedDrawable = new TintedBitmapDrawable(getResources(), R.drawable.bgsplash_baidu, Color.BLUE);

#### 2.AnalyticalXml

可以将xml文件中有id的view都转换成java代码中需要findbyid的view节省了重新find，再new的时间。

#### 3.FlowLayout

可以自适应屏幕宽度自动换行。内部的view会检测到如果已经到边界了就直接换行的智能view