package com.erbay.parkmatik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erbay.parkmatik.model.Response;
import com.erbay.parkmatik.model.Ticket;
import com.erbay.parkmatik.model.Vehicle;
import com.erbay.parkmatik.service.ReservationService;

@RestController
public class ParkmatikController {
	
	@Autowired
	ReservationService rservationService;
	
	@RequestMapping(value = "/getTicket", method = RequestMethod.POST)
	public Response reservationAndGetTicket(@RequestBody Vehicle vehicle) {
		Response response = new Response();
		try {
			Ticket ticket = rservationService.reservePlace(vehicle);
		    if(ticket != null) {
		      response.setData(ticket);
		      response.setMessage("Allocated "+ ticket.getReserveSlotNumbers() +" slots.");
		      }
		    else response.setMessage("Garage is full.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setMessage(e.getMessage());
		}
		
	return response;
	}
	
	@RequestMapping(value = "/leave/{uuid}", method = RequestMethod.POST)
	public Response leave(@PathVariable String uuid) {
		Response response = new Response();
		try {
			String message = rservationService.leave(uuid);
			response.setMessage(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.setMessage(e.getMessage());
		}
		return response;
		
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public Response status() {
		Response response = new Response();
		response.setData(rservationService.getStore());
		response.setMessage("Status");
		return response;
	}

}
