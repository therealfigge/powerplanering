/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.powerplanning.EnergiPlanering.scheduledjobs;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author fredr
 */
@Component
public class ScheduleExternalHourlyPriceCollection {
    
    LocalDateTime currentDate = LocalDateTime.now();
    String day = String.valueOf(currentDate.getDayOfMonth());
    String month = String.valueOf(currentDate.getMonthValue());
    String year = String.valueOf(currentDate.getYear());
    String urlSe1 = "";
        
    /*
    Method: execute
    Description: The method reads api data that specifies hourly power prices
    in the areas in Sweden. 
    Todo: Currently it is a raw string that needs to be divided and then entered
    to a db with a Spring Boot post endpoint.
    */
    @Scheduled(fixedRate=5000)
    public void execute() throws IOException {
        if(day.length()==1) day = "0" + day;
        if(month.length()==1) month = "0" + month;
        
        urlSe1 = "https://www.elprisetjustnu.se/api/v1/prices/" + year + "/" + month + "-" + day + "_SE1.json";
        
        String json = IOUtils.toString(new URL(urlSe1), "UTF-8");
        
        System.out.println("JSON: " + json);
        
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day + ", Link SE1: " + urlSe1);
    }
}
















