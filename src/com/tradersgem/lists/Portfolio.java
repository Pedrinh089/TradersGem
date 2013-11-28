package com.tradersgem.lists;

import java.util.ArrayList;

import android.content.Context;

import com.tradersgem.loginSystem.UserAccount;
import com.tradersgem.stock.Stock;

/**
 * The subClass Portfolio extends the StockList.  This class is the junction between
 * the models that manage the storage of the stocks and the view which will
 * display the stock;
 * The class ListView, that will display all the sublists of StockList, will 
 * be getting the information from this list; 
 * 
 * @author Luiz
 *
 */

public abstract class Portfolio extends StockList
{

	public Portfolio(Context c, UserAccount uA) 
	{
		super(c, uA);
		portfolio= super.getOwnedStocks();
		
	}
	
	public boolean addStocks(Stock stock)
	{
		portfolio.add(stock);
		return super.addStocks(stock);
	}
	
	public boolean deleteStocks(Stock stock)
	{
		
		return super.deleteStocks(stock);
	}
	public void refresh()
	{
		portfolio= super.getOwnedStocks();
	}
	public ArrayList<Stock> getStocks()
	{
		refresh();
		return portfolio;
	}
	
	private static ArrayList<Stock> portfolio;
	
	

}
