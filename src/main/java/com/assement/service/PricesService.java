package com.assement.service;

import java.time.LocalDateTime;
import com.assement.dto.PricesDTO;

import reactor.core.publisher.Mono;

public interface PricesService
{

    Mono<PricesDTO> getDynamicPrice( final int branchId, final int productId, final LocalDateTime date);
}
