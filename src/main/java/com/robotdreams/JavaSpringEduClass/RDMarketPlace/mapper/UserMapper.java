package com.robotdreams.JavaSpringEduClass.RDMarketPlace.mapper;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductResponseByCategoryDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.UserSaveRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userSaveRequestDtoToUser(UserSaveRequestDto userSaveRequestDto);

}
