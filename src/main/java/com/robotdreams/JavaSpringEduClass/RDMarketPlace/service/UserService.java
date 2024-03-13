package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.UserSaveRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.mapper.UserMapper;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public void save(UserSaveRequestDto userSaveRequestDto){
        Users users = userMapper.userSaveRequestDtoToUser(userSaveRequestDto);
        userRepository.save(users);

    }

    public Optional<Users> findUserById(Long id){
        return userRepository.findById(id);
    }

}
