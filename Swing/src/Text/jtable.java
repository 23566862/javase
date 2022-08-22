package Text;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class jtable {
    Vector rowdate,colunnames;
    private ResultSetMetaData rsmd;
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");

        f.setSize(400, 300);

        //f.setLocation(200, 200);

        f.setLayout(new BorderLayout());
       /* //表格排序器
        RowSorter<>*/


        String[] columnNames = new String[] { "id", "name", "hp", "damage" };

        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },

                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" },{"1", "盖伦", "616", "100"} };
        DefaultTableModel dtm =new DefaultTableModel(heros,columnNames);    //表格模型
        JTable t = new JTable(dtm);
        JScrollPane sp =new JScrollPane(t);
        t.setSelectionForeground(Color.red);        //设置字体颜色，鼠标选中一行都为红色
       // t.setSelectionBackground(Color.yellow); //设置背景色
        t.setRowHeight(30); //设置行高
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //设置为单选，只能选一行,默认连选
        System.out.println("行"+t.getRowCount()+"列"+t.getColumnCount()); //行数列数
        System.out.println(t.getColumnName(0)); //  列名称
        System.out.println(t.getValueAt(1,1));

        //表格模型添加数据
        String [] arr ={"1", "盖伦", "616", "100"};
       // dtm.addRow(arr);

        //dtm.setValueAt("盲僧",3,1);   //修改
        //dtm.removeRow(1);     //删除行数
        // 设置列宽度
        //t.getColumnModel().getColumn(0).setPreferredWidth(10);
        f.add(sp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
