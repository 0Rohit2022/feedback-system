package com.microservice.hotelService.controllers;


import com.microservice.hotelService.entities.hotel;
import com.microservice.hotelService.service.hotelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class hotelcontroller {

    @Autowired
    private hotelservice hotelser;
    //Create api

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<hotel> createHotel(@RequestBody hotel hotels)
    {
        hotel hotelss = hotelser.createHotel(hotels);
        return new ResponseEntity<>(hotelss, HttpStatus.CREATED);
    }
    //Get single hotel api
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<hotel> gethotelById(@PathVariable String id)
    {
        hotel hotels = hotelser.getHotelById(id);
        return new ResponseEntity<>( hotels, HttpStatus.OK);
    }
    //Get all hotel api
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin') ")
    @GetMapping
    public ResponseEntity<List<hotel>> getAllHotel()
    {
        List<hotel> hotels = hotelser.getAllHotel();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
