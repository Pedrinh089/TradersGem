package com.tradersgem;

/**
 * Model for the User Accounts, this class is used to communicate with the DB to fetch information, and to check account credentials accuracy
 * @author Pedro Miranda
 *
 */
public class UserAccounts
{
	public UserAccounts()
	{
		userName = "Test";
		password = "1234";
		
		credentials = new String[10][2];
		
		credentials[0][0] = "Test";
		credentials[0][1] = "1234";
		
		credentials[1][0] = "Test1";
		credentials[1][1] = "Test1";
		
		credentials[2][0] = "Test2";
		credentials[2][1] = "Test2";
		
		credentials[3][0] = "Test3";
		credentials[3][1] = "Test3";
		
		credentials[4][0] = "Test4";
		credentials[4][1] = "Test4";
		
	}
	
	public boolean verifyCredentials(String userName, String password)
	{
		for(int i = 0; i < 5; i++)
		{
			if(credentials[i][0].equals(userName) && credentials[i][1].equals(password))
			{
				this.userName = userName;
				this.password = password;
				
				return true;
			}
		}
		
		return false;
	}
	
	String userName;
	String password;
	
	String[][] credentials;
}
