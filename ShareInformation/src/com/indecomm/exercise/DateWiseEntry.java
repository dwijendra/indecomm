package com.indecomm.exercise;

import java.util.ArrayList;

public class DateWiseEntry {
	
	// this class is mainly for map entry(row) in the CSV file
	private int year;
	private String month;
    private ArrayList<Integer> sharePrices;
	public DateWiseEntry(String [] data)
	{
		sharePrices=new ArrayList<Integer>();
		try {
			
			year=Integer.parseInt(data[0]);
			if(year<1990)
			{
			  throw new NumberFormatException();	
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new RuntimeException(Constants.YearConstraints,e);
		}
		
			
		month=data[1];
		for(int i=2;i<data.length;i++)
		{
			int val;
			
			try {
				
				val=Integer.parseInt(data[i]);
				if(val<0)
				{
				  throw new NumberFormatException();	
				}
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new RuntimeException(Constants.SharePriceConstraints,e);
			}
			
			sharePrices.add(val);
		}
		
		
	}
	public int getYear()
	{
		return year;
	}
	public String getMonth()
	{
		return month;
	}
	public int getSharePriceByCompanyIndex(int i)
	{
		return sharePrices.get(i);
	}
	public  ArrayList<Integer> getSharePrices()
	{
		return sharePrices;
	}
	public boolean equals(Object o)
	{ 
		DateWiseEntry obj=(DateWiseEntry)o;
		if(obj.getSharePrices().size()!=sharePrices.size())
		{
			return false;
		}
		if((year==obj.getYear()) && month.equals(obj.getMonth()) )
		{
			
			for(int counter = 0; counter < sharePrices.size(); counter++) {
			     if(!obj.getSharePrices().get(counter).equals(sharePrices.get(counter))) 
			      {
			    	
			        return false;  
			      }
			  }
			return true;
		}
		return false;
	}

}
