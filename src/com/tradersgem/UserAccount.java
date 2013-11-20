package com.tradersgem;

import java.io.Serializable;

public class UserAccount implements Serializable, Cloneable
{
	public UserAccount(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPasword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password; 
	}
	
	public Object clone()
	{
		try 
		{
			return super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private String userName;
	private String password;

}
