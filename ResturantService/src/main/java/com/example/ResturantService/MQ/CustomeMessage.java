package com.example.ResturantService.MQ;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomeMessage {

    private String messageId;
    private Date  messageDate;
    private int id;
    private String rest1;
    private String rest2;
    private String rest3;



}
