package com.example.Repository;

import com.example.Model.Korisnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik,Integer>{
    @Override
    Iterable<Korisnik> findAll();

    @Override
     Korisnik save(Korisnik korisnikEntity);

    List<Korisnik> findByKorisnickoImeAndLozinka(String ime, String lozinka);

    Korisnik findByKorisnickoIme(String ime);
}