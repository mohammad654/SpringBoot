package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRepository reservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Customer> customers = new ArrayList<>();

		for( int n = 0; n < 150; n++){
			customers.add( new Customer(0, Util.getFakeFullName(), Util.getFakeAddress(), Util.getFakeAge()));
		}

		customerRepository.saveAll( customers);

		runTestSet01();



	}
	private void runTestSet01() {
		Room room;

		room = saveRoom( true, false, 2);
		room = saveRoom( false, true, 4);
		room.setCleaned(false);
		roomRepository.save(room);
		saveReservation( 1, room);

	}
	private void runTestSet() {
		Room room;

		saveRoom( true, false, 2);
		saveRoom( false, false, 2);
		saveRoom( true, true, 2);
		saveRoom( false, false, 2);
		saveRoom( true, false, 4);
		saveRoom( false, false, 4);
		saveRoom( true, true, 4);
		saveRoom( false, false, 4);

		room = saveRoom( true, true, 3);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( false, true, 1);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( false, false, 4);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		room = saveRoom( true, false, 3);
		saveReservation( 1, room);
		saveReservation( 7, room);
		saveReservation( 12, room);

		saveRoom( true, false, 3);
		saveRoom( false, false, 3);
		saveRoom( true, true, 3);
		saveRoom( false, true, 3);
	}

	private void saveReservation(int offset, Room room) {
		Reservation reservation = new Reservation();
		reservation.setStartDate( LocalDate.now().plus(Period.ofDays(offset)));
		reservation.setEndDate( LocalDate.now().plus(Period.ofDays(offset + 3)));
		reservation.setRoom( room);
		reservationRepository.save(reservation);
	}

	private Room saveRoom(boolean b, boolean b1, int i) {
		Room room = new Room(b, b1, i);
		roomRepository.save(room);
		return room;
	}


}
