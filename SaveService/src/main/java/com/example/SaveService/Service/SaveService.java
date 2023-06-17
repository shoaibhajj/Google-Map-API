package com.example.SaveService.Service;

import com.example.SaveService.Module.SaveRest;
import com.example.SaveService.Repository.SaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveService {

    private SaveRest Saveresturant;
    @Autowired
    SaveRepository saveRepository;
/*
    public List<SaveRest> findbycity(String city) {


        return saveRepository.findByCity(city);
    }
  */
    public List<SaveRest> findall() {
        return saveRepository.findAll();
    }

    public SaveRest findbyid(int id){
        return saveRepository.findById(id).get();
    }

    public void delete(int id){
        saveRepository.deleteById(id);
    }

    public SaveRest addResturant(SaveRest saveRest){

        return saveRepository.save(saveRest);
    }

    public SaveRest updateResturant(SaveRest saveRest, int id){
        Saveresturant=findbyid(id);


        return saveRepository.save(saveRest);
    }



}
