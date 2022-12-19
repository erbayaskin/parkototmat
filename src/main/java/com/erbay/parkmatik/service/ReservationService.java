package com.erbay.parkmatik.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erbay.parkmatik.model.Store;
import com.erbay.parkmatik.model.Ticket;
import com.erbay.parkmatik.model.Vehicle;
import com.erbay.parkmatik.model.VehicleType;

@Service
public class ReservationService {
	
	Logger logger = LoggerFactory.getLogger(ReservationService.class);
	
	@Autowired
	ValidationService validationService;

	public Ticket reservePlace(Vehicle vehicle) {
	  synchronized(this) {
			Ticket ticket = new Ticket();
		HashMap<Integer,Object> store = Store.getInstance();
		VehicleType vehicleType = VehicleType.getById(vehicle.getVehicleTypeId());
		Integer startPoint = validationService.validate(store,vehicleType );
		if(startPoint!=null) {
			ticket.setSlotStartNumber(startPoint);
			ticket.setVehicleType(vehicle.getVehicleTypeId());
			ticket.setDateOfEntrance(new Date());
			ticket.setVehicleName(vehicle.getVehicleName());
			String placeNumbers = "";
			for (int i=0;i<vehicleType.getValue();i++) {
				store.put(startPoint, ticket);
				placeNumbers += (placeNumbers == ""?"":"-")+String.valueOf(startPoint);
				startPoint++;
			}
			logger.info(vehicle.getVehicleName() + " vehicle is put at " +placeNumbers + " place number/numbers" );
			ticket.setReserveSlotNumbers(placeNumbers);
			return ticket;
		}
	  }
		
		
		return null;
	}

	public String leave(String uuid) {
		// TODO Auto-generated method stub
	  synchronized(this) {
		HashMap<Integer,Object> store = Store.getInstance();
		String placeNumbers = "";
		for (int i=0;i<10;i++) {
			if(store.get(i)!=null) {
				Ticket ticketInArray = (Ticket)store.get(i);
				if(Objects.equals(ticketInArray.getUuid(),uuid)) {
					store.put(i, null);
					placeNumbers += (placeNumbers == ""?"":"-")+String.valueOf(i);
					}
			}

		}
		String message = "";
		if(placeNumbers!="") {
			message = uuid +" ticket number with" + " vehicle is leave at " +placeNumbers + " place number/s";
			logger.info(message);
		    
		} else message = "Don't leave Vehicle by ticket number.";
		return message;
	  }	
	}

	public HashMap<Integer,Object> getStore() {
		// TODO Auto-generated method stub
		logger.info("Garage is checked.");
		return Store.getInstance();
	}
	
	

}
