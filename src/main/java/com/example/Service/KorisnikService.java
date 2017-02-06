package com.example.Service;

import com.example.Model.Korisnik;
import com.example.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KorisnikService {

    @Autowired
    KorisnikRepository korisnikRepository;

    public Iterable<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public List<Korisnik> login(Korisnik tmp){
        return korisnikRepository.findByKorisnickoImeAndLozinka(tmp.getKorisnickoIme(),tmp.getLozinka());
    }
    public Korisnik save(Korisnik tmp){
        return korisnikRepository.save(tmp);
    }
    public Korisnik findBykorisnickoIme(String ime){
        return korisnikRepository.findByKorisnickoIme(ime);
    }
}
