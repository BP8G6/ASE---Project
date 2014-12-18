package com.utilities;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import com.eshoppe.Dashboard;
import com.eshoppe.SearchAStore;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class Registration extends AsyncTask<String, Void, Integer>{
	
	private Context contxt;
	String BASE_URL = "http://kc-sce-cs551.kc.umkc.edu/aspnet_client/Group4/Hackathon2/UserDetailsImpl.svc";
	String REGISTRATION_URL = BASE_URL + "/register";

	public Registration(Context c) {
		contxt = c;
	}
	
	@Override
	protected Integer doInBackground(String... params) {
		int status=404;
		String url = REGISTRATION_URL;
			try {
				status = getStatusForPostService(url,params);
			}
			catch ( Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		
		if(result == 200) {
			Toast.makeText(contxt, "Successfully Registered !!!", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setClass(contxt, Dashboard.class);
			contxt.startActivity(intent);
		}
		else
			Toast.makeText(contxt, "Registration Failed !", Toast.LENGTH_SHORT).show();
		
	}
	
	public int getStatusForPostService(String serviceurl, String[] params) throws Exception {
		
		URL url = new URL(serviceurl);
		HttpURLConnection  httpUrlConnection = (HttpURLConnection)url.openConnection();
		httpUrlConnection.setDoOutput(true);
		httpUrlConnection.setRequestProperty("Content-Type", "application/json");
		httpUrlConnection.setRequestMethod("POST");
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(httpUrlConnection.getOutputStream()));
 		JSONObject obj = new JSONObject();
		obj.put("fname", params[0]);
		obj.put("lname", params[1]);
		obj.put("phonenum", params[2]);
		obj.put("address", params[3]);
		obj.put("city", params[4]);
		obj.put("state", params[5]);
		obj.put("user_name", params[6]);
		obj.put("pwd", params[7]);
		out.write(obj.toString());
		out.close();
		return httpUrlConnection.getResponseCode();
	}
}
