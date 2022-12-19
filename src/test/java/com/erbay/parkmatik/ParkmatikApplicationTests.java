package com.erbay.parkmatik;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.erbay.parkmatik.model.Ticket;
import com.erbay.parkmatik.model.Vehicle;
import com.erbay.parkmatik.service.ReservationService;

@SpringBootTest
class ParkmatikApplicationTests {
	@Autowired
	ReservationService reservationService;

	@Test
	void contextLoads() {
	}
	@Test
	void testreservationServiceTest() {
		Vehicle vehicleCar = new Vehicle();
		vehicleCar.setVehicleName("Car Toyota Corolla");
		vehicleCar.setVehicleTypeId(0L);
		
		Vehicle vehicleJeep = new Vehicle();
		vehicleJeep.setVehicleName("Jeep Toyota Rav4");
		vehicleJeep.setVehicleTypeId(1L);
		
		Vehicle vehicleTrack = new Vehicle();
		vehicleTrack.setVehicleName("Track Man");
		vehicleTrack.setVehicleTypeId(2L);

		Ticket ticketJeep = reservationService.reservePlace(vehicleJeep);
		Ticket ticketTrack = reservationService.reservePlace(vehicleTrack);
		Ticket ticketCar1 = reservationService.reservePlace(vehicleCar);
		Ticket ticketCar2 = reservationService.reservePlace(vehicleCar);
		Ticket ticketCar3 = reservationService.reservePlace(vehicleCar);
		Ticket ticketCar4 = reservationService.reservePlace(vehicleCar);
		Ticket ticketCar5 = reservationService.reservePlace(vehicleCar);
		assertThat(ticketCar5).isNull();
		
		reservationService.leave(ticketCar2.getUuid());
		
		Ticket ticketCar6 = reservationService.reservePlace(vehicleCar);
		assertThat(ticketCar6).isNotNull();
		
	}

}
