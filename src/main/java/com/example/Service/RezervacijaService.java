package com.example.Service;

import com.example.Model.Rezervacija;
import com.example.Repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;

@Service
public class RezervacijaService {

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    public Rezervacija save(Rezervacija tmp){
        return rezervacijaRepository.save(tmp);
    }
    public Iterable<Rezervacija> findAll(){
        return  rezervacijaRepository.findAll();
    }
    public Iterable<Rezervacija>findByDate(Date datumOd, Date datumDo){
        return rezervacijaRepository.findByDatumDoBetween(datumOd,datumDo);
    }
}
