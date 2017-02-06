package com.example.Controller;

import com.example.Model.Rezervacija;
import com.example.Service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.text.SimpleDateFormat;


@RestController
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @RequestMapping(value="/rezerviraj",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rezervacija findByHotel(@RequestBody Rezervacija tmp){
        System.out.println(tmp.toString());
        return rezervacijaService.save(tmp);
    }
    @RequestMapping(value="/rezervacii",method = RequestMethod.GET)
    public Iterable<Rezervacija> findAll(){
        return  rezervacijaService.findAll();
    }
    // Getting all reservation with date between.
    @RequestMapping(value="/rezervacii/{datumOd}/{datumDo}",method = RequestMethod.GET)
    public Iterable<Rezervacija> findByDate(@PathVariable(name="datumOd")Date datumOd, @PathVariable(name="datumDo")Date datumDo ){
        return rezervacijaService.findByDate(datumOd,datumDo);
    }


    // This one is for converting String do Dates, as spring.io doc says link http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/htmlsingle/spring-framework-reference.html#mvc-ann-webdatabinder
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
