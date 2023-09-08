/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.powerplanning.EnergiPlanering.scheduledjobs;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author fredr
 */
@Component
public class ScheduleExternalHourlyPriceCollection {
    
    /*private static final Logger log = LoggerFactory.getLogger(ScheduleExternalHourlyPriceCollection.class);
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }*/
    
    @Scheduled(fixedRate=5000)
    public void execute() {
        System.out.println("Scheduled job is executed");
    }
}
