package com.assement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import com.assement.dto.PricesDTO;

public interface PricesService
{
    Optional<PricesDTO> getDynamicPrice( int branchId, int productId, LocalDateTime date );
}
