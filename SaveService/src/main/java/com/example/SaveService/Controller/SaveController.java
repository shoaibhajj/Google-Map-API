package com.example.SaveService.Controller;
import com.example.SaveService.MQ.CustomeMessage;
import com.example.SaveService.MQ.MQConfig;
import com.example.SaveService.Module.SaveRest;
import com.example.SaveService.Service.SaveService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/save")
public class SaveController {
    @Value("${server.port}")
    int port;
    private SaveRest Saveresturant;
    @GetMapping("/test")
    public String test( ){

        return "Save Service UP  "+port;
    }

    @Autowired
    private SaveService saveService;

    @GetMapping(value={"","/"})
    public List<SaveRest> GetAllSaveRest(){
        return saveService.findall();
    }

    @GetMapping("/{id}")
    public SaveRest Getbyid(@PathVariable int id){
        return saveService.findbyid(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        saveService.delete(id);
    }

    @PostMapping(value={"","/"})
    public SaveRest addSaveRest(@RequestBody SaveRest saveRest){

        return saveService.addResturant(saveRest);
    }


    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomeMessage message){
        Saveresturant=Getbyid(message.getId());
        Saveresturant.setRest1(message.getRest1());
        Saveresturant.setRest2(message.getRest2());
        Saveresturant.setRest3(message.getRest3());
        saveService.updateResturant(Saveresturant,message.getId());
     //   return Saveresturant.getRest1()+Saveresturant.getRest1()+Saveresturant.getRest1();

      System.out.println(message);
    }

    @GetMapping(value={"","/save/{id}/{rest1}/{i}"})
    public SaveRest SaveResturant(@PathVariable int i,@PathVariable("rest1") String rest1, @PathVariable int id) {
        Saveresturant=Getbyid(id);
        if(i==1)
        Saveresturant.setRest1(rest1);
        else if(i==2)
            Saveresturant.setRest2(rest1);
        else Saveresturant.setRest3(rest1);

        return saveService.updateResturant(Saveresturant,id);
    }

}
