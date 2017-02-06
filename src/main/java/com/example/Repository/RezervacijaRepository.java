package com.example.Repository;

import com.example.Model.Rezervacija;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;


@Repository
public interface RezervacijaRepository extends CrudRepository<Rezervacija,Integer>{
    @Override
    Rezervacija save(Rezervacija tmp);
    Iterable<Rezervacija> findAll();
    Iterable<Rezervacija>findByDatumDoBetween(Date datumOd, Date datumDo);
}

