package com.tradersgem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.os.Bundle;
import android.util.Log;

public class WatchedStockList extends StockList 
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	
	    if(getIntent().getExtras() != null)
	    {
	    	String userName = getIntent().getStringExtra("String");
	    	stocksDB = new StocksDB(getBaseContext(), userName);
	    	
	    	// Add Sample Data
	    	//stocksDB.addNewStock(new Stock(1, "Phillips", 3.51f, new Date(), 10, false));
		    
	    	watchedStockList = getWatchedStocks();
		    
	    	Log.d("Current User: ", userName);
	    	
	    	super.loadData(watchedStockList);
	    }
	}
	
	public ArrayList<Stock> getWatchedStocks()
	{
		ArrayList<Stock> watchedStocks = new ArrayList<Stock>();
		Iterator<Stock> iterator = stocksDB.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(!stock.getOwnedStatus())
				watchedStocks.add(stock);
		}
		
		
		return watchedStocks;
	}
	
	public void onItemClick(int mPosition)
	{
		Stock tempValues = (Stock) watchedStockList.get(mPosition);
		
		super.showClickedItem(tempValues);
	}
	
	private StocksDB stocksDB;
	private ArrayList<Stock> watchedStockList;

}
