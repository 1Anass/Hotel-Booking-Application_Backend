package ma.hotelbookingapp.monolithic.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.hotelbookingapp.monolithic.data.dtos.PriceSuggestion;
import ma.hotelbookingapp.monolithic.data.entities.Hotel;
import ma.hotelbookingapp.monolithic.data.entities.Room;
import ma.hotelbookingapp.monolithic.data.repositories.HotelRepository;
import ma.hotelbookingapp.monolithic.data.repositories.RoomRepository;

@Service
public class PriceSuggestionService {
    
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    public PriceSuggestion suggestRoomPrice(long roomId){
        //subject room
        Room room = roomRepository.findById(roomId);
        
        long hotelId = room.getHotel().getId();
        //hotel of subject room
        Hotel hotel = hotelRepository.findById(hotelId);

        //find similar hotels
        List<Long> similarHotels = hotelRepository.findSimilarHotels(hotel.getDistanceFromCenter(), hotel.getStarsRating());
        
        // find similar rooms
        List<Room> similarRooms = new LinkedList<Room>();

        for(Long idHotel : similarHotels){
            similarRooms.addAll(roomRepository.findRoomsOfHotel(idHotel));
        }

        float sum = 0;

        for(Room sampleRoom : similarRooms){
            sum += sampleRoom.getPrice(); 
        }

        float averagePrice = sum / similarRooms.size() ;

        return new PriceSuggestion(averagePrice, similarRooms.size());


    
        
        
    }
}
