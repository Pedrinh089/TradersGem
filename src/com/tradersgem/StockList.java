package com.tradersgem;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StockList extends Activity 
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_stocklist);
	    // TODO Auto-generated method stub
	}
	
	public void loadData(ArrayList<String> arrList)
	{
		ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
	    
	    listView = (ListView) findViewById(R.id.listOfStocks);
	    listView.setAdapter(arrAdapter);
	}
	
	private ListView listView;
}
