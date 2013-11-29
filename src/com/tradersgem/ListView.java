package com.tradersgem;

import com.tradersgem.lists.Portfolio;
import com.tradersgem.lists.WatchList;
import com.tradersgem.loginSystem.UserAccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class ListView extends Activity
{
	
	public ListView()
	{
		//portfolio= new Portfolio(this,);
	}
	
	public static int getLayout()
	{
		return R.layout.listview;
	}
	
	public static Activity getActivity()
	{
		Activity activity= getActivity();
		
		return activity;
		
	}
	
	
	
	public void setDataView()
	{
		portfolio= new Portfolio(this,userName);
        watchList= new WatchList(this,userName);
        portfolioView= new TableLayout(this);
        watchListView= new TableLayout(this);
        TextView [] info= new TextView[3];
        
        TableRow row= new TableRow(this);
        LinearLayout parent= (LinearLayout) findViewById(R.id.parent);
        portfolio.refresh();
        watchList.refresh();
        
        int i=0,j=0;
        while(i<portfolio.size())
        {
        	if (i>0)
        	{
        		// this is a check so to renew the components if the first stock has
        		// already been added to the parent layout view;
        		row= new TableRow(this);
        		info=new TextView[3];
        	}
        	j=0;
        	info[j].setText(""+portfolio.getStocks().get(i).getName());
        	info[j+1].setText(""+portfolio.getStocks().get(i).getPrice());
        	info[j+2].setText(""+portfolio.getStocks().get(i).getPrice());
        	while (j<3)
        	{
        		row.addView(info[j]);
        		j++; // going to the next spot in the array for text View;
        	}
        	portfolioView.addView(row);
        	i++; // going to the next stock in portfolio;
        }
        
        
        
        
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        bundle= savedInstanceState;
        userName=getIntent().getExtras().getString("userName");
        Log.d("Extras(userName)",""+ userName);
        
        
        
        
        
        
        
    }
	/*
	@Override
	protected void onResume()
	{
	
	}
	
	@Override
	protected void onRestart()
	{
		
	}
	
	@Override
	protected void onStart()
	{
		
	}*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.listview_menu, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected( MenuItem item) 
    {
    	switch (item.getItemId())
    	{
    	case R.id.addStockMenuItem:
    		Intent ii= new Intent(this,AddStock.class).putExtra("userName", userName);
    		
    		startActivity ( ii);
    		break;
    		
    	case R.id.graphMenuItem:
    		Intent iii= new Intent(this, TGGraphView.class );
    		
    		startActivity (iii);
    		break;
    		
    	}
    	
    	return true;
    }
    
    
    private Bundle bundle;
    private TableLayout portfolioView;
    private TableLayout watchListView;
    private String userName;
    private Portfolio portfolio;
    private WatchList watchList;

}
