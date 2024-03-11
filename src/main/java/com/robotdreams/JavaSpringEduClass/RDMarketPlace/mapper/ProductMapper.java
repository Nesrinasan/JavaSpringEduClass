package com.robotdreams.JavaSpringEduClass.RDMarketPlace.mapper;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.ProductResponseByCategoryDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseByCategoryDto productToProductResponseDtoByCategory(Product product);

}
