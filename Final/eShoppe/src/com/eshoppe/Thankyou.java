package com.eshoppe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Thankyou extends Activity {

	private static final String TAG = "Thankyou";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thankyou);
		
		TextView thankyoumsg = (TextView) findViewById(R.id.thanksmsg);
		String conclusion = "Thank you for shopping with us.\n";
		conclusion += "Your order will be delivered to the following address:\n\n";
		conclusion += CartData.getInstance().getShippingAddress(); //getIntent().getStringExtra("shippingAddress");
		thankyoumsg.setText(conclusion);
	}
}
