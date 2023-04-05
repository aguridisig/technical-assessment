package com.assement.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.assement.dto.PricesDTO;

@SpringBootTest
class PricesControllerTest
{
    @Autowired
    PricesController pricesController;

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order( 1 )
    void getPriceFor10HDay14()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T10:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 35.50, result.get().getPrice() );
    }

    @Test
    @Order( 2 )
    void getPriceFor16HDay14()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T16:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 25.45, result.get().getPrice() );
    }

    @Test
    @Order( 3 )
    void getPriceFor21HDay14()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T21:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 35.50, result.get().getPrice() );
    }

    @Test
    @Order( 4 )
    void getPriceFor10HDay15()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-15T10:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 30.50, result.get().getPrice() );
    }

    @Test
    @Order( 5 )
    void getPriceFor21HDay16()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-16T21:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 38.95, result.get().getPrice() );
    }

    @Test
    @Order( 6 )
    void getPriceNotFound()
    {
        Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2023-06-16T21:00:00" ) );
        assertTrue( result.isEmpty() );
    }

}