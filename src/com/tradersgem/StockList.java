package com.tradersgem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
	
	public void loadData(ArrayList<Stock> stockList)
	{
		this.stockList = stockList;
		ArrayList<String> arrList = new ArrayList<String>();
		
		for(Stock s: this.stockList)
			arrList.add(s.getName());
			
			
		ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
	    
	    listView = (ListView) findViewById(R.id.listOfStocks);
	    listView.setAdapter(arrAdapter);
	    
	    // Create OnClick Listener
	    listView.setOnItemClickListener(eventHandler);
	}
	
	AdapterView.OnItemClickListener eventHandler = new AdapterView.OnItemClickListener()
	{
		public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
		{
			Toast.makeText(getApplicationContext(),
					"Click ListItem Number " + stockList.get(position).getName(), Toast.LENGTH_LONG).show();
		}
	};
	
	private ListView listView;
	private ArrayList<Stock> stockList;
}
