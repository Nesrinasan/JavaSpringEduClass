package com.robotdreams.JavaSpringEduClass.FunctionalProgramming;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAPI {


    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setPrice(12.4);
        productList.add(product);

        Product product2 = new Product();
        product2.setPrice(15.4);
        productList.add(product2);

        Product product3 = new Product();
        product3.setPrice(1.4);
        productList.add(product3);

        MathFunction mathFunction = (value1, value2) -> value1 * value2;
        int apply = mathFunction.apply(2, 3);
        System.out.println(apply);


    }




}
