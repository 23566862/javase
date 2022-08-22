package Text;

import javafx.stage.FileChooser;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class poi导出和导入 {
     public  static void daoru(String [][] data,String []ob) throws IOException {
         JFileChooser choie=new JFileChooser();
         int num = choie.showSaveDialog(null);
         if (num==JFileChooser.CANCEL_OPTION){
             JOptionPane.showMessageDialog(null,"选择器已关闭");
         }
         if (num==JFileChooser.APPROVE_OPTION){
             String path =choie.getSelectedFile().getPath()+".xls";
             FileOutputStream file =new FileOutputStream(path);
             Workbook book =new HSSFWorkbook();
             Sheet sheet = book.createSheet("表1");
             //创建表头
             Row row = sheet.createRow(0);
             for (int i = 0; i <ob.length ; i++) {
                 Cell cell = row.createCell(i);
                 cell.setCellValue(ob[i]);
             }

             //excel数据
             int count =0;
             for (int i = 1; i <=data.length ; i++) {
                 Row row1 = sheet.createRow(i);
                 for (int j = 0; j <data[count].length ; j++) {
                     row1.createCell(j).setCellValue(data[count][j]);
                 }
                 count++;
             }

             book.write(file);
             file.close();
             JOptionPane.showMessageDialog(null,"创建表格成功!位置在:"+path);
         }

    }

    public static class myFileFitlter extends FileFilter{

        @Override
        public boolean accept(File f) {
            String name =f.getName();
            return f.isDirectory() ||name.toLowerCase().endsWith(".xls");
        }

        @Override
        public String getDescription() {
            return "*.xls";
        }
    }
    public static ArrayList dachu(){
         ArrayList<ArrayList<Object>> al =new ArrayList<>();
         ArrayList<Object> aa =new ArrayList<>();
        JFileChooser choie=new JFileChooser();

        choie.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.getName().endsWith("xls")) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getDescription() {
                return ".xls";
            }
        });

        int num = choie.showOpenDialog(null);

        if (num==JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null,"选择器已关闭");
        }
        if (num==JFileChooser.APPROVE_OPTION){
            try {
                FileInputStream fl=new FileInputStream(choie.getSelectedFile());
                Workbook book =new HSSFWorkbook(fl);
                Sheet sheetAt = book.getSheetAt(0);
                int rowcount = sheetAt.getPhysicalNumberOfRows();
                for (int i = 0; i <rowcount ; i++) {
                    Row row = sheetAt.getRow(i);
                    if (row !=null){
                        int rellcount = row.getPhysicalNumberOfCells();
                        for (int j = 0; j <rellcount ; j++) {
                            Cell cell = row.getCell(j);
                            if (cell !=null){
                                int cellType = cell.getCellType();
                                switch (cellType){
                                    case HSSFCell.CELL_TYPE_STRING: //如果是字符串类型
                                       aa.add(cell.getStringCellValue());
                                        break;
                                    case HSSFCell.CELL_TYPE_BOOLEAN:    //boolean类型
                                        aa.add(cell.getBooleanCellValue());
                                       /* boolean booleanCellValue = cell.getBooleanCellValue();//获取布尔类型
                                        System.out.println(booleanCellValue);*/
                                        break;
                                    case HSSFCell.CELL_TYPE_BLANK:  //为空
                                        break;
                                    case HSSFCell.CELL_TYPE_NUMERIC:    //数字类型（date时间 和数字）
                                        if (HSSFDateUtil.isCellDateFormatted(cell)){//HSSFDateUtil.isCellDateFormatted(cell)判断是否是时间
                                            aa.add(cell.getDateCellValue());
                                           /* Date date = cell.getDateCellValue();
                                            System.out.println(date);*/
                                        }else{
                                            //数字类型
                                            aa.add(cell.getNumericCellValue());
                                            /*double numericCellValue = cell.getNumericCellValue();
                                            System.out.println(numericCellValue);*/
                                        }
                                        break;
                                    case HSSFCell.CELL_TYPE_ERROR://错误
                                        //错误类型
                                        break;
                                    case HSSFCell.CELL_TYPE_FORMULA://带公式的单元格
                                        //拿到计算公式
                                        FormulaEvaluator form =new HSSFFormulaEvaluator((HSSFWorkbook) book);
                                        String gonsih = cell.getCellFormula();//拿到公式字符串
                                        CellValue evaluate = form.evaluate(cell);//计算值
                                        String string = evaluate.formatAsString();//得到值
                                        aa.add(Integer.parseInt(string));
                                        break;

                                }
                            }
                        }
                    }
                    al.add(aa);
                }
                fl.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return al;
    }
    public static void main(String[] args) {
        /* String[] s1 = {"中国","美国","日本","澳大利亚","法国","德国","英国"};
         String[][] ss =new String[][]{{"北京","上海","广州","深圳"},
                 {"华盛顿","纽约","芝加哥","旧金山"},
                 {"东京","大阪","名古屋","北海道"},
                 {"悉尼","堪培拉","珀斯"},
                 {"巴黎","南特","德勒","鲁昂"},
                 {"柏林","华沙","卢布林","波兹南"},
                 {"伦敦","曼切斯特","诺丁汉","牛津"}};

        try {
            daoru(ss,s1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        ArrayList dachu = dachu();

    }
}
