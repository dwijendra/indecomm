package com.indecomm.scenario;


import java.util.HashMap;

import java.util.Map.Entry;
import java.util.Set;

import com.indecomm.exercise.BaseStructure;
import com.indecomm.exercise.DateWiseEntry;

/*
 * to find HighestSharePrice row for each company
 */


public class HighestSharePriceByCompany extends BaseStructure {

	/*find the maximum share price of the company
	 * 
	 * @return map <key-- is name of the company, value--entry which have maximum share price >.*/
	@Override
	public HashMap<String,DateWiseEntry> getList() {
		// TODO Auto-generated method stub
		HashMap<String,DateWiseEntry> result=new HashMap<>();
		for(int i=0;i<totalEntry.size();i++)
		{
			// for all entry check the share prices company wise
			for(int j=0;j<totalEntry.get(i).getSharePrices().size();j++)
			{
				
				int companySharePrice=totalEntry.get(i).getSharePrices().get(j);
				String companyName=parser.getCompanyNameByIndex(j);
				if(result.containsKey(companyName))
				{
					if(result.get(companyName).getSharePrices().get(j)<companySharePrice)
					{
						result.put(companyName, totalEntry.get(i));
					}
				}
				else
				{
					result.put(companyName, totalEntry.get(i));
				}
			}
		}
		
		return result;
		        
		              
	}

}
