package com.eshoppe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity {

	
	private EditText  username=null;
	private EditText  password=null;
	private Button login=null;
	private Button signup=null;
	private Button guestUser=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		getActionBar().setTitle("     Login");
		username = (EditText)findViewById(R.id.username_et);
		password = (EditText)findViewById(R.id.password_et);

		guestUser = (Button)findViewById(R.id.button1);
	    signup = (Button)findViewById(R.id.button2);
	    login = (Button)findViewById(R.id.button3);
	
	    guestUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						Welcome.class);
				startActivity(i);
				finish();
			}
		});
	    
	    signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						Registration.class);
				startActivity(i);
			}
		});
	    login.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	        
	        	//Checking credentials
	        	if(username.getText().toString().equals("admin") && 
	      		      password.getText().toString().equals("admin")){
	      		      Toast.makeText(getApplicationContext(), "Redirecting...", 
	      		      Toast.LENGTH_SHORT).show();
	      		    Intent i = new Intent(getApplicationContext(),
							Welcome.class);
					startActivity(i);
					finish();
	      		   }	
	      		   else{
	      		      Toast.makeText(getApplicationContext(), "Wrong Credentials",
	      		      Toast.LENGTH_SHORT).show();
	      		   }
	        	
	        }
	    });
	}
    
	
}
