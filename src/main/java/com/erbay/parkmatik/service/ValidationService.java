package com.erbay.parkmatik.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.erbay.parkmatik.model.VehicleType;

@Service
public class ValidationService {
	Integer validate(HashMap<Integer,Object> store,VehicleType vehicleType) {// valid :start point or not valid : null
		int count = 0; 
		Integer startPoint = null;
		for(int i=0;i<10;i++) {
			if(store.get(i)==null) {
				count++;
				if(count == 1) 
					startPoint = i;
				if(count == vehicleType.getValue())
					return startPoint;
			}else count = 0;
		}
		
		return null;
	}

}
