package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProject {
	
public static void main(String[] args) throws IOException {
	
	FileInputStream fin = new FileInputStream("C:\\Users\\N.Sabari\\OneDrive\\Documents\\Facebook.xlsx");
	
	Workbook w = new XSSFWorkbook(fin);
	
	Sheet s = w.getSheet("Sheet1");
	
	Row r = s.getRow(0);
	
	Cell c = r.getCell(0);
	

	int rowCount = s.getPhysicalNumberOfRows();
	
	int cellCount = r.getPhysicalNumberOfCells();
	
	Object[][] details = new Object[rowCount-1][cellCount];
	
	for (int i = 1; i < rowCount; i++)
	{
		for (int j = 0; j < cellCount; j++) 
		{
			r = s.getRow(i);
			c = r.getCell(j);
			details[i-1][j]=c;
			
			
		}
	}
	
	for (int i = 0; i < rowCount-1; i++) {
		for (int j = 0; j < cellCount; j++) {
			System.out.println(" "+i+" "+j+" "+details[i][j]);
		}
		
	}
}
}
