package com.erbay.parkmatik.model;

import java.util.HashMap;

public class Store {
	private static HashMap<Integer,Object> store = new HashMap<Integer,Object>();
	
	public static HashMap<Integer,Object> getInstance(){
		if(store.isEmpty()) {
		  for(int i=0;i<10;i++) {
			store.put(i,null);
		  }	
		  return store;
		}else 
			return store;
		
	}

}
