package com.robotdreams.JavaSpringEduClass.week1.SecondDayThirdDay.SpringOverview.annotations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotation {

    //methodlar bean annotation ile işaretlenir. Classın da bir spring beanı olması gerekir.
//    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)


    /**
     * Field injection
     * This approach might look simpler and cleaner, but we don't recommend using it because it has a few drawbacks such as:
     *
     * This method uses reflection to inject the dependencies, which is costlier than constructor-based or setter-based injection.
     * It's really easy to keep adding multiple dependencies using this approach. If we were using constructor injection,
     * having multiple arguments would make us think that the class does more than one thing, which can violate the Single Responsibility Principle.
     * https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring#the-spring-ioc-container
     */
}
