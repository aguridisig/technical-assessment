package com.assement.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class PricesControllerTest
{
    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order( 1 )
    void getPriceFor10HDay14()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2020-06-14T10:00:00" )
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath( "$.price" ).isEqualTo( 35.50 )
                .jsonPath( "$.curr" ).isEqualTo( "EUR" );
    }

    @Test
    @Order( 2 )
    void getPriceFor16HDay14()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2020-06-14T16:00:00" )
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath( "$.price" ).isEqualTo( 25.45 )
                .jsonPath( "$.curr" ).isEqualTo( "EUR" );
    }

    @Test
    @Order( 3 )
    void getPriceFor21HDay14()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2020-06-14T21:00:00" )
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath( "$.price" ).isEqualTo( 35.50 )
                .jsonPath( "$.curr" ).isEqualTo( "EUR" );
    }

    @Test
    @Order( 4 )
    void getPriceFor10HDay15()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2020-06-15T10:00:00" )
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath( "$.price" ).isEqualTo( 30.50 )
                .jsonPath( "$.curr" ).isEqualTo( "EUR" );
    }

    @Test
    @Order( 5 )
    void getPriceFor21HDay16()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2020-06-16T21:00:00" )
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath( "$.price" ).isEqualTo( 38.95 )
                .jsonPath( "$.curr" ).isEqualTo( "EUR" );
    }

    @Test
    @Order( 6 )
    void getPriceNotFound()
    {
        webTestClient.get().uri( PricesController.PRICES_PATH + "?branchId=1&productId=35455&date=2023-06-16T21:00:00" )
                .exchange()
                .expectStatus().isNotFound();
    }
}