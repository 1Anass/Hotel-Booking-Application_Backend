package ma.hotelbookingapp.monolithic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.hotelbookingapp.monolithic.data.dtos.PriceSuggestion;
import ma.hotelbookingapp.monolithic.services.PriceSuggestionService;

@RestController
@RequestMapping("/rest/price")
public class PriceSuggestionRestController {
    
    @Autowired
    PriceSuggestionService priceSuggestionService;

    @GetMapping("/suggestion")
    public PriceSuggestion suggestRoomPrice(@RequestParam long roomId){
        return priceSuggestionService.suggestRoomPrice(roomId);
    }
}
