package com.example.Controller;

import com.example.Model.Hotel;
import com.example.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping(value="/hotel/{ime}",method = RequestMethod.GET)
    public Hotel find(@PathVariable String ime){
        return hotelService.findHotel(ime);
    }

    @RequestMapping(value="/hotels",method = RequestMethod.GET)
    public Iterable<Hotel> findAll(){
        return hotelService.findAll();
    }


}
