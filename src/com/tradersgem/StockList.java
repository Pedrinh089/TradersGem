package com.tradersgem;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public abstract class StockList extends Activity 
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_stocklist);
	    // TODO Auto-generated method stub
	}
	
	public void loadData(ArrayList<Stock> stockList)
	{
		listView = (ListView) findViewById(R.id.listOfStocks);
	    		
		//CustomAdapter adapter = new CustomAdapter(CustomListView, customListViewValuesArr, res);
		CustomAdapter adapter = new CustomAdapter(this, stockList, getResources());
		listView.setAdapter(adapter);	    
	}
	
	public void showClickedItem(Stock stock)
	{
		Toast.makeText(this, 
				""+stock.getName() + "\n"
				  +"Id:"+stock.getId() + "\n"
				  +"Price:"+stock.getPrice(), Toast.LENGTH_SHORT).show();
	}
	
	public abstract void onItemClick(int mPosition);
	
	private ListView listView;
}
