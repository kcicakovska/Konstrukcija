package com.example.Controller;

import com.example.Model.Hotel;
import com.example.Model.Rezervacija;
import com.example.Model.Soba;
import com.example.Service.RezervacijaService;
import com.example.Service.SobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @Autowired
    SobaService sobaService;

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

    public Iterable<Rezervacija> findByDate(@PathVariable(name="datumOd")Date datumOd, @PathVariable(name="datumDo")Date datumDo ){
        return rezervacijaService.findByDate(datumOd,datumDo);
    }

    @RequestMapping(value="/rezervacii/{datumOd}/{datumDo}",method = RequestMethod.GET)
    public List<Hotel> primer(@PathVariable(name="datumOd")Date datumOd, @PathVariable(name="datumDo")Date datumDo){
        List<Rezervacija> ab = (List<Rezervacija>) rezervacijaService.findByDate(datumOd,datumDo);
        List<Soba> sobi = (List<Soba>) sobaService.findAll();
        System.out.println(ab.size()+" golemina na rezervacii "+sobi.size()+" golemina na sobi");
        List<String> result = new ArrayList();
        List<Hotel> result1 = new ArrayList();
        if(ab.size()>0) {
            for (int i = 0; i < ab.size(); i++) {
                for (int j = 0; j < sobi.size(); j++) {
                    if (ab.get(i).getSobaByIdSoba().getId() != sobi.get(j).getId() && !result.contains(sobi.get(j).getHotelByHotel().getIme())) {
                        result.add(sobi.get(j).getHotelByHotel().getIme());
                        result1.add(sobi.get(j).getHotelByHotel());
                    }
                }
            }
        }else{
            for(int k = 0; k < sobi.size(); k++){
                if(!result.contains(sobi.get(k).getHotelByHotel().getIme())){
                    result.add(sobi.get(k).getHotelByHotel().getIme());
                    result1.add(sobi.get(k).getHotelByHotel());
                }
            }
        }
        System.out.println(result1.size()+" GOLEMINAAAAAAAAAAAAAAAAAAAA");
        return result1;
    }



    // This one is for converting String do Dates, as spring.io doc says link http://docs.spring.io/spring/docs/3.1.x/spring-framework-reference/htmlsingle/spring-framework-reference.html#mvc-ann-webdatabinder
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
