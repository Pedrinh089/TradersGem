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
	    
	
	    // TODO Auto-generated method stub
	    // Create Sample Data
	    //ArrayList<String> arrListStr = new ArrayList<String>();
	    //arrListStr.add("Watched Stock 1");
	    //arrListStr.add("Watched Stock 2");
	    
	    if(getIntent().getExtras() != null)
	    {
	    	String userName = getIntent().getStringExtra("String");
	    	stocksDB = new StocksDB(getBaseContext(), userName);
	    	//Date date = new Date();
	    	
	    	//stocksDB.addNewStock(new Stock(1, "Phillips", 3.51f, new Date(), 10, false));
		    
	    	ArrayList<Stock> arrListStr = getWatchedStocks();
		    
	    	Log.d("Current User: ", userName);
	    	
	    	super.loadData(arrListStr);
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
	
	private StocksDB stocksDB;

}
