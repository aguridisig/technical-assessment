package com.assement.controller;

import java.time.LocalDateTime;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.assement.dto.PricesDTO;
import com.assement.service.PricesService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class PricesController
{
    private final PricesService pricesService;

    public static final String PRICES_PATH = "/api/v1/prices/dynamic";

    @GetMapping( PRICES_PATH )
    Mono<PricesDTO> getDynamicPrice( @Param( "branchId" ) final int branchId,
                                     @Param( "productId" ) final int productId,
                                     @Param( "date" ) final LocalDateTime date )
    {
        return pricesService.getDynamicPrice( branchId, productId, date, date )
                .switchIfEmpty( Mono.error( new ResponseStatusException( HttpStatus.NOT_FOUND ) ) );
    }
}
