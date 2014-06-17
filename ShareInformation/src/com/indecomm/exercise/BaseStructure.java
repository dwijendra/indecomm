package com.indecomm.exercise;

import java.awt.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*
 * 
 * it contains ArrayList of DateWiseEntry(CSV row)
 * having  abstract getList method  which will be  override in scenario classes
 */

public abstract class BaseStructure {
	
	
	// holds total rows of csv file
	protected ArrayList<DateWiseEntry> totalEntry;
	
	protected CSVParser parser;
	//protected  ArrayList<DateWiseEntry> ListByCurrentScenario ;
	public BaseStructure()
	{  
		parser=CSVParser.getInstance();
		totalEntry=parser.getEntries();
	}
	//will be overide by the specific scenario classes
	public abstract HashMap<String, DateWiseEntry> getList();

}
