package com.example.Repository;

import com.example.Model.OdgovorZaPomosh;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TehnickaPodrskaRepository extends CrudRepository<OdgovorZaPomosh,Integer> {

    Iterable<OdgovorZaPomosh> findAllById(int i);
    Iterable<OdgovorZaPomosh>findAll();
    OdgovorZaPomosh save(OdgovorZaPomosh tmp);

}
