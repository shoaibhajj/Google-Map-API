package com.example.ResturantService.Repository;

import com.example.ResturantService.Modul.Resturant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestRepository extends CrudRepository<Resturant,Integer> {



    @Override
    List<Resturant> findAll();


    public  List<Resturant> findByCity(String Acity);


}
