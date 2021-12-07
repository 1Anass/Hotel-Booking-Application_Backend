package ma.hotelbookingapp.monolithic.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.hotelbookingapp.monolithic.data.dtos.Room;
import ma.hotelbookingapp.monolithic.data.dtos.StayPlan;
import ma.hotelbookingapp.monolithic.data.repositories.UserRepository;
import ma.hotelbookingapp.monolithic.services.StayPlanService;

@RestController
@RequestMapping("/rest/stayPlan")
public class StayPlanRestController {

    @Autowired
    private StayPlanService stayPlanService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/get")
    @Cacheable(value = "StayPlan")
    public StayPlan getStayPlan(@RequestHeader Authentication authentication){
        String username = authentication.getName();
        long userId = userRepository.findByUsername(username);
        return stayPlanService.getStayPlan(userId); 
    }

    @PatchMapping("/addRoom")
    @CachePut(value = "StayPlan", key = "#userId")
    public StayPlan addRoom(@RequestBody Room dto, @RequestParam Date startDate, @RequestParam Date endDate, @RequestHeader Authentication authentication){
        String username = authentication.getName();
        long userId = userRepository.findByUsername(username);
        StayPlan stayPlan = stayPlanService.getStayPlan(userId);
        return stayPlanService.addRoom(stayPlan, userId, dto.getId(), startDate, endDate);
    }

    @PatchMapping("/removeRoom")
    @CachePut(value = "StayPlan", key = "#userId")
    public StayPlan removeRoom(@RequestBody Room dto, @RequestHeader Authentication authentication){
        String username = authentication.getName();
        long userId = userRepository.findByUsername(username);
        StayPlan stayPlan = stayPlanService.getStayPlan(userId);
        
        return stayPlanService.removeRoom(stayPlan, userId, dto.getId());
    }
    
    @CachePut(value = "StayPlan", key = "#userId")
    public StayPlan empty(StayPlan stayPlan, long userId) {
        stayPlan.empty();
        return stayPlan;
    }
}
