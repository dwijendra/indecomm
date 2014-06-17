package com.indecomm.exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.filechooser.FileNameExtensionFilter;
/*
 *  parse csv file
 */
public class CSVParser {
        private ArrayList<DateWiseEntry>  totalEntry=null;
        private static CSVParser instance=null;
        private String[] header;
      
       private boolean isHeaderValid(String line)
       {
    	   Boolean flag=true;
			     header = line.split(Constants.Seperator);
			     HashMap<String, Integer> uniqueFieldcheck=new HashMap<>();
			     for(int i=0;i<header.length;i++)
			     {
			    	 
			    	
			    	if(header[i]==null ||"".equals(header[i]) ) 
			    	{
			    		flag=false;
			    		break;
			    	}
			    	if(uniqueFieldcheck.containsKey(header[i]))
			    	{
			    		flag=false;
			    		break;
			    	}
			    	else
			    	{
			    		uniqueFieldcheck.put(header[i],1);
			    	}
			     }
			    uniqueFieldcheck=null;
				// Header length must be greater than 2
				if(line.equals("")||header.length <= 2||!header[0].equals(Constants.yearString )||!header[1].equals(Constants.monthString)) {
					flag=false;
				}
			return flag;
    	   
       }
       private CSVParser()
       {
    	 
   		
   		int yearIndex = 0;
   		int monthIndex = 1;
   		totalEntry=new ArrayList<DateWiseEntry>();
   		BufferedReader br = null;
   		String line = "";
   	 
   		try {
   			
   	           
   			br = new BufferedReader(new FileReader(Constants.FilePath));
   			
   			// Extract headers and indexes
   			
   			if ((line = br.readLine()) != null) {
   				Boolean flag=isHeaderValid(line);
   	             if(!flag)
   			    {
   			    	throw new Exception(Constants.HeaderConstraints);
   			    }
   			} 
   			
   			
   			     while ((line = br.readLine()) != null) {
   				
   				if(line.equals("")) {	// Avoid and continue functioning if blank line is encountered
   					continue;
   				}
   				   				
   				String[] elements = line.split(Constants.Seperator);
   				if(elements.length != header.length) {
   					// Extra or lesser price values as compared to company names
   					throw new RuntimeException("Incorrect number of values found");
   				}
   				totalEntry.add(new DateWiseEntry(elements));
   			  	
   			}
   		} catch (FileNotFoundException e) {
   			System.out.println("Error : Invalid file path or name");
   		} catch (Exception e) {
   			// e.printStackTrace();
   			System.out.println(e.getMessage());
   		} finally {
   			if (br != null) {
   				try {
   					br.close();
   				} catch (IOException e) {
   					e.printStackTrace();
   				}
   			}
   		}
   		
   	
    	   
       }
       public static CSVParser getInstance()
       {
    	   if(instance==null)
    	   {
    		   instance= new CSVParser();  
    	   }
    	   
    	   return instance;
       }
       public ArrayList<DateWiseEntry> getEntries()
       {
    	  
    	   return totalEntry;
       }
       
       // it maps the name of company by index 
       public  String getCompanyNameByIndex(int index)
       {
    	   // first is Year and second is Month thats why name is [index+2]
    	   return header[index+2];
       }
       public  static void refresh()
       {
    	   instance=null;
       }
       
       
       
}
