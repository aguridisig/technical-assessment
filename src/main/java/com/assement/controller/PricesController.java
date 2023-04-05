package com.assement.controller;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.assement.dto.PricesDTO;
import com.assement.service.PricesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PricesController
{
    private final PricesService pricesService;

    public static final String PRICES_PATH = "api/v1/prices";

    @GetMapping( PRICES_PATH )
    Optional<PricesDTO> getDynamicPrice( @Param( "branchId" ) final int branchId,
                                         @Param( "productId" ) final int productId,
                                         @Param( "date" ) final LocalDateTime date )
    {
        return Optional.ofNullable( pricesService.getDynamicPrice( branchId, productId, date )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) ) );

    }
}
