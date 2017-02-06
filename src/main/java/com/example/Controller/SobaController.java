package com.example.Controller;


import com.example.Model.Soba;
import com.example.Service.SobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SobaController {

    @Autowired
    SobaService sobaService;

    @RequestMapping(value="/rooms/{ime}",method = RequestMethod.GET)
    public Iterable<Soba> findByHotel(@PathVariable String ime){
        return sobaService.findSobi(ime);
    }
}
