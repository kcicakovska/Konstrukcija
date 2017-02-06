package com.example.Repository;

import com.example.Model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel,Integer>{

    Hotel findByIme(String Ime);
    Iterable<Hotel> findAll();
}
