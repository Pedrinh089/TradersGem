package com.tradersgem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class ListView extends Activity
{
	
	public ListView()
	{
		
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
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        
        
    }


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
    		Intent ii= new Intent(this,AddStock.class);
    		
    		startActivity ( ii);
    		break;
    		
    	case R.id.graphMenuItem:
    		Intent iii= new Intent(this, TGGraphView.class );
    		
    		startActivity (iii);
    		break;
    		
    	}
    	
    	return true;
    }
    
    
    

}
