package Text;

import org.apache.poi.hssf.usermodel.*;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class 表格到excel {
   static String [] ob =new String[]{"图书编号", "书名", "学号", "姓名", "日期", "接书状态"};
    //HSSFWorkbook 03版 xls结尾    //速度快，最多行数为65535
    //XSSFWorkbook 06版 xlsx结尾   //速度慢一点，存储数据范围广
    //SXSSFWorkbook 升级版         //速度快，范围更大
    public static void main(String[] args) throws IOException {
        //hssf03();
       // redexcel();
        redexcel1();
    }

    //基础Hssf03版 写入数据
    public static void hssf03() throws IOException {
        Workbook book =new HSSFWorkbook();
        Sheet sheet = book.createSheet("表1");
        //创建表头
            Row row1 = sheet.createRow(0);
        for (int i = 0; i <6 ; i++) {
            Cell cell = row1.createCell(i);
            cell.setCellValue(ob[i]);

        }
        //创建5行6列
        for (int i = 1; i <=5 ; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j <6 ; j++) {
                row.createCell(j).setCellValue(j);
            }
        }
        FileOutputStream out =new FileOutputStream("swing\\excel.xls");
        book.write(out);
        book.close();
        System.out.println("创建成功！");
    }

    //读取excel数据
    public static void redexcel(){
        try {
            FileInputStream file = new FileInputStream("swing\\excel.xls");
            Workbook book =new HSSFWorkbook(file);
            //得到表
            Sheet sheet = book.getSheetAt(0);
            //获取行
            Row row = sheet.getRow(0);
            //获取列
            for (int i = 0; i <6 ; i++) {
                Cell cell = row.getCell(i);
                String s = cell.getStringCellValue();
                System.out.println(s);
            }
            Row row1 = sheet.getRow(1);
            System.out.println(row1.getCell(0).getNumericCellValue());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //读取不同数据类型万能公式
    public static void redexcel1() throws IOException {
        FileInputStream file = new FileInputStream("swing\\excel.xls");
        Workbook book =new HSSFWorkbook(file);
        //得到表
        Sheet sheet = book.getSheetAt(0);
       //获取有多少行数据
        int countrow = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i <countrow ; i++) {
            Row row = sheet.getRow(i);
            if (row !=null){//如果当前行数内容不为空
                int countcell = row.getPhysicalNumberOfCells();//获取当前行数的列数
                for (int j = 0; j <countcell ; j++) {
                    Cell cell = row.getCell(j);
                    if (cell !=null){
                        int cellType = cell.getCellType();
                        switch (cellType){
                            case HSSFCell.CELL_TYPE_STRING: //如果是字符串类型
                                String stringCellValue = cell.getStringCellValue();
                                System.out.println(stringCellValue);
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:    //boolean类型
                                boolean booleanCellValue = cell.getBooleanCellValue();//获取布尔类型
                                System.out.println(booleanCellValue);
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:  //为空
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:    //数字类型（date时间 和数字）
                                if (HSSFDateUtil.isCellDateFormatted(cell)){//HSSFDateUtil.isCellDateFormatted(cell)判断是否是时间
                                    Date date = cell.getDateCellValue();
                                    System.out.println(date);
                                }else{
                                    //数字类型
                                    double numericCellValue = cell.getNumericCellValue();
                                    System.out.println(numericCellValue);
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
                                break;

                        }
                    }
                }
            }
        }
        file.close();

    }


}
