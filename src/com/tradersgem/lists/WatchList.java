package com.tradersgem.lists;

import java.util.ArrayList;

import android.content.Context;

import com.tradersgem.loginSystem.UserAccount;
import com.tradersgem.stock.Stock;

/**
 *  WatchList is a subClass of StockList. It takes all stocks into an array, 
 *  and makes the amendment between ListView and the Stocks in StockList
 *  Any aggregated stock will go to StockList and eventually the Database;
 * 
 * @author Luiz
 *
 */

public abstract class WatchList extends StockList
{

	public WatchList(Context c, UserAccount uA) {
		super(c, uA);
		watchList= super.getAllStocks();
		
		
	}

	
	/**
	 * The following method returns the ArrayList watchList, that is held by this 
	 * object;
	 * @return
	 */
	public ArrayList<Stock> getStocks()
	{
		return watchList;
	
	}
	
	
	public boolean addStocks(Stock stock)
	{
		return super.addStocks(stock);
	}
	
	public boolean deleteStocks(Stock stock)
	{
		return super.deleteStocks(stock);
	}
	
	
	
	
	public static ArrayList<Stock> watchList;
}
