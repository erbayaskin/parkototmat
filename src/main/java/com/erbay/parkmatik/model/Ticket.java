package com.erbay.parkmatik.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

public class Ticket {
	private String uuid;
	private String vehicleName;
	private Long vehicleType;
	private Integer slotStartNumber;
	private String reserveSlotNumbers;
	private Date dateOfEntrance;
	
	

	public Ticket() {
		super();
		 UUID uuid = UUID.randomUUID();
	       setUuid(uuid.toString());
		// TODO Auto-generated constructor stub
	}
	
	

	public String getReserveSlotNumbers() {
		return reserveSlotNumbers;
	}



	public void setReserveSlotNumbers(String reserveSlotNumbers) {
		this.reserveSlotNumbers = reserveSlotNumbers;
	}



	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getDateOfEntrance() {
		return dateOfEntrance;
	}
	public void setDateOfEntrance(Date dateOfEntrance) {
		this.dateOfEntrance = dateOfEntrance;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Long getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(Long vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Integer getSlotStartNumber() {
		return slotStartNumber;
	}
	public void setSlotStartNumber(Integer slotStartNumber) {
		this.slotStartNumber = slotStartNumber;
	}

	

}
