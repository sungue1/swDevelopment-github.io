package com.example.SW_PBL.Festival;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ListSort{
    public static final String FILE_PATH = "C:/Users/PC/Desktop/InteliJ Project/KeyWord.xlsx";
    
    private String[][] DataList = new String[1000][2];
    public int rw = 0;
    public int cl = 0;
    public String[][] GetList() {
        try {
            OPCPackage opcPackage = OPCPackage.open(new File(FILE_PATH));
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            rw = rows;
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row != null) {
                    int columns = row.getPhysicalNumberOfCells();
                    cl = columns;
                    for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                        XSSFCell column = row.getCell(columnIndex);
                        String value = "";
                        value = column.getStringCellValue();
                        DataList[rowIndex][columnIndex] = value;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return DataList;
    }
}
