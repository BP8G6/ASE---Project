/**
 * @author: Ramesh Kuthala
 * 28-Sep-2014
 */
package com.eshoppe;

import java.util.ArrayList;

import com.utilities.ItemDetails;

public class CartData {

	private static CartData instance;

	private String storeName = "";
	private String StoreAddress = "";
	private String shippingAddress = "";
	private double latitude = 0;
	private double longitude = 0;

	private ArrayList<ItemDetails> selectedItemList;
	
	private CartData()
	{
		selectedItemList = new ArrayList<ItemDetails>();
	}
	
	public static CartData getInstance()
	{
		if(instance == null)
			instance = new CartData();
		
		return instance;
	}

	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double lattitude) {
		this.latitude = lattitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getStoreAddress() {
		return StoreAddress;
	}
	
	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}

	public ArrayList<ItemDetails> getSelectedItemList() {
		return selectedItemList;
	}

	public void addSelectedItem(ItemDetails selectedItem) {
		selectedItemList.add(selectedItem);
	}

	public void removeSelectedItem(ItemDetails selectedItem)
	{
		selectedItemList.remove(selectedItem);
	}
	
	public double getTotalPrice()
	{
		double totalPrice = 0.0;
		
		for(int i = 0; i < selectedItemList.size(); i++)
			totalPrice += selectedItemList.get(i).getPricing();	
		
		return totalPrice;
	}
	public void clearCart()
	{
		selectedItemList.clear();
	}
	
	
}
