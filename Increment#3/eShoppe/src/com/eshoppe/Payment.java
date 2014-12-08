package com.eshoppe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends Activity {

	private Button submit;
	private TextView shipAddress, amount;
	private EditText accno, PType, expDate;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);

		submit = (Button) findViewById(R.id.btnpaysub);
		shipAddress = (TextView) findViewById(R.id.et_deliveryaddress);
		accno = (EditText) findViewById(R.id.et_accountno);
		expDate = (EditText) findViewById(R.id.et_expdate);
		amount = (TextView) findViewById(R.id.et_amount);
		
		System.out.println("++++++++ Setting ship address: " + CartData.getInstance().getShippingAddress());
		shipAddress.setText(CartData.getInstance().getShippingAddress());
		shipAddress.setClickable(false);
		
		System.out.println("++++++++ Setting total price: " + CartData.getInstance().getTotalPrice());
		amount.setText("$" + CartData.getInstance().getTotalPrice());
		amount.setClickable(false);

		submit.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (shipAddress.equals("") || accno.equals("") || expDate.equals("") || amount.equals("")) {

					Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();

				} else {
//					Toast.makeText(getApplicationContext(),
//							"Payment Success..! Please wait for 3 hours to process your request", Toast.LENGTH_LONG)
//							.show();
					
					Intent i = new Intent(getApplicationContext(), Thankyou.class);
					startActivity(i);

				}
			}
		});
	}
}