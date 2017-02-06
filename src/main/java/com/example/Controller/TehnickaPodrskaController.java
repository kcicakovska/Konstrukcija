package com.example.Controller;


import com.example.Model.OdgovorZaPomosh;
import com.example.Service.TehnickaPodrskaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TehnickaPodrskaController {

    @Autowired
    TehnickaPodrskaService tehnickaPodrskaService;

    @RequestMapping(value="/tehpod/{id}",method = RequestMethod.GET)
    public Iterable<OdgovorZaPomosh> findById(@PathVariable int id){
        System.out.println(id);
        return tehnickaPodrskaService.findId(id);
    }
    @RequestMapping(value="/tehpod/lista",method = RequestMethod.GET)
    public Iterable<OdgovorZaPomosh> findAll(){
        return tehnickaPodrskaService.findAll();
    }

    @RequestMapping(value="/tehpod/nov",method = RequestMethod.POST)
    public OdgovorZaPomosh save(@RequestBody OdgovorZaPomosh tmp){
        return tehnickaPodrskaService.save(tmp);
    }
}
