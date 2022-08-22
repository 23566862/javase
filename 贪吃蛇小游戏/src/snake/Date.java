package 贪吃蛇小游戏.src.snake;

import javax.swing.*;
import java.net.URL;

//存放静态图片资源
public class Date {
    //获取图片 URL：获取图片地址
    //身体部分
    public static   URL bodyUrl =Date.class.getResource("/static/body.png");
    public  static ImageIcon bodyImage =new ImageIcon(bodyUrl);
    //标题
    public static  URL headerUrl =Date.class.getResource("/static/header.png");
    public static  ImageIcon headerImage =new ImageIcon(headerUrl);
    //头：向上
    public static  URL downUrl =Date.class.getResource("/static/down.png");
    public static  ImageIcon downImage =new ImageIcon(downUrl);
    //头：向下
    public static  URL upUrl =Date.class.getResource("/static/up.png");
    public static  ImageIcon upImage =new ImageIcon(upUrl);
    //头：向左
    public static  URL leftUrl =Date.class.getResource("/static/left.png");
    public static  ImageIcon leftImage =new ImageIcon(leftUrl);
    //头：向右
    public static  URL rightUrl =Date.class.getResource("/static/right.png");
    public static  ImageIcon rightImage =new ImageIcon(rightUrl);
    //食物
    public static  URL foodUrl =Date.class.getResource("/static/food.png");
    public static  ImageIcon foodImage =new ImageIcon(foodUrl);
}
