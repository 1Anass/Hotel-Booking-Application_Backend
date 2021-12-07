package ma.hotelbookingapp.monolithic.services;

import java.sql.Date;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;

import ma.hotelbookingapp.monolithic.data.dtos.StayPlan;
import ma.hotelbookingapp.monolithic.data.entities.Room;
import ma.hotelbookingapp.monolithic.data.repositories.RoomRepository;


import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class StayPlanService {

    @Autowired 
    private RoomRepository roomRepository;

    //@Cacheable(value = "StayPlan")
    public StayPlan getStayPlan(long userId){
        return new StayPlan();
    }

    public StayPlan addRoom(StayPlan stayPlan, long userId, long roomId, Date startDate, Date endDate){
        Room room = roomRepository.findById(roomId);
        stayPlan.addRoom(room, startDate, endDate);
        return stayPlan;
    }

    public StayPlan removeRoom(StayPlan stayPlan, long userId, long roomId){
        Room room = roomRepository.findById(roomId);
        stayPlan.removeRoom(room);
        return stayPlan;
    }

    public StayPlan empty(StayPlan stayPlan, long userId){
        stayPlan.empty();
        return stayPlan;
    }


    
    
}
