package com.erbay.parkmatik.model;

import java.util.HashMap;

public enum VehicleType {
	CAR(0L,1,"Car"),
	JEEP(1L,2,"Jeep"),
	TRACK(2L,4,"Track");

	private static final HashMap<Long, VehicleType> byId = new HashMap<Long, VehicleType>();
	
	static {
        for (VehicleType e : VehicleType.values()) {
            if (byId.put(e.getId(), e) != null) {
                throw new IllegalArgumentException("duplicate id: " + e.getId());
            }
        }
    }
	public static VehicleType getById(Long id) {
        return byId.get(id);
    }
	
	private Long id;
	private int value;
	private String label;
	
	public int getValue() {
		return value;
	}


	public Long getId() {
		return this.id;
	}
	
	VehicleType(Long id, int value, String label) {
		this.id = id;
		this.value = value;
		this.label = label;
	}
	

}
