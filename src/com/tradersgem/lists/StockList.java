package com.tradersgem.lists;

import java.util.ArrayList;

import com.tradersgem.stock.Stock;
/**
 * This StockList class is a super class to sub list classes such as watchList and Portfolio;
 * StockList holds all the stocks from all the sublists that extend it .
 * It then makes the report to the database between the classes that have been added 
 * or subtracted from the sublists. 
 * @author Florida
 *
 */
public class StockList 
{

	
	public StockList()
	{
		/**
		 * Begin by adding all the stocks from database into the stocklist.
		 */
		
		/**
		 * Then, add any additional stocks;
		 */
	}
	
	public void addStocks(Stock stock)
	{
		stocks.add(stock);
	}
	public void addStocks(Stock stock1, Stock stock2, Stock stock3)
	{
		stocks.add(stock1);stocks.add(stock2);stocks.add(stock3);
		
	}
	/**
	 * Adding an array of stocks into the the stock list;
	 * @param stock []
	 */
	
	
	public void addStocks( Stock [] stock)
	{
		
		int i=0;
		while (i<stock.length)
		{
			stocks.add(stock[i]);
			i++;
		}
	}
	/**
	 * The method below deletes stocks from the arrayList, who then reports to the 
	 * database. 
	 * 
	 */
	public void deleteStocks(Stock stock)
	{
		int i=0;
		i= stocks.size();
		/**
		 * A loop to traverse the list from the back to the front to delete a stocks;
		 * This loop is made so to avoid problem when deleting from the list; 
		 */
		while (i>0)
		{
			if(stocks.get(i).equals(stock))
			{
				stocks.remove(i);
				return;
			}
			else
			{
				i--;
			}
		}
		
		
		
	}
	
	/**
	 * Declaring all the attributes 
	 */
	private static ArrayList<Stock> stocks;
	
}
