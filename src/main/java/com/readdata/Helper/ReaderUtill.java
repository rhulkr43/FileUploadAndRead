package com.readdata.Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.readdata.Entity.Account;

@Component
public class ReaderUtill {
	String line = "";  
	String splitBy = ","; 
	@Autowired
	private UploadHelper uploadHelper;
	public List<Account> getList(String name){
		System.out.println(name);
		List<Account> accounts = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));  
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
			String[] account1 = line.split(splitBy);
			// use comma as separator
			Account a=new Account(account1[0],account1[1],account1[2],account1[3],account1[4],account1[5],account1[6]);
			accounts.add(a);
			} 
			
		}catch(Exception w) {
			w.printStackTrace();
		}
		
		return accounts;
	}
	
	
	public List<Account> readExcel(String name){
		List<Account> accounts = new ArrayList<>();
		 Account account=new Account();
		try {
			 
			 FileInputStream file = new FileInputStream(new File(name));
			 
	            //Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                while (cellIterator.hasNext()) 
	                {
	                    Cell cell = cellIterator.next();
	                    //Check the cell type and format accordingly
	                  
	                        if(cell.getColumnIndex()==0) {
	                        	account.setId(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==1) {
	                        	account.setAccount_type(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==2) {
	                        	account.setPtype(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==3) {
	                        	account.setAccount_type(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==4) {
	                        	account.setRemark(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==5) {
	                        	account.setName(cell.getStringCellValue());
	                        }
	                        if(cell.getColumnIndex()==6) {
	                        	account.setDate(cell.getStringCellValue());
	                        }
	                   
	                        accounts.add(account);
	                   
	                }
	                System.out.println("sc");
	            }
	            file.close();

	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public String textRead(String name) {
		String dataString="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(name));  
			
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				dataString+=line;
				
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dataString;
	}
	
	public String readPdf(String name) {
		String dataString="";
		try {
			 File file = new File(name);
		      PDDocument document = PDDocument.load(file);
		      PDFTextStripper pdfStripper = new PDFTextStripper();
		      //Retrieving text from PDF document
		      dataString= pdfStripper.getText(document);
		      //Closing the document
		      document.close();
		     
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dataString;
	}

}
		
