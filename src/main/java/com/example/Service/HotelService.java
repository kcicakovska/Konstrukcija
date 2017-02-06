package com.example.Service;

import com.example.Model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel findHotel(String ime){
        return hotelRepository.findByIme(ime);
    }
    public Iterable<Hotel>findAll(){
        return hotelRepository.findAll();
    }
}
