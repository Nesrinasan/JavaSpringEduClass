package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations.beansingleton;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeService {

}
