package com.example.Controller;


import com.example.Model.Soba;
import com.example.Service.SobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SobaController {

    @Autowired
    SobaService sobaService;

    @RequestMapping(value="/rooms/{ime}",method = RequestMethod.GET)
    public Iterable<Soba> findByHotel(@PathVariable String ime){
        return sobaService.findSobi(ime);
    }

    @RequestMapping(value="/rooms/all",method = RequestMethod.GET)
    public Iterable<Soba> findAll(){
        return sobaService.findAll();
    }


}
