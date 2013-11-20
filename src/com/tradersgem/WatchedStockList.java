package com.tradersgem;

import java.util.ArrayList;

import android.os.Bundle;

public class WatchedStockList extends StockList 
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	
	    // TODO Auto-generated method stub
	    // Create Sample Data
	    ArrayList<String> arrListStr = new ArrayList<String>();
	    arrListStr.add("Watched Stock 1");
	    arrListStr.add("Watched Stock 2");
	    
	    super.loadData(arrListStr);
	}

}
