package com.tradersgem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Get user name/password DB
		userAccount = new UserAccounts();
		
		
		// Get panel buttons
		btLogin = (Button) findViewById(R.id.btLogin);
		btCancel = (Button) findViewById(R.id.btCancel);
		btNewAccount = (Button) findViewById(R.id.btNewUser);
		
		// Create Listeners for panel buttons
		btLogin.setOnClickListener(eventHandler);
		btCancel.setOnClickListener(eventHandler);
		btNewAccount.setOnClickListener(eventHandler);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	/**
	 * 
	 */
	View.OnClickListener eventHandler = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			if(((Button)v).getId() == btLogin.getId())
			{
				EditText usr = (EditText) findViewById(R.id.etUserName);
				EditText pass = (EditText) findViewById(R.id.etPassword);
				
				if(userAccount.verifyCredentials(usr.getText().toString(), pass.getText().toString()))
				{
					Log.d("Account Login", "Account Login Successful!!!");
					
					Intent intent = new Intent(Login.this, Home.class);
					startActivity(intent);
				}
				else
				{
					Log.d("Account Login", "Account Login Failed!!!");
				}
			}
			else if(((Button)v).getId() == btCancel.getId())
			{
				// Close Application
				finish();
				System.exit(0);
			}
			else if(((Button)v).getId() == btNewAccount.getId())
			{
				//Log.d("New User Account", "New User Account Button Clicked");
				Intent intent = new Intent(Login.this, NewUser.class);
				startActivity(intent);
				
			}
		}
	};
	
	// User Credentials Variables
	UserAccounts userAccount;
	
	// UI Variables
	private Button btLogin;
	private Button btCancel;
	private Button btNewAccount;

}
