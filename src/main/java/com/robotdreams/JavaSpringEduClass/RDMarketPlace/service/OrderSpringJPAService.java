package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.*;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling.BusinessException;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling.GeneralException;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderSpringJPAService {

        private final OrderRepositorySpringJp orderRepositorySpringJp;

    private final UserService userService;

    private final MailService mailService;

    private final ReportService reportService;

    private final ProductOrderService productOrderService;

    public OrderSpringJPAService(OrderRepositorySpringJp orderRepositorySpringJp, ProductService productService, OrderProductRepository orderProductRepository, UserService userService, MailService mailService, ReportService reportService, ProductOrderService productOrderService) {
        this.orderRepositorySpringJp = orderRepositorySpringJp;
        this.userService = userService;
        this.mailService = mailService;
        this.reportService = reportService;
        this.productOrderService = productOrderService;
    }


    public void test() {

        try {
            FileReader fileReader = new FileReader("");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public void save(OrderRequestDto orderRequestDto) {

        List<Long> productIdList = orderRequestDto.getProductIdList();
        String orderDescription = orderRequestDto.getOrderDescription();
        Long userId = orderRequestDto.getUserId();

        Order order = new Order();
        order.setOrderDescription(orderDescription);
        order.setOrderNumber(UUID.randomUUID().toString());
        Optional<Users> userById = userService.findUserById(userId);
        Users users = userById.get();

        productOrderService.saveORderProduct(productIdList, order);

        reportService.createOrderReport2(order.getId(), userId.toString());

        mailService.sendMailUser(order, users);

        getCargoOffer(order.getId());

    }

    public void getCargoOffer(Long orderId) {

        Optional<Order> repositorySpringJpById = orderRepositorySpringJp.findById(orderId);

        Order order = repositorySpringJpById.orElseThrow(GeneralException::new);

        List<OrderProduct> orderProductList = productOrderService.findAllByOrder(order);
        Double totalPrice = 0.0;
        int totalWeigth = 0;
        for (OrderProduct orderProduct : orderProductList) {
            Product product = orderProduct.getProduct();
            Double price = product.getPrice();
            totalPrice += price;
            int weight = product.getWeight();
            totalWeigth += weight;

        }

        if(totalWeigth > 20){
            throw new BusinessException("ürün ağırlığı fazla. farklı bir kargo seçeneği ile ilerleyin");
        }

        if (totalPrice < 60) {
            throw new BusinessException("Ürün tutarınız 50 liranın altında");
        }


    }

    public void deleteOrderByOrderNumberCascade(Long orderID) {

        Order order = orderRepositorySpringJp.findById(orderID).get();
        orderRepositorySpringJp.delete(order);

    }

    public String retunOorderByOrderId(Long orderId) {
        //order ön işlemler

        try {
            getCargoOffer(orderId);
        } catch (Exception e) {
            getDefaultCargo();
            return "Kargo iadesi için ücretsiz kargo kampanyasından faydalanamazsınız. minimum tutar geçerli değil ";

        }
        return "işleminiz başarılı";

    }

    private void getDefaultCargo() {

    }
}
