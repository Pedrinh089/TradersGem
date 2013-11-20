package com.tradersgem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.os.Bundle;
import android.util.Log;

public class OwnedStockList extends StockList
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	    // Create Sample Data
	    //ArrayList<String> arrListStr = new ArrayList<String>();
	    //arrListStr.add("My Stock 1");
	    //arrListStr.add("My Stock 2");
	    
	    if(getIntent().getExtras() != null)
	    {
	    	String userName = getIntent().getStringExtra("String");
	    	stocksDB = new StocksDB(getBaseContext(), userName);
	    	//Date date = new Date();
	    	
	    	//stocksDB.addNewStock(new Stock(1, "Masmio", 3.51f, date, 10, true));
		    
	    	ArrayList<Stock> arrListStr = getOwnedStocks();
		    
	    	Log.d("Current User: ", userName);
	    	
	    	super.loadData(arrListStr);
	    }
	    
	}
	
	public ArrayList<Stock> getOwnedStocks()
	{
		ArrayList<Stock> ownedStocks = new ArrayList<Stock>();
		Iterator<Stock> iterator = stocksDB.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(stock.getOwnedStatus())
				ownedStocks.add(stock);
		}
		
		
		return ownedStocks;
	}
	
	private StocksDB stocksDB;

}
