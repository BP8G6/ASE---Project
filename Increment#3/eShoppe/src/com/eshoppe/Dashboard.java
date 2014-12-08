package com.eshoppe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		Button btnshoponline = (Button) findViewById(R.id.btnshoponline);
		Button btnfindstore = (Button) findViewById(R.id.btnfindstore);

		btnshoponline.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), FindAProduct.class);
				startActivity(i);
			}
		});

		btnfindstore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), SearchAStore.class);
				startActivity(i);
			}
		});
	}
}