package com.excel.jxl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2016/12/15.
 */
public class JxlReadExcel {

    public static void main(String[] args){
        try {
            Workbook workbook = Workbook.getWorkbook(new File("e://excel//jxl_test.xls"));
            Sheet sheet = workbook.getSheet(0);
            for (int i=0;i<sheet.getRows();i++){
                for(int j=0;j<sheet.getColumns();j++){
                    Cell cell = sheet.getCell(j, i);
                    System.out.print(cell.getContents()+" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
