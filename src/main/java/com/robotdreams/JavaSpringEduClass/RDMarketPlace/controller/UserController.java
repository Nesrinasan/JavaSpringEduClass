package com.robotdreams.JavaSpringEduClass.RDMarketPlace.controller;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.UserSaveRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void save(@RequestBody UserSaveRequestDto userSaveRequestDto){
        userService.save(userSaveRequestDto);
    }


}
