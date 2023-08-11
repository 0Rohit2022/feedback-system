package com.microservice.hotelService.repository;

import com.microservice.hotelService.entities.hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface hotelrepositories extends JpaRepository<hotel, String> {
}
