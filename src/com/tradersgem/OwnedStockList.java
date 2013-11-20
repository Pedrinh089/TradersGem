package com.tradersgem;

import java.util.ArrayList;

import android.os.Bundle;

public class OwnedStockList extends StockList
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	    // Create Sample Data
	    ArrayList<String> arrListStr = new ArrayList<String>();
	    arrListStr.add("My Stock 1");
	    arrListStr.add("My Stock 2");
	    
	    super.loadData(arrListStr);
	    
	}

}
