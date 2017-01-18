package com.excel.poi;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 2016/12/15.
 */
public class PoiExcel {

    public static void main(String[] args) throws IOException {
        String[] title = {"编号","姓名","性别"};
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet = workbook.createSheet("sheet0");
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        for(int i=0;i<3;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加内容
        for(int i=1;i<10;i++){
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue("a"+i);
            cell = row.createCell(1);
            cell.setCellValue("jack");
            cell = row.createCell(2);
            cell.setCellValue("男");
        }
        //创建一个文件
        File file = new File("e://excel//poi_test.xls");
        file.createNewFile();
        FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
