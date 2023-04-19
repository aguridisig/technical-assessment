package com.assement.controller;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.assement.dto.PricesDTO;
import com.assement.service.PricesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag( name = "Prices", description = "Prices API" )
public class PricesController
{
    private final PricesService pricesService;

    public static final String PRICES_PATH = "/api/v1";
    @GetMapping( PRICES_PATH+"/prices" )
    @ResponseStatus( HttpStatus.OK )
    @Operation( summary = "Get dynamic price",
            description = "An item can have different prices depending on the branch where it is sold and the date "
                    + "and time of the purchase. This API returns the price of an item for a given branch and date "
                    + "and time." )
    Optional<PricesDTO> getDynamicPrice( @Param( "branchId" ) final int branchId,
                                         @Param( "productId" ) final int productId,
                                         @Param( "date" ) final LocalDateTime date )
    {
        return Optional.ofNullable( pricesService.getDynamicPrice( branchId, productId, date )
                .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) ) );

    }
}
