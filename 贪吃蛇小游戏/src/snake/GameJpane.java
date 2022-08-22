package 贪吃蛇小游戏.src.snake;

import javax.swing.*;
import java.awt.*;

//面板界面
public class GameJpane extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);
        Date.headerImage.paintIcon(this,g,25,12);//给画板添加图片
        g.fillRect(25, 75, 850, 600);//绘制游戏区域

    }
}
