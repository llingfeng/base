package com.excel.jxl;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.biff.WritableWorkbookImpl;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2016/12/15.
 */
public class JxlExcel {

    public static void main(String[] args){
        String[] title = {"编号","姓名","性别"};
        String path = "e://excel";
        File filePath = new File(path);
        if(!filePath.exists()){
            filePath.mkdir();
        }
        File file = new File(filePath,"jxl_test.xls");
        try {
            file.createNewFile();
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //创建Lable
            Label label = null;
            //第一行设置列名
            for(int i=0;i<3;i++){
                label = new Label(i,0,title[i]);
                sheet.addCell(label);
            }
            //追加数据
            for(int i=1;i<10;i++){
                label = new Label(0,i,"a"+i);
                sheet.addCell(label);
                label = new Label(1,i,"jack");
                sheet.addCell(label);
                label = new Label(2,i,"男");
                sheet.addCell(label);
            }
            //写入数据
            workbook.write();
            //关闭
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
