package com.assement.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.assement.dto.PricesDTO;

@SpringBootTest
class PricesControllerTest
{
    @Autowired
    PricesController pricesController;

    @Test
    @Order( 1 )
    void getPriceFor10HDay14()
    {
        final Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T10:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 35.50, result.get().getPrice() );
    }

    @Test
    @Order( 2 )
    void getPriceFor16HDay14()
    {
        final Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T16:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 25.45, result.get().getPrice() );
    }

    @Test
    @Order( 3 )
    void getPriceFor21HDay14()
    {
        final Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-14T21:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 35.50, result.get().getPrice() );
    }

    @Test
    @Order( 4 )
    void getPriceFor10HDay15()
    {
        final Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-15T10:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 30.50, result.get().getPrice() );
    }

    @Test
    @Order( 5 )
    void getPriceFor21HDay16()
    {
        final Optional<PricesDTO> result =
                pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2020-06-16T21:00:00" ) );
        assertTrue( result.isPresent() );
        assertEquals( 38.95, result.get().getPrice() );
    }

    @Test
    @Order( 6 )
    void getPriceNotFound()
    {
        final ResponseStatusException thrown = assertThrows( ResponseStatusException.class,
                () -> pricesController.getDynamicPrice( 1, 35455, LocalDateTime.parse( "2023-06-17T21:00:00" ) ) );
        assertEquals( HttpStatus.NOT_FOUND, thrown.getStatusCode() );
    }

}