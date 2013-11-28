package com.tradersgem.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.tradersgem.loginSystem.UserAccount;
import com.tradersgem.stock.Stock;

import android.content.Context;

/**
 * Model for the User's Stocks, this class is used to communicate with the DB to fetch information, manage user's stocks by providing the following
 * functionality. It allows the adding new stocks to the user's porfolio, searching for stocks, getting quantities of owned/watched stocks, and 
 * saving/loading stocks from the stock DB.
 * @author pedro + Luiz 
 *
 */
public class StocksDB implements Iterable<Stock>
{
	/**
	 * 
	 * @param context
	 * @param userName
	 */
	public StocksDB(Context context, String userName)
	{
		fileName = userName + ".dat";
		listOfStocks = new ArrayList<Stock>();
		this.context = context;
		loadStocks();		
	}
	
	public UserAccount getStockById(int id)
	{
		Iterator<Stock> iterator = this.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(stock.getId() == id)
				return (UserAccount)stock.clone();
		}
		
		return null;
	}
	
	public UserAccount getStockByName(String name)
	{
		Iterator<Stock> iterator = this.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(stock.getName().equals(name))
				return (UserAccount)stock.clone();
		}
		
		return null;
	}
	/**
	 * The following stock aggregates to the list of stock .
	 * @param stock
	 * @return
	 */
	public boolean addNewStock(Stock stock)
	{
		listOfStocks.add(stock);
		
		// Update Stocks Database
		saveStocks();		
		
		return true;
	}
	/**
	 * The following function removes the stock from the list of stocks, 
	 * which then takes it away from the database itself;
	 * @precondition is such that stock is not null and corresponds correctly to 
	 * its type;
	 * @param stock
	 * @return true, if stock has been removed successfully, false if not;
	 */
	public boolean removeStock( Stock stock)
	{
		
		int i=0;
		i=listOfStocks.size();
		
		while (i>0)
		{
			if (listOfStocks.get(i).equals(stock))
			{
				listOfStocks.remove(i);
				saveStocks();
				return true;
			}
			else 
			{
				i--;
			}
		}
		
		
		return false;
	}
	
	public int getQtyStocksOwned()
	{
		int count = 0;
		Iterator<Stock> iterator = this.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(stock.getOwnedStatus())
				count++;
		}
		
		return count;
	}
	
	public int getQtyStocksWatched()
	{
		int count = 0;
		Iterator<Stock> iterator = this.iterator();
		
		while(iterator.hasNext())
		{
			Stock stock = iterator.next();
			
			if(!stock.getOwnedStatus())
				count++;
		}
		
		return count;
	}
	
	public void refresh()
	{
		loadStocks();
	}
	
	private void saveStocks()
	{
		try
		{
			FileOutputStream out = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			ObjectOutputStream write = new ObjectOutputStream(out);
			write.writeObject(listOfStocks);
			write.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadStocks()
	{
		// Check if file exists, if it does not create it
		try
		{
			FileInputStream inp = context.openFileInput(fileName);				
			ObjectInputStream read = new ObjectInputStream(inp);
			listOfStocks = (ArrayList<Stock>)read.readObject();
			read.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Override
	public Iterator<Stock> iterator() 
	{
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(listOfStocks).iterator();
	}
	
	public ArrayList<Stock> getStocks()
	{
		return listOfStocks;
		
	}
	
	private ArrayList<Stock> listOfStocks;
	private Context context;
	final private String fileName;
	
}
