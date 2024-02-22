package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations;

import com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.annotations.beansingleton.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Annotations {

    // inject işlemi için mutlaka spring beanı olması gerekir.

    SchoolService managerService;

//    @Autowired
//    public Annotations(ManagerService managerService){
//        this.managerService = managerService;
//
//    }

//    public void test(){
//        managerService.getEmployeeValue();
//    }

    @Autowired
    public void setManagerService(SchoolService managerService) {
        this.managerService = managerService;
    }
}
