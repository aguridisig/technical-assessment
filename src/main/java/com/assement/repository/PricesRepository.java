package com.assement.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assement.entities.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer>
{

        Optional<Prices> findFirstByBranchIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                Integer branchId, Integer productId, LocalDateTime date, LocalDateTime date2 );
}
