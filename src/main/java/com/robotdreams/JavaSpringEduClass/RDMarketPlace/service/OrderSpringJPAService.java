package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.dto.OrderRequestDto;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Users;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling.*;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling.GeneralException;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderProductRepository;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.shipping.DHLShippingStrategy;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.shipping.FedExShippingStrategy;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.shipping.ShippingCostCalculator;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.shipping.UPSShippingStrategy;
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
        order.setUsers(users);

        productOrderService.saveORderProduct(productIdList, order);

        reportService.createOrderReport2(order.getId(), userId.toString());

        mailService.sendMailUser(order, users);

        getCargoOffer(order, users);

        System.out.println(order.getTotalAmount());
    }

    public void getCargoOffer(Order order, Users users) {
        Users users1 = new Users();
        users1.equals(users);
        System.out.println(users1);

        Optional<Order> repositorySpringJpById = orderRepositorySpringJp.findById(order.getId());

        Order orders = repositorySpringJpById.orElseThrow(GeneralException::new);

        List<OrderProduct> orderProductList = productOrderService.findAllByOrder(orders);

        int totalWeigth = 0;
        for (OrderProduct orderProduct : orderProductList) {
            Product product = orderProduct.getProduct();
            int weight = product.getWeight();
            totalWeigth += weight;

        }
        ShippingCostCalculator calculator = null;
        if (users.isPremium()) {
            calculator = new ShippingCostCalculator(new UPSShippingStrategy());
            System.out.println("UPS Shipping Cost: " + calculator.calculateCost(totalWeigth));
            order.setTotalAmount(calculator.calculateCost(totalWeigth));
            return;
        }

        if (totalWeigth > 200) {
            throw new BusinessException("ürün ağırlığı fazla. farklı bir kargo seçeneği ile ilerleyin");
        }

        calculate(order, totalWeigth);

    }

    private void calculate(Order order, int totalWeigth) {
        ShippingCostCalculator calculator;
        if(totalWeigth > 0 && totalWeigth <= 100){
            calculator = new ShippingCostCalculator(new FedExShippingStrategy());
            order.setTotalAmount(calculator.calculateCost(totalWeigth));

        }else if(totalWeigth > 100 && totalWeigth < 200){
            calculator = new ShippingCostCalculator(new DHLShippingStrategy());
            order.setTotalAmount(calculator.calculateCost(totalWeigth));

        }
    }

    public void deleteOrderByOrderNumberCascade(Long orderID) {
        Order order = orderRepositorySpringJp.findById(orderID).get();
        orderRepositorySpringJp.delete(order);

    }

    public String retunOorderByOrderId(Long orderId, Long userId) {
        //order ön işlemler

        try {
            Order order = orderRepositorySpringJp.findById(orderId).get();
            Optional<Users> userById = userService.findUserById(userId);
            getCargoOffer(order, userById.get());
        } catch (Exception e) {
            getDefaultCargo();
            return "Kargo iadesi için ücretsiz kargo kampanyasından faydalanamazsınız. minimum tutar geçerli değil ";

        }
        return "işleminiz başarılı";

    }

    private void getDefaultCargo() {

    }
}
