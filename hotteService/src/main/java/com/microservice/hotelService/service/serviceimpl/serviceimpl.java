package com.microservice.hotelService.service.serviceimpl;

import com.microservice.hotelService.entities.hotel;
import com.microservice.hotelService.exception.ResourceNotFoundException;
import com.microservice.hotelService.repository.hotelrepositories;
import com.microservice.hotelService.service.hotelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class serviceimpl implements hotelservice {

    @Autowired
    private hotelrepositories hotelrepo;
    @Override
    public hotel createHotel(hotel hotels) {
        String randomHotelId = UUID.randomUUID().toString();
        hotels.setId(randomHotelId);
       return hotelrepo.save(hotels);
    }

    @Override
    public List<hotel> getAllHotel() {
        return hotelrepo.findAll();
    }

    @Override
    public hotel getHotelById(String id) {
       return hotelrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found with id: "+id));
    }
}
