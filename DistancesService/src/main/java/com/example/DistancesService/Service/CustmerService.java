package com.example.DistancesService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustmerService {


    public String GetDist(double currlat,double currlon, double lat, double lon){
        double Dist;
        //  System.out.println(lat +"  "+ lon);
        Dist=lat- currlat + lon - currlon;
        return "The Distance Betweeb U And this City is :"+Math.abs(Dist)+"  Km";
    }



}
