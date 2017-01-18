package com.excel.poi;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2016/12/15.
 */
public class PoiReadExcel {

    public static void main(String[] args){
        File file = new File("e://excel//poi_test.xls");
        try {
            HSSFWorkbook workBook = new HSSFWorkbook(FileUtils.openInputStream(file));
//            HSSFSheet sheet0 = workBook.getSheet("sheet0");//根据sheet名获取
            HSSFSheet sheet = workBook.getSheetAt(0);//默认获取第一个sheet
            int lastRowNum = sheet.getLastRowNum();//得到行数
            for(int i=0;i<lastRowNum;i++){
                HSSFRow row = sheet.getRow(i);//得到指定行
                short lastCellNum = row.getLastCellNum();//得到行内cell个数
                for(int j=0;j<lastCellNum;j++){
                    HSSFCell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.print(value+" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
