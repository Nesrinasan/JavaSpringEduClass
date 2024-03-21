package com.robotdreams.JavaSpringEduClass.unittest;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Order;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.OrderProduct;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.exceptionHandling.BusinessException;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.OrderRepositorySpringJp;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.OrderSpringJPAService;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.service.ProductOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTests {


    @InjectMocks
    private OrderSpringJPAService orderSpringJPAService;

    @Mock
    private OrderRepositorySpringJp orderRepositorySpringJp;

    @Mock
    private ProductOrderService productOrderService;

    @Test
    public void getCargoOffer_Test() {

        long orderID =1;
        Optional<Order> order = Optional.ofNullable(Mockito.mock(Order.class));
        Mockito.when(orderRepositorySpringJp.findById(orderID)).thenReturn((order));

        OrderProduct orderProduct = Mockito.mock(OrderProduct.class);
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(orderProduct);

        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(70.0);

        Mockito.when(orderProduct.getProduct()).thenReturn(product);

        Mockito.when(productOrderService.findAllByOrder(order.get())).thenReturn(orderProductList);

        orderSpringJPAService.getCargoOffer(orderID);
        Mockito.verify(orderRepositorySpringJp, Mockito.times(1)).findById(orderID);

    }

    @Test
    public void getCargoOffer_ShouldThrowBusinessException_WhenTotalPriceIsBelow60() {

        long orderID =1;
        Optional<Order> order = Optional.ofNullable(Mockito.mock(Order.class));
        Mockito.when(orderRepositorySpringJp.findById(orderID)).thenReturn((order));

        OrderProduct orderProduct = Mockito.mock(OrderProduct.class);
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(orderProduct);

        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(50.0);

        Mockito.when(orderProduct.getProduct()).thenReturn(product);

        Mockito.when(productOrderService.findAllByOrder(order.get())).thenReturn(orderProductList);

        Exception exception = assertThrows(BusinessException.class, () -> {
            orderSpringJPAService.getCargoOffer(1L);
        });

        // Hata mesajının doğruluğunun kontrol edilmesi
        String expectedMessage = "Ürün tutarınız 50 liranın altında";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void getCargoOffer_ShouldThrowBusinessException_WhenTotalWeightIsBelow60() {

        long orderID =1;
        Optional<Order> order = Optional.ofNullable(Mockito.mock(Order.class));
        Mockito.when(orderRepositorySpringJp.findById(orderID)).thenReturn((order));

        OrderProduct orderProduct = Mockito.mock(OrderProduct.class);
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(orderProduct);

        Product product = Mockito.mock(Product.class);
        Mockito.when(product.getWeight()).thenReturn(20);

        Mockito.when(orderProduct.getProduct()).thenReturn(product);

        Mockito.when(productOrderService.findAllByOrder(order.get())).thenReturn(orderProductList);

        Exception exception = assertThrows(BusinessException.class, () -> {
            orderSpringJPAService.getCargoOffer(1L);
        });

        // Hata mesajının doğruluğunun kontrol edilmesi
        String expectedMessage = "ürün ağırlığı fazla. farklı bir kargo seçeneği ile ilerleyin";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



}
