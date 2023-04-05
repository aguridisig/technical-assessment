package com.assement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.assement.dto.PricesDTO;
import com.assement.mappers.PricesMapper;
import com.assement.repository.PricesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService
{
    private final PricesRepository pricesRepository;
    private final PricesMapper pricesMapper;

    @Override
    public Optional<PricesDTO> getDynamicPrice( final int branchId, final int productId, final LocalDateTime date )
    {
        return
                pricesRepository.findFirstByBranchIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        branchId, productId, date, date ).map( pricesMapper::pricesToPricesDto );
    }
}
