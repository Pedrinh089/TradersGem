package com.tradersgem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Home extends Activity 
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.activity_homescreen);
	    
	    if(getIntent().getExtras() != null)
	    {
	    	curUserAccount = (UserAccount) getIntent().getSerializableExtra("UserAccount");
	    	Log.d("Current User: ", curUserAccount.getUserName());
	    }
	    
	    // Connect Buttons to action listener
	    btMyStocks = (Button) findViewById(R.id.btMyStocks);
	    btWatchList = (Button) findViewById(R.id.btWatchStocks);
	    btSellStocks = (Button) findViewById(R.id.btSellStocks);
	    btStatistics = (Button) findViewById(R.id.btStatistics);
	    
	    btMyStocks.setOnClickListener(eventHandler);
	    btWatchList.setOnClickListener(eventHandler);
	    btSellStocks.setOnClickListener(eventHandler);
	    btStatistics.setOnClickListener(eventHandler);
	}
	
	/**
	 * 
	 */
	View.OnClickListener eventHandler = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(((Button)v).getId() == btMyStocks.getId())
			{
				//Intent intent = new Intent(Home.this, StockList.class).putExtra("String", "MyStocks");
				Intent intent = new Intent(Home.this, OwnedStockList.class).putExtra("String", curUserAccount.getUserName());
				//Intent intent = new Intent(Home.this, CustomListViewAndroidExample.class).putExtra("String", curUserAccount.getUserName());
				startActivity(intent);
			}
			else if(((Button)v).getId() == btWatchList.getId())
			{
				Intent intent = new Intent(Home.this, WatchedStockList.class).putExtra("String", curUserAccount.getUserName());
				startActivity(intent);
			}
			else if(((Button)v).getId() == btSellStocks.getId())
			{
				
			}
			else if(((Button)v).getId() == btStatistics.getId())
			{
				
			}
		}
	};
	
	private UserAccount curUserAccount;
	
	// User Interface Variables
	private Button btMyStocks;
	private Button btWatchList;
	private Button btSellStocks;
	private Button btStatistics;
}
