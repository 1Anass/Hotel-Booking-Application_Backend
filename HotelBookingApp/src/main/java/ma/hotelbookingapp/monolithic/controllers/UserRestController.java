package ma.hotelbookingapp.monolithic.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.hotelbookingapp.monolithic.data.dtos.User;
import ma.hotelbookingapp.monolithic.security.JWTHelper;
//import ma.hotelbookingapp.monolithic.security.JwtHelper;
import ma.hotelbookingapp.monolithic.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody User dto) {        
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        return "{\"Token \" :\"" +JWTHelper.generateToken(authentication)+ "\"}";
    }

    @PostMapping("/admin")
    public boolean createAdmin(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createAdmin(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress());
        return true;
    }

    @PostMapping("/provider")
    public boolean createProvider(@RequestBody User dto){
        if(!check(dto))
            return false;

        userService.createProvider(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
        dto.getEmailAddress());
        return true;
    }

    @PostMapping("/")
    public boolean createUser(@RequestBody User dto) {
        if (!check(dto))
            return false;

        userService.createUser(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress());
        return true;
    }

    @PatchMapping("/{userId}")
    public User update(@PathVariable("userId") long userId, @RequestBody User dto) {
        if (userId < 1)
            throw new RuntimeException();

        userService.update(userId, dto.getPassword(), dto.getNewPassword(), dto.getFirstName(), dto.getLastName(),
                dto.getEmailAddress() );

        return new User(dto.getUsername(), null, dto.getFirstName(), dto.getLastName(), dto.getEmailAddress());
    }

    private boolean check(User dto) {
        return (dto.getUsername() != null && dto.getPassword() != null && dto.getFirstName() != null
                && dto.getLastName() != null && dto.getEmailAddress() != null );
    }
}