package com.example.Controller;

import com.example.Model.Korisnik;
import com.example.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public Iterable<Korisnik> findAll(){
        System.out.println("Yes");
        return korisnikService.findAll();
    }
    @RequestMapping(value="/login",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Korisnik> login(@RequestBody Korisnik tmp){
        System.out.println(tmp.getKorisnickoIme()+" "+tmp.getLozinka());
        return korisnikService.login(tmp);
    }
    @RequestMapping(value="/register",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Korisnik save(@RequestBody Korisnik tmp){
        return korisnikService.save(tmp);
    }

    @RequestMapping(value="/user/{ime}",method=RequestMethod.GET)
    public Korisnik findBykorisnickoIme(@PathVariable(name="ime")String ime){
        return korisnikService.findBykorisnickoIme(ime);
    }

}
