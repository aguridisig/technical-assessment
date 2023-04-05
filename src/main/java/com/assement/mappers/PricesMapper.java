package com.assement.mappers;

import org.mapstruct.Mapper;
import com.assement.entities.Prices;
import com.assement.dto.PricesDTO;
@Mapper
public interface PricesMapper
{
    Prices pricesDtoToPrices( PricesDTO dto);
    PricesDTO pricesToPricesDto( Prices prices);
}
