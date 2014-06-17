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
	
	
	/*
	 * print the name of company and Year and Month in which company have maximum share price
	 * @param  bs   instance of class according to scenario(currently instance of HighestSharePriceByCompany class)
	 */
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
