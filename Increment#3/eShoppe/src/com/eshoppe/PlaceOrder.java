/**
 * @author: Ramesh Kuthala
 * 27-Sep-2014
 */
package com.eshoppe;

import java.util.Calendar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlaceOrder extends Activity {

	private static final String TAG = "PlaceOrder";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_placeorder);
		
		TextView storeName = (TextView)findViewById(R.id.storename);
		storeName.setText(CartData.getInstance().getStoreName());

		TextView totalPrice = (TextView)findViewById(R.id.totalpricetext);
		totalPrice.setText("$"+CartData.getInstance().getTotalPrice());

		TextView date = (TextView) findViewById(R.id.date);
		date.setText(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
				+ "/" + Calendar.getInstance().get(Calendar.MONTH) + "/"
				+ Calendar.getInstance().get(Calendar.YEAR));
		
		TextView address = (TextView) findViewById(R.id.storeinfo);
		address.setText(CartData.getInstance().getStoreAddress());

		final EditText shipAddress = (EditText)findViewById(R.id.shippingaddress);
		Button checkout = (Button)findViewById(R.id.checkout);
		checkout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Start thankyou activity
				CartData.getInstance().setShippingAddress(shipAddress.getText().toString());
				Intent i = new Intent(getApplicationContext(), Payment.class);
				startActivity(i);
			}
		});
	}
}
