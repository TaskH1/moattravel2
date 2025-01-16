package com.example.moattravel2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel2.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	

}
