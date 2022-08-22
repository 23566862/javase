package 贪吃蛇小游戏.src.snake;

import javax.swing.*;

public class gameMain  {
    public static void main(String[] args) {
        JFrame jf =new JFrame("贪吃蛇小游戏");
        jf.setBounds(20,20,920,720);
        jf.setResizable(false);
        //添加面板，画图 jpanel
        jf.add(new GameJpane());
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
