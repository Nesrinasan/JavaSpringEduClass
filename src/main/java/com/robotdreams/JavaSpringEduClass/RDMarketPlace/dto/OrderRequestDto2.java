package com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto;

import java.util.List;

/**
 * immutable class:
 * @param productIdList
 * @param userId
 * @param orderDescription
 */
record OrderRequestDto2(List<Long> productIdList, Long userId, String orderDescription) {


}
