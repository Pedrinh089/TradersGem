package com.tradersgem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.os.Bundle;
import android.util.Log;

/**
 * This is the controller for the OwnedStockList for the current user. This class connects with the stock list view to display the UI to the user 
 * and it receives commands from the user such as a individual stock click from the super class StockList. This Controller receives the 
 * current user account information from the Home Controller. This class is a subclass of StockList which actually manage the StockList View receives
 * user interaction. StockList is general class to implement a general functionality to a list of stocks, this class specializes that list sends 
 * only information relevant to the Owned Stock List to the stock list controller. This class also implements the actions that occurs when the user
 * clicks on a stock. 
 * @author pedro
 *
 */
public class OwnedStockList extends StockList
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	    // Check that user account has been sent in from the home screen
	    if(getIntent().getExtras() != null)
	    {
	    	// The user account has been sent in, retrive it.
	    	String userName = getIntent().getStringExtra("String");
	    	
	    	// Load the stocks pertaining to the current user from the
	    	//  user's Stock Database
	    	stocksDB = new StocksDB(getBaseContext(), userName);
	    	
	    	// Add Sample Data
	    	//stocksDB.addNewStock(new Stock(1, "Masmio", 3.51f, new Date(), 10, true));
		    
	    	// From the list of the stocks that is in the current users Stock Database, retrive
	    	//  only the ones that the user ownes.
	    	ownedStockList = getOwnedStocks();
		    
	    	Log.d("Current User: ", userName);
	    	
	    	// Send the list of the current user's owned stocks to the generic stock list so that they can be displayed to the user.
	    	super.loadData(ownedStockList);
	    }
	    
	}
	
	/**
	 * Gets an iterator from the current user's stock database and searches through it to find only the stocks that
	 *  the current user owns.
	 * @return - A list of stocks that the current user owns.
	 * @precondition - The current user account has been passed into this controller and stocksDB != null
	 */
	public ArrayList<Stock> getOwnedStocks()
	{
		// Create a list to hold all the stocks the current user owns
		ArrayList<Stock> ownedStocks = new ArrayList<Stock>();
		
		// Get an iterator for the current user's owned list of stocks.
		Iterator<Stock> iterator = stocksDB.iterator();
		
		// Iterate through teach stock in the database
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			// If the stock if owned add it to the list of owned stocks
			if(stock.getOwnedStatus())
				ownedStocks.add(stock);
		}	
		
		// Return the list of the owned stocks
		return ownedStocks;
	}
	
	/**
	 * Handle the onClick event that occurred when the user click on a stock, this is an abstract method from the
	 *  StockList Controller.
	 */
	public void onItemClick(int mPosition)
	{
		Stock tempValues = (Stock) ownedStockList.get(mPosition);
		
		super.showClickedItem(tempValues);
	}
	
	// Variables used to keep track the current user's stock Database
	private StocksDB stocksDB;
	private ArrayList<Stock> ownedStockList;

}
