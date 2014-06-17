package com.indecomm.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

import com.indecomm.exercise.CSVParser;
import com.indecomm.exercise.Constants;
import com.indecomm.exercise.DateWiseEntry;
import com.indecomm.scenario.HighestSharePriceByCompany;

public class HighestSharePriceByCompanyTest {

	
	
	/**
	 * 
	 * Test cases list :
	 * 
	 * Blank file
	 * with no company columns
	 * year before specified Year
	 * year non Integer format
	 * Multiple maximum values
	 * Blank stock price
	 * Year in incorrect header
	 * month in incorrect header
	 * Negative  stock price
	 * non integer stock price
	 * Mismatch no of elements in a row
	 * Blank line(s) in file
	
	 * Blank company name
	 
	
	 */
	/* get map of  HighestSharePriceByCompany  key(company name) value(DateWiseEntry object) */
	public  HashMap<String, DateWiseEntry> execute()
	{
		 return new HighestSharePriceByCompany().getList();
	}
	
	/*  test if file does not contain any data */
	@Test
	public void testBlankFile()
	{
		Constants.FilePath="src\\blank.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());
	}
	
	/*  test if file does not have any company column
	 * file have only Year and Mont field */
	@Test
	public void testNoCompanyColumn()
	{
		Constants.FilePath="src\\noCompany.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());
	}
	
	
	/*
	 * test for date before 1990 
	 */
	@Test
	public void testBeforeSpecifiedYear()
	{
		Constants.FilePath="src\\beforeYear.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	
	/*
	 * test for year should integer value
	 */
	@Test
	public void testNonIntegerYear()
	{
		Constants.FilePath="src\\nonIntegerYr.csv";
		
	}
	
	/*
	 * test if company have multiple max value for share  
	 */
	@Test
	public void testMultipleMaxValue()
	{
		Constants.FilePath="src\\MultiMax.csv";
		HashMap<String, DateWiseEntry> map=new HashMap<String, DateWiseEntry>();
		
		map.put("Company-D",new DateWiseEntry("2002,Apr,663,726,731,999,51".split(",")));
		map.put("Company-E", new DateWiseEntry("2008,Oct,552,639,521,798,997".split(",")));
		map.put("Company-A", new DateWiseEntry("1990,Jan,1000,552,829,289,649".split(",")));
		map.put("Company-B",new  DateWiseEntry("2007,Mar,88,986,869,242,571".split(",")));
		map.put("Company-C", new DateWiseEntry("1993,Jun,841,514,995,723,662".split(",")));
		
		CSVParser.refresh();
		
		
		assertEquals(execute(),map);

	}
	/*
	 * test for missing stock price cell
	 */
	
	@Test
	public void testBlankStockPrice()
	{
		Constants.FilePath="src\\BlankPrice.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	
	/*
	 * test for order and index of Year and Field in the header
	 */
	@Test
	public void testyearOrMonthInIncorrectHeader()
	{
		Constants.FilePath="src\\yRmInINcorrectHeader.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	/*
	 * test if stock price have any negative value field
	 */
	@Test
	public void testnegativeStockPrice()
	{
		Constants.FilePath="src\\NegativeSTockPrice.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	/*
	 * test if stockprice is any string(character value)
	 */
	
	@Test
	public void testnonIntegerStockPrice()
	{
		Constants.FilePath="src\\nonIntegerStockPrice.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	
	/*
	 * test for mismatch in no of field in header and noof field in rest row
	 */
	@Test
	public void testmisMatchNoOfElementInRow()
	{
		Constants.FilePath="src\\misMatchNoOfElementInRow.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	
	/*
	 * test if any blank row in the CSV
	 */
	@Test
	public void testblankLineInFiles()
	{
		Constants.FilePath="src\\blankLineInFiles.csv";
        HashMap<String, DateWiseEntry> map=new HashMap<String, DateWiseEntry>();
		map.put("Company-D",new DateWiseEntry("2002,Apr,663,726,731,999,51".split(",")));
		map.put("Company-E", new DateWiseEntry("2008,Oct,552,639,521,798,997".split(",")));
		map.put("Company-A", new DateWiseEntry("2000,Mar,1000,900,738,930,440".split(",")));
		map.put("Company-B",new  DateWiseEntry("2007,Mar,88,986,869,242,571".split(",")));
		map.put("Company-C", new DateWiseEntry("1993,Jun,841,514,995,723,662".split(",")));
		
		CSVParser.refresh();
		assertEquals(execute(),map);

	}
	
	
	/*
	 * test if any companny name cell blank in header
	 */
	
	@Test
	public void testblankCompanyName()
	{
		Constants.FilePath="src\\blankComapanyNames.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}
	/*
	 * test header field name should be unique
	 */
	
	@Test
	public void testheaderFieldShouldBeUnique()
	{
		Constants.FilePath="src\\uniqueHeader.csv";
		CSVParser.refresh();
		assertEquals(execute(),new HashMap<String, DateWiseEntry>());

	}


}
