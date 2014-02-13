package com.poi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileRead  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          File customers = null;
          FileInputStream fis = null;
		
		try {
            
			// To consider only last 365 days transaction, generate cutoff date from current date
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String today = dateformat.format(date);
			int cutoffyear = Integer.parseInt(today.substring(0,4))-1;
			Calendar cal = Calendar.getInstance();
			cal.set(cutoffyear, date.getMonth(), date.getDate());
			Date cutoffdate = cal.getTime();
			
			
			// Open XLSX file using POI API's
			HashMap cust_transaction =  new HashMap();
			customers = new File("C:\\Users\\Nilang\\Documents\\customer.xlsx");
			fis = new FileInputStream(customers);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("sheet1");

			Iterator rowIter = ws.rowIterator();
			while (rowIter.hasNext()) 
			{
				Row rr = (Row) rowIter.next();
								
				// Next line will check for blank row and header row.				
				if (rr.toString() != null && !rr.getCell(0).toString().equals("CustomerID")) 
				{
					
					String  customer = rr.getCell(1).toString().trim()+" "+rr.getCell(2).toString().trim();
					Date transdate = rr.getCell(3).getDateCellValue();
					double amount = rr.getCell(4).getNumericCellValue();
				   	
				   	if(transdate.after(cutoffdate)) // if transaction date is after cutoff date then proceed
				   	{	
				   		
				   		if ( cust_transaction.containsKey(customer))
					    {
						  double value = (double) cust_transaction.get(customer);
						  double new_amount = value + amount;
						  cust_transaction.put(customer, new_amount);
					    }	
					   else
					   {
						cust_transaction.put(customer,amount);
								
					   }	
				   	}  
				}	
					
			}
			
			// To sort TreeMap use collection's sort functionality by creating comparator 
			// for TreeMap values.
			 List list = new ArrayList(cust_transaction.entrySet());
			 Collections.sort(list, new Comparator()
			 						{
				 						public int compare(Object ob1, Object ob2)
				 							{
				 								Map.Entry me1 = (Map.Entry)ob1;
				 								double val1 = (double) me1.getValue();
				 								Map.Entry me2 = (Map.Entry)ob2;
				 								double val2 = (double)me2.getValue();
				 								return Double.compare(val1,val2);
				 							}
			 						} 
					 		); // an anonymous class
			 
			 
			 /* List Array is sorted in ascending order.
			    To print the list in backward order use size parameter of list.
			*/
			 for (int i = list.size()-1, j=0 ; i >= 0 ; i--,j++)
			 {
				 if (j == 5)
					   break;
				 else
				 {	 
					 Map.Entry entry= (Map.Entry) list.get(i);
					 System.out.println(entry.getKey() + "   " + entry.getValue());
				 }	 
					  
			 }
			
		
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		

	}

	
	
}
