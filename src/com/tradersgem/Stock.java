package com.tradersgem;

import java.io.Serializable;
import java.util.Date;

public class Stock  implements Serializable, Cloneable 
{
	public Stock(int id, String name, float price, Date date, int qty, boolean isOwned)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.purchaseDate = date;
		this.quantity = qty;
		this.isOwned = isOwned;
	}
	
	public int getId() { return id; }
	
	public String getName() { return name; }
	
	public float getPrice() { return price; }
	
	public Date getPurchaseDate() { return (Date)purchaseDate.clone(); }
	
	public int getQuantity() { return quantity; }
	
	public boolean getOwnedStatus() { return isOwned; }
	
	@Override
	public Object clone() 
	{ 
		try 
		{
			return (Object) super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private int id;
	private String name;
	private float price;
	private Date purchaseDate;
	private int quantity;
	private boolean isOwned;
	
	private static final long serialVersionUID = 1L;
}
