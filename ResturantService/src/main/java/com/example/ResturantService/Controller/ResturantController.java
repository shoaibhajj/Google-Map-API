package com.example.ResturantService.Controller;


import com.example.ResturantService.MQ.CustomeMessage;
import com.example.ResturantService.MQ.MQConfig;
import com.example.ResturantService.Modul.Resturant;
import com.example.ResturantService.Service.RestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/resturant")
public class ResturantController {

    private List<Resturant> resturant;
    private int ids;
    private String Rcity;
    @Value("${server.port}")
    int port;
    @GetMapping("/test")
    public String test( ){

        return "Resturant Service UP   "+port;
    }

    @Autowired
    private RestService restService;
    @Autowired
    RestTemplate rest;

    @GetMapping(value={"","/"})
    public List<Resturant> GetAllResturant(){
        return restService.findall();
    }

    @GetMapping("/{id}")
    public Resturant Getbyid(@PathVariable int id){
        return restService.findbyid(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        restService.delete(id);
    }

    @PostMapping(value={"","/"})
    public Resturant addResturant(@RequestBody Resturant resturant){

        return restService.addResturant(resturant);
    }

    @PutMapping(value={"","/{id}"})
    public Resturant updateResturant(@RequestBody Resturant resturant, @PathVariable int id) {

        return restService.updateResturant(resturant,id);
    }

    @GetMapping("/{id}/{city}")
    public String GetRest(@PathVariable int id, @PathVariable String city){
        ids=id;
        Rcity=city;
        resturant  =  restService.findbycity(city);
        return ""+resturant.get(0).getRest1() + "\n" + resturant.get(0).getRest2() + "\n" + resturant.get(0).getRest3();

    }
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessages(@RequestBody(required=false) CustomeMessage message){
    message.setMessageId(UUID.randomUUID().toString());
    message.setMessageDate(new Date());
    String rest1=resturant.get(0).getRest1()+","+Rcity;
    String rest2=resturant.get(0).getRest2()+","+Rcity;
    String rest3=resturant.get(0).getRest3()+","+Rcity;
    message.setId(ids);
    message.setRest1(rest1);
    message.setRest2(rest2);
    message.setRest3(rest3);
    template.convertAndSend(MQConfig.EXCHANGE,
            MQConfig.ROUTING_KEY,message);
    return "Message Published";
    }


}
