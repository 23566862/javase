package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class user {
    public user() {
        GridBagConstraints gc =new GridBagConstraints();
        JFrame jf =new JFrame("网格包布局");
        jf.setResizable(false);
       // jf.setLocationRelativeTo(null);
        jf.setSize(500,400);
        Container c =jf.getContentPane();
        c.setLayout(new GridBagLayout());
        //按钮a
        /*for (int i = 0; i <10 ; i++) {
            gc.gridx=0;
            gc.gridy=i;
            c.add(new JButton("A"),gc);

            gc.gridx=i;
            gc.gridy=0;
            c.add(new JButton("B"),gc);
        }*/
        //a
        GridBagConstraints a =new GridBagConstraints();
        a.gridx=0;
        a.gridy=0;
        c.add(new JButton("A"),a);

        //b
        GridBagConstraints b =new GridBagConstraints();
        b.gridx=1;
        b.gridy=0;
        b.gridwidth=2;
        b.fill=GridBagConstraints.HORIZONTAL;
        b.insets =new Insets(0,5,0,0);
        c.add(new JButton("B"),b);
        //c
        GridBagConstraints c1 =new GridBagConstraints();
        c1.gridx =3;
        c1.gridy=0;
        c1.gridwidth=3;
        c1.gridheight=2;
        c1.insets =new Insets(0,5,0,0);
        c1.fill =GridBagConstraints.BOTH;
        c.add(new JButton("C"),c1);

        //D
        GridBagConstraints d =new GridBagConstraints();
        d.gridx=6;
        d.gridy=0;
        d.gridwidth=4;
        d.gridheight=4;
        d.fill=GridBagConstraints.BOTH;
        d.insets =new Insets(0,5,0,0);
        c.add(new JButton("D"),d);

        //E
        GridBagConstraints e =new GridBagConstraints();
        e.gridx=0;
        e.gridy=1;
        e.gridwidth=3;
        e.fill=GridBagConstraints.HORIZONTAL;
        e.insets =new Insets(5,0,0,0);
        c.add(new JButton("E"),e);
        //F
        GridBagConstraints f =new GridBagConstraints();
        f.gridx=0;
        f.gridy=2;
        f.insets =new Insets(5,0,0,0);
        c.add(new JButton("F"),f);

        //H
        GridBagConstraints h =new GridBagConstraints();
        h.gridx=0;
        h.gridy=3;
        h.insets =new Insets(5,0,0,0);
        c.add(new JButton("H"),h);

        //G
        GridBagConstraints g =new GridBagConstraints();
        g.gridx=1;
        g.gridy=2;
        g.gridwidth=5;
        g.gridheight=2;
        g.insets =new Insets(0,5,0,0);
        g.fill =GridBagConstraints.BOTH;
        c.add(new JButton("G"),g);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }

    public static void main(String[] args) {
        new user();

        }

}
