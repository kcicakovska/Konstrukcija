package com.example.Service;


import com.example.Model.Soba;
import com.example.Repository.SobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobaService {

    @Autowired
    SobaRepository sobaRepository;

    public Iterable<Soba> findSobi(String ime){
        return sobaRepository.findByHotelByHotel_Ime(ime);
    }
    public Iterable<Soba> findAll(){
        return sobaRepository.findAll();
    }
}
