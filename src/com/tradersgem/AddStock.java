package com.tradersgem;

import java.util.zip.Inflater;

import com.tradersgem.R.id;

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
			String superName=super.getLocalClassName();
			Log.d("SuperName",superName);
			LayoutInflater layout= getLayoutInflater();
			Log.d("layout inflater class", layout.getClass().toString());
			
			
			TableRow row= new TableRow(this);
			row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			TextView s= new TextView(this);
			s.setText(symbol);
			
			TextView f= new TextView (this);
			f.setText("60.00");
			
			TextView symR= new TextView(this);
			symR.setText("70.00");
			
			
			row.addView(s);
			row.addView(f);
			row.addView(symR);
			boolean checkRow= false;
			if (row==null)
				checkRow=true;
			Log.d("checkRow", ""+ row.getChildCount());
			//((ViewGroup)watchList).addView(row);
			
			Intent i= new Intent (this, ListView.class);
			
			startActivity(i);
			
			
			break;
		
		}
		
	}
}
