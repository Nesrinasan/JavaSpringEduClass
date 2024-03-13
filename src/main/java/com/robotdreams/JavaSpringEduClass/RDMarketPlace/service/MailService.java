package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MailService {

    @Async
    public void sendMailUser(Order order, Users users) {

        ReplaceFunction replaceFunction = (template, name, orderNumber)  -> template.replace("NAME", name).replace("ORDERNUMBER", orderNumber);

        String orderNumber = order.getOrderNumber();
        String name = users.getName();
        String email = users.getEmail();

        if(StringUtils.hasText(orderNumber)){
            String mailBody = "sevgili NAME siparişini aldık. numarası: ORDERNUMBER . detaylar emailinize gelmiştir.";
            mailBody = replaceFunction.replace(mailBody, name, orderNumber);

        }
        System.out.println("sdfdf");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
