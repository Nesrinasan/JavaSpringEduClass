package com.robotdreams.JavaSpringEduClass.RDMarketPlace.mapper;


import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderInfoResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderInfoResponseDto>{

    @Override
    public OrderInfoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderInfoResponseDto orderInfoResponseDto = new OrderInfoResponseDto();
        orderInfoResponseDto.setOrderNumber(rs.getString("ORDER_NUMBER"));
        orderInfoResponseDto.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));

        return orderInfoResponseDto;
    }
}
