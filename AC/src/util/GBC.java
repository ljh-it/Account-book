package util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints  
{  
   //初始化左上角位置  
   public GBC(int gridx, int gridy)  
   {  
      this.gridx = gridx;  
      this.gridy = gridy;  
   }  
  
   //初始化左上角位置和所占行数和列数  
   public GBC(int gridx, int gridy, int gridwidth, int gridheight)  
   {  
      this.gridx = gridx;  
      this.gridy = gridy;  
      this.gridwidth = gridwidth;  
      this.gridheight = gridheight;  
   }  
  
   //对齐方式  
   public GBC setAnchor(int anchor)  
   {  
      this.anchor = anchor;  
      return this;  
   }  
  
   //是否拉伸及拉伸方向  
   public GBC setFill(int fill)  
   {  
      this.fill = fill;  
      return this;  
   }  
  
   //x和y方向上的增量 
 //该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间 s.weightx = 0;
 //该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间 s.weighty=0;
   public GBC setWeight(double weightx, double weighty)  
   {  
      this.weightx = weightx;  
      this.weighty = weighty;  
      return this;  
   }  
  
   //外部填充  
   public GBC setInsets(int distance)  
   {  
      this.insets = new Insets(distance, distance, distance, distance);  
      return this;  
   }  
   //外填充   //insert = new Insets(0, 0, 0, 0); 组件彼此的间距
   public GBC setInsets(int top, int left, int bottom, int right)  
   {  
      this.insets = new Insets(top, left, bottom, right);  
      return this;  
   }  
  /*
   * Insets是AWT里面一个类的名字，代表着类Insets，它的用途是用来定义组件容器周围的空间大小，其中带有四个参数：
Insets(第一个参数，第二个参数，第三个参数，第
四个参数 )

第一个参数代表距上面有几个点的空白，第二个参数代
表距左边有几个点的空白，第三个参数代表距下边有几个点的空白区域，第
四个参数代表距右边留几个点的空白区域。
insets和Insets既然起的名字相同，两者之间也一
定有相同之处，它们的相似之处就在于它们的用法和用途。insets用来设置
一个组件和其他的组件之间的距离的。所以在上面程序里的按钮和其他的按
钮不同，它和其他的按钮之间都有一定的距离，而不是和其他的按钮挨在一
起。
   */
   //内填充  
   public GBC setIpad(int ipadx, int ipady)  
   {  
      this.ipadx = ipadx;  // 组件内部填充空间，即给组件的最小宽度添加多大的空间
      this.ipady = ipady;   // 组件内部填充空间，即给组件的最小高度添加多大的空间
      return this;  
   }  
}  
