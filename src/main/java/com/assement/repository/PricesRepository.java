package com.assement.repository;

import java.time.LocalDateTime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.assement.domain.Prices;

import reactor.core.publisher.Mono;

public interface PricesRepository extends ReactiveCrudRepository<Prices, Integer>
{

    Mono<Prices> findFirstByBranchIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Integer branchId, Integer productId, LocalDateTime date, LocalDateTime date2 );
}
