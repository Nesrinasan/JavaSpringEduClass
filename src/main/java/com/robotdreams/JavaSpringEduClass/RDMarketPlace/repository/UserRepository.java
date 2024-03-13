package com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
