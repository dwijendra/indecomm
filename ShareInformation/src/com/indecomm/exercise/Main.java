package com.indecomm.exercise;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.indecomm.scenario.HighestSharePriceByCompany;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Constants.FilePath="src\\blankLineInFiles.csv";


		HighestSharePriceByCompany hp=new HighestSharePriceByCompany();
		
		
		printList(hp);
		//Test.headerFieldShouldBeUnique();

	}
	
	public static void printList(BaseStructure bs)
	{
		HashMap<String,DateWiseEntry> result= bs.getList();
		
		
		 Set<Entry<String,DateWiseEntry>> entrySet=result.entrySet();
         
         for(Entry<String,DateWiseEntry> e:entrySet)
         {
       	  DateWiseEntry dt=e.getValue();
       	  System.out.println(e.getKey()+"  Year  "+dt.getYear()+"  Month "+dt.getMonth());
         }
         
         
        
	}

}
