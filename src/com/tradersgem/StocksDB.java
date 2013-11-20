package com.tradersgem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import android.content.Context;

public class StocksDB implements Iterable<Stock>
{
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
	
	public boolean addNewStock(Stock stock)
	{
		listOfStocks.add(stock);
		
		// Update Stocks Database
		saveStocks();		
		
		return true;
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
	
	private ArrayList<Stock> listOfStocks;
	private Context context;
	final private String fileName;
	
}
