package com.example.DistancesService.Controller;


import com.example.DistancesService.Service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/distance")
public class Controller {
    private String city;
    @Value("${server.port}")
    int port;
    @GetMapping("/test")
    public String test(){

        return "Distances Service UP   "+port;
    }
    @Autowired
    private CustmerService custmerService;
    @Autowired
    RestTemplate rest;

    @GetMapping("/{currlat}/{currlon}/{lat}/{lon}")
        public String GetDist(@PathVariable double currlat,@PathVariable double currlon,@PathVariable double lat,@PathVariable double lon){

        return  custmerService.GetDist(currlat,currlon,lat,lon);
    }
    @GetMapping("/get/{city}/{id}")
    public String Get(@PathVariable String city,@PathVariable int id){
        System.out.println(city);
        double countrylat=
                rest.getForObject("http://SearchService/search/lat/{city}",Double.class,city);
        System.out.println(countrylat);
        double countrylon=
                rest.getForObject("http://SearchService/search/lon/{city}",Double.class,city);
        System.out.println(countrylon);
        double currlat=
                rest.getForObject("http://SearchService/customers/lat/{id}",Double.class,id);
        System.out.println(currlat);
        double currlon=
                rest.getForObject("http://SearchService/customers/lon/{id}",Double.class,id);
        System.out.println(currlon);

        return  custmerService.GetDist(currlat,currlon,countrylat,countrylon);
    }



}
