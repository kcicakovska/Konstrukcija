package com.example.Repository;

 import com.example.Model.Soba;
 import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface SobaRepository extends CrudRepository<Soba,Integer> {

    Iterable<Soba> findByHotelByHotel_Ime(String ime);
}
