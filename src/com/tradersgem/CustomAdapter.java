package com.tradersgem;
import java.util.ArrayList;

import com.tradersgem.R;
import com.tradersgem.Stock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener 
 * @param <E>************/
public class CustomAdapter extends BaseAdapter implements OnClickListener
{
	/*********** Declare Used Variables *********/
	private Activity activity;
	private ArrayList<Stock> data;
	private static LayoutInflater inflater = null;
	public Resources res;
	Stock tempValues = null;
	int i=0;
	
	 /*************  CustomAdapter Constructor *****************/
	public CustomAdapter (Activity a, ArrayList<Stock> d, Resources resLocal)
	{
		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;
		
		/***********  Layout inflator to call external xml layout () ***********/
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/******** What is the size of Passed Arraylist Size ************/
	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		if(data.size() <= 0) return 0;
		return data.size();
	}

	@Override
	public Object getItem(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}
	
	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder
	{
		public TextView text;
		public TextView text1;
		//public TextView textWide;
		public TextView text2;
		public ImageView image;
	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View vi = convertView;
		ViewHolder holder;
		
		if(convertView == null)
		{
			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			vi = inflater.inflate(R.layout.stockitem, null);
			//vi = inflater.inflate(R.layout.tabitem, null);
			
			/****** View Holder Object to contain tabitem.xml file elements ******/
			holder = new ViewHolder();
			//holder.text = (TextView) vi.findViewById(R.id.text);
			//holder.text1 = (TextView) vi.findViewById(R.id.text1);
			//holder.image = (ImageView) vi.findViewById(R.id.image);
			
			holder.text = (TextView) vi.findViewById(R.id.SI_text);
			holder.text1 = (TextView) vi.findViewById(R.id.SI_text1);
			holder.text2 = (TextView) vi.findViewById(R.id.SI_text2);
			
			/************  Set holder with LayoutInflater ************/
			vi.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) vi.getTag();
		}
		
		if(data.size() <= 0)
		{
			holder.text.setText("No Data");
		}
		else
		{
			/***** Get each Model object from Arraylist ********/
			tempValues = null;
			tempValues = (Stock) data.get(position);
			
			/************  Set Model values in Holder elements ***********/
			holder.text.setText(tempValues.getName());
			holder.text1.setText("+");
			//holder.image.setImageResource(res.getIdentifier("com.androidexample.customlistview:drawable/ic_launcher.png", null, null));
			holder.text2.setText("(0.10 %)");
						
			/******** Set Item Click Listner for LayoutInflater for each row *******/
			vi.setOnClickListener(new OnItemClickListener(position));			
		}
		
		// TODO Auto-generated method stub
		return vi;
	}

	@Override
	public void onClick(View arg0) 
	{
		// TODO Auto-generated method stub
		Log.v("CustomAdapter", "=====Row button clicked");		
	}
	
	private class OnItemClickListener implements OnClickListener
	{
		private int mPosition;
		
		OnItemClickListener(int position)
		{
			mPosition = position;
		}

		@Override
		public void onClick(View v) 
		{
			StockList stockList = (StockList) activity;
			
			/****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
			stockList.onItemClick(mPosition);			
		}
		
	}

}
