package com.occurance.excelutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readXLData(String path, String sheet, int row , int column) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		String data = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		return data;
	}
	public void writeXLData(String path, String sheet, int row , int column , String value) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).getRow(row).getCell(column).setCellValue(value);
		wb.write(new FileOutputStream(path));
	}
	public int getRowCount(String path, String sheet) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		return wb.getSheet(sheet).getLastRowNum();
	}
	
}
