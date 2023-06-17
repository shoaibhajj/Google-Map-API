package com.example.SaveService.Repository;

import com.example.SaveService.Module.SaveRest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaveRepository extends CrudRepository<SaveRest,Integer> {

    @Override
    List<SaveRest> findAll();


   // public  List<SaveRest> findByCity(String Acity);


}
