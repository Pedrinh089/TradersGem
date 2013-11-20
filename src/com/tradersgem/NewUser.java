package com.tradersgem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewUser extends Activity 
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);	
	    setContentView(R.layout.activity_newuser);
	    
	    //userAccount = (UserAccounts) getIntent().getSerializableExtra("UserAccounts");
	    userAccount = new UserAccounts(getBaseContext());
	    
	    btCreate = (Button) findViewById(R.id.NU_BtCreate);
	    btCancel = (Button) findViewById(R.id.NU_BtCancel);
	    
	    btCreate.setOnClickListener(eventHandler);
	    btCancel.setOnClickListener(eventHandler);
	}
	
	View.OnClickListener eventHandler = new View.OnClickListener()
	{
		public void onClick(View v)
		{
			
			if(((Button)v).getId() == btCreate.getId())
			{
				EditText usr = (EditText) findViewById(R.id.NU_EtUserName);
				EditText pass = (EditText) findViewById(R.id.NU_EtPassword);
				EditText passConf = (EditText) findViewById(R.id.NU_EtConfPassword);
				
				try 
				{
					if(userAccount.createNewAccount(usr.getText().toString(), pass.getText().toString(), passConf.getText().toString()))
					{
						Log.d("New User", "Account Creation Successful!!!");
						Log.d("Num Of Accounts", String.valueOf(userAccount.getNumOfAccounts()));
						
						Intent intent = new Intent(NewUser.this, Home.class).putExtra("UserAccount", userAccount.getCurrentUser());
						startActivity(intent);
					}
					else
					{
						Log.d("New User", "Account Creation Failed!!!");
						Log.d("Information", "Account Creation Failed!!!");
					}
				} catch (UserAccountsExc e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.d("Create Clicked", usr.getText().toString() + "\n" + pass.getText().toString() + "\n" + passConf.getText().toString());
				
			}
			else if(((Button)v).getId() == btCancel.getId())
			{
				// Close Application
				Log.d("Num Of Accounts", String.valueOf(userAccount.getNumOfAccounts()));
				Log.d("Cancel Clicked", "Cancel Button Clicked");
				finish();		
				
			}
		}
	};
	
	private UserAccounts userAccount;	
	
	private Button btCreate;
	private Button btCancel;

}
