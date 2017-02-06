package com.example.Service;


import com.example.Model.OdgovorZaPomosh;
import com.example.Repository.TehnickaPodrskaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TehnickaPodrskaService {

    @Autowired
    TehnickaPodrskaRepository tehnickaPodrskaRepository;

    public Iterable<OdgovorZaPomosh> findId(int id){
        return tehnickaPodrskaRepository.findAllById(id);
    }
    public Iterable<OdgovorZaPomosh> findAll(){
        return tehnickaPodrskaRepository.findAll();
    }
    public OdgovorZaPomosh save(OdgovorZaPomosh tmp){
        return tehnickaPodrskaRepository.save(tmp);
    }
}
