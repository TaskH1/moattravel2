package com.example.moattravel2.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel2.entity.House;
import com.example.moattravel2.entity.User;
import com.example.moattravel2.entity.Reservation;
import com.example.moattravel2.form.ReservationRegisterForm;
import com.example.moattravel2.repository.HouseRepository;
import com.example.moattravel2.repository.ReservationRepository;
import com.example.moattravel2.repository.UserRepository;



@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	
	
	public ReservationService(
			ReservationRepository reservationRepository, 
			HouseRepository houseRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void create(Map<String, String> paymentIntentObject) {
		Reservation reservation = new Reservation();
		
		Integer houseId = Integer.valueOf(paymentIntentObject.get("houseId"));
		Integer userId = Integer.valueOf(paymentIntentObject.get("userId"));
		House house = houseRepository.getReferenceById(houseId);
		User user = userRepository.getReferenceById(userId);
		LocalDate checkinDate = LocalDate.parse(paymentIntentObject.get("checkinDate"));
		LocalDate checkoutDate = LocalDate.parse(paymentIntentObject.get("checkoutDate"));
		Integer numberOfPeople = Integer.valueOf(paymentIntentObject.get("numberOfPeople"));
		Integer amount = Integer.valueOf(paymentIntentObject.get("amount"));
	
		
		reservation.setHouse(house);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(numberOfPeople);
		reservation.setAmount(amount);
		
		reservationRepository.save(reservation);
		
	}
			
	//check if numberOfPeople is less than or equal capacity
	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
	// Calculate price
	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate,  checkoutDate);
		int amount = price * (int)numberOfNights;
		return amount;
	}

}