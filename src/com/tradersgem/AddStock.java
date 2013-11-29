package com.tradersgem;

import java.util.Date;
import java.util.zip.Inflater;

import com.tradersgem.R.id;
import com.tradersgem.lists.Portfolio;
import com.tradersgem.lists.WatchList;
import com.tradersgem.stock.Stock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Identity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
/**
 * This class controls adding another Stock to the current list. 
 * @author Luiz Medeiros
 * It is a small simple view, that takes in a symbol and then adds it to the watchList. 
 * The model considers this symbol and searches for the information online. It then populates the fields
 * with the retrieved information. 
 * 
 *
 */
public class AddStock extends Activity implements OnClickListener
{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_stock_view);
        userName= getIntent().getExtras().getString("userName");
        Log.d("username",userName);
        
        /**
         * Creating the button that controls the adding of the stock
         * Here we link the view with the Model, so work may be done on the View and vice versa. 
         */
         
        Button addButton= (Button) findViewById(R.id.addStock);
        addButton.setOnClickListener(this);
        
        
        
    }
	
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        
        return true;
    }
	
	/**
	 * Below are the Overrides and custom defined methods;
	 */
	
	
	@Override
	public void onClick( View v)
	{
		switch (v.getId())
		{
		case R.id.addStock: 
			/**
			 * Use the database to add stocks;
			 * Thus all stocks are added directly to the database.
			 * LisView then retrieves the stocks from the database. 
			 */
			EditText symbolToAdd= (EditText) findViewById(R.id.symbolToAdd);
			String symbol= "";
			symbol=symbolToAdd.getText().toString();
			Log.d("Symbol retrieved", symbol);
			
			EditText priceToAdd= (EditText) findViewById(R.id.priceToAdd);
			CheckBox ownCheckBox= (CheckBox) findViewById(R.id.ownCheck);
			EditText quantityText= (EditText) findViewById(R.id.quantity);
			
			
			Float price= Float.parseFloat(priceToAdd.getText().toString());
			boolean own= ownCheckBox.isChecked();
			int quantity= Integer.parseInt(quantityText.getText().toString());
			Date date= new Date();
			int id= (int) (Math.random()*100);
			Log.d("id",""+ id);
			Stock stock= new Stock( id,symbol,price,date,quantity,own);
			
			if (own)
			{
				Portfolio portfolio= new Portfolio(this, userName);
				portfolio.addStocks(stock);
			}
			else
			{
				WatchList watchList= new WatchList(this,userName);
				watchList.addStocks(stock);
			}
			
		    
			
			Intent i= new Intent (this, ListView.class).putExtra("userName", userName);
			Log.d("extras in Intent i", i.getExtras().getString("userName"));
			startActivity(i);
			
			
			break;
			
		
			
		
		}
		
	}
	
	
	private String userName;
	
}
