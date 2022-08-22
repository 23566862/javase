package Text;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JDialog extends JFrame implements Icon  {
    private int width;
    private  int heigth;

    public static void main(String[] args) {
    //MyJDialog();  //按钮跳出其他窗口
        //icon();   //自定义图标
        //icon1();  //自定义图片
        //buju();     //使用绝对布局
        //flowLayout();   //使用流布局
        //borderLayout(); //使用界面布局
        //Gridlayout(); //网格布局
        Gridlayout1();
    }
    public static void MyJDialog(){
        JFrame jf =new JFrame("窗口");
        Container co =jf.getContentPane();
        jf.setSize(300,150);
        /*JLabel jl =new JLabel("JFRAME窗体");
        jl.setHorizontalAlignment(SwingConstants.CENTER);   //设置窗口居中*/
        JButton jb =new JButton("JB按钮");
        jb.setBounds(10,10,100,20);
        co.add(jb);
        jf.setVisible(true);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jf1 =new JFrame("窗口");
                Container co1 =jf1.getContentPane();
                jf1.setSize(300,150);
                JLabel jl =new JLabel("JFRAME窗体");
                jl.setHorizontalAlignment(SwingConstants.CENTER);
                co1.add(jl);
                jf1.setVisible(true);
                jf1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            }
        });
    }

    public JDialog(int heigth,int width){
        this.heigth=heigth;
        this.width=width;
    }
    //实现三个方法
    @Override
    public int getIconHeight() {
        return this.heigth;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,heigth);
    }

    //自定义图标
    public static void icon(){
        JDialog jd =new JDialog(15,15);
        JLabel jl =new JLabel("测试",jd,SwingConstants.CENTER);
        JFrame jf =new JFrame();
        jf.setSize(300,150);
        Container co =jf.getContentPane();
        co.add(jl);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //使用图片为图标
    public static void icon1(){
        JFrame jf =new JFrame();
        Container co =jf.getContentPane();
        URL url =JDialog.class.getResource("sda.jpg");
        JLabel jl =new JLabel("自定义图片图标！",JLabel.CENTER);
        Icon ic =new ImageIcon(url);
        jl.setHorizontalAlignment(JLabel.CENTER);
        jl.setIcon(ic);
        //jl.setOpaque(true); //设置标签为不透明
        co.add(jl);
        jf.setSize(250,100);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //取消布局管理器使用绝对布局
    public static void  buju(){
        JFrame jf =new JFrame("使用绝对布局");
        jf.setLayout(null); //取消页面布局
        jf.setBounds(0,0,500,500);  //绝对定位窗口的位置与大小
        JButton jb1 =new JButton("按钮1");
        jb1.setBounds(10,20,102,100);
        JButton jb2 =new JButton("按钮2");
        jb2.setBounds(60,70,200,200);
        jf.add(jb1);
        jf.add(jb2);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //使用流布局，排序更加有序
    public static void flowLayout(){
        JFrame jf =new JFrame("流布局管理窗口");
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));  //窗口左对齐
        for (int i = 0; i <10 ; i++) {
            jf.add(new JButton("按钮"+i));
        }
        jf.setSize(300,200);
        jf.setResizable(false); //设置窗口不能拖动
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //使用边界布局管理器
    public static void borderLayout(){
        JFrame jf =new JFrame("边界布局管理");
        String[] border ={BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST};
        String[] name ={"中间","顶端","底端","右端","左端"};
        //jf.setLayout(new BorderLayout());//设置为边界管理
        for (int i = 0; i <border.length ; i++) {
            jf.add(border[i],new JButton(name[i])); //循环添加按钮
        }
        jf.setSize(350,200);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //使用网格布局
    public static void Gridlayout(){
        JFrame jf =new JFrame("网格布局");
        jf.setLayout(new GridLayout(3,3,10,10));    //三行三列，间距为10，10
        for (int i = 0; i <10 ; i++) {
            jf.add(new JButton("按钮"+i));
        }
        jf.setSize(1000,200);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void Gridlayout1(){
         JButton jb =new JButton("按钮1");
        JFrame jf =new JFrame("设置布局");
        jf.setLayout(new GridLayout(3,3,10,10));
         GridBagConstraints gc =new GridBagConstraints();
        Container co =jf.getContentPane();
        gc.gridx =0;    //设置起始列
        gc.gridy =0;    //设置起始行
        gc.weightx =10; //第一列分布方式为百分之10
        gc.fill =GridBagConstraints.VERTICAL;
       co.add(jb,gc);
        /*for (int i = 0; i <10 ; i++) {
            jf.add(new JButton("按钮"+i),gc);
        }*/
        jf.setSize(100,200);
        //jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       ///第二个窗口
        GridBagConstraints gc1 =new GridBagConstraints();
        JButton jb1 =new JButton("按钮2");
        gc1.gridx =1;    //设置起始列
        gc1.gridy =0;    //设置起始行
        gc1.insets =new Insets(0,5,0,0);
        gc1.weightx=20;
        gc1.fill=GridBagConstraints.HORIZONTAL;
        co.add(jb1,gc1);
    }
}
