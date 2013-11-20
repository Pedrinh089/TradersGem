package com.tradersgem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import android.content.Context;

/**
 * Model for the User Accounts, this class is used to communicate with the DB to fetch information, and to check account credentials accuracy
 * @author Pedro Miranda
 *
 */
public class UserAccounts implements Iterable<UserAccount>
{
	public UserAccounts(Context context)
	{
		listOfUserAccounts = new ArrayList<UserAccount>();
		this.context = context;
		curUser = null;
		loadAccounts();		
	}
	
	public boolean verifyCredentials(String userName, String password)
	{
		Iterator<UserAccount> iterator = this.iterator();
		UserAccount account;
		
		while(iterator.hasNext())
		{
			account = iterator.next();
			
			if(account.getUserName().equals(userName) && account.getPasword().equals(password))
			{
				curUser = account;
				return true;
			}
		}
		
		return false;
	}
	
	public UserAccount getCurrentUser()
	{
		return (UserAccount)curUser.clone();
	}
	
	public boolean createNewAccount(String userName, String password, String confPassword) throws UserAccountsExc
	{
		// Ensure All Fields are filled
		if(userName.equals("") || password.equals("") || confPassword.equals("")) 
			throw new UserAccountsExc("Blank Field!");
		// Ensure password & confirm password match
		else if(!password.equals(confPassword)) 
			throw new UserAccountsExc("Passwords Do Not Match!");
		
		// Make sure username does not already exist
		Iterator<UserAccount> iterator = this.iterator();
		UserAccount account;
		
		while(iterator.hasNext())
		{
			account = iterator.next();
			
			if(account.getUserName().equals(userName))
			{
				throw new UserAccountsExc("User Names Equal Each Other!");
			}	
		}
		
		// New user account is valid add to the list
		curUser = new UserAccount(userName, password);
		listOfUserAccounts.add(curUser);
		
		// Update Account Database
		saveAccounts();		
		
		return true;
	}
	
	public int getNumOfAccounts()
	{
		return listOfUserAccounts.size();
	}
	
	public void refresh()
	{
		loadAccounts();
	}
	
	private void saveAccounts()
	{
		try
		{
			//ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("UserAccounts.dat", Context.MODE_PRIVATE));
			//ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("UserAccounts.dat", Context.MODE_PRIVATE));
			//write.writeObject(listOfUserAccounts);
			//write.close();
			
			FileOutputStream out = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			ObjectOutputStream write = new ObjectOutputStream(out);
			write.writeObject(listOfUserAccounts);
			write.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void loadAccounts()
	{
		// Check if file exists, if it does not create it
		try
		{
			FileInputStream inp = context.openFileInput(fileName);				
			ObjectInputStream read = new ObjectInputStream(inp);
			listOfUserAccounts = (ArrayList<UserAccount>)read.readObject();
			//UserAccount[] userAccountArr = (UserAccount[]) read.readObject();
			
			//for(int i=0; i<userAccountArr.length; i++) listOfUserAccounts.add(userAccountArr[i]);
			
			read.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Override
	public Iterator<UserAccount> iterator() 
	{
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(listOfUserAccounts).iterator();
	}
	
	private ArrayList<UserAccount> listOfUserAccounts;
	private Context context;
	private UserAccount curUser;
	final private String fileName = "UserAccounts.dat";
}
