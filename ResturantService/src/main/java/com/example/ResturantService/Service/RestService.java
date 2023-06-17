package com.example.ResturantService.Service;

import com.example.ResturantService.Modul.Resturant;
import com.example.ResturantService.Repository.RestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService {

    @Autowired
    RestRepository restRepository;

    public List<Resturant> findbycity(String city) {


        return restRepository.findByCity(city);
    }
    public List<Resturant> findall() {
        return restRepository.findAll();
    }

    public Resturant findbyid(int id){
        return restRepository.findById(id).get();
    }

    public void delete(int id){
        restRepository.deleteById(id);
    }

    public Resturant addResturant(Resturant resturant){

        return restRepository.save(resturant);
    }

    public Resturant updateResturant(Resturant resturant, int id){
        resturant.setId(id);

        return restRepository.save(resturant);
    }





}
