package com.indecomm.scenario;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.indecomm.exercise.BaseStructure;
import com.indecomm.exercise.DateWiseEntry;

public class HighestSharePriceByCompany extends BaseStructure {

	//return map for each Company year and month in which the share price was highest.
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
