package com.robotdreams.JavaSpringEduClass;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveOrderTest() throws Exception {
        String orderRequestDtoJson = createOrderRequestJson(1l, "ee", Arrays.asList(1l,2l));

        mockMvc.perform(post("/order/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderRequestDtoJson))
                .andExpect(status().isOk());

    }


    private String createOrderRequestJson(Long userId, String orderDescription, List<Long> productIdList) {
        return """
               {
                   "userId": %d,
                   "orderDescription": "%s",
                   "productIdList": %s
               }
               """.formatted(userId, orderDescription, productIdList.toString());
    }

}
