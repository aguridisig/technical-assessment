package com.assement.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.assement.dto.PricesDTO;
import com.assement.mappers.PricesMapper;
import com.assement.repository.PricesRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService
{
    private final PricesRepository pricesRepository;
    private final PricesMapper pricesMapper;

    @Override
    public Mono<PricesDTO> getDynamicPrice( final int branchId, final int productId, final LocalDateTime date,
                                            final LocalDateTime date2 )
    {
        return pricesRepository.findFirstByBranchIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        branchId, productId, date, date2 )
                .map( pricesMapper::pricesToPricesDto );

    }
}
