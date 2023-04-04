package com.assement.bootstrap;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.assement.domain.Prices;
import com.assement.repository.PricesRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BootstrapData implements CommandLineRunner
{
    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public void run( final String... args ) throws Exception
    {
        log.info( "Loading Prices Data" );
        loaderPricesData();
        pricesRepository.count().subscribe(count ->
                log.info("Number of price lists loaded: " + count));

    }

    private void loaderPricesData()
    {
        pricesRepository.count()
                .subscribe( count -> {
                    if ( count == 0 )
                    {
                        final Prices prices1 = Prices.builder()
                                .branchId( 1 )
                                .productId( 35455 )
                                .priority( 0 )
                                .startDate( LocalDateTime.parse( "2020-06-14T00:00:00" ) )
                                .endDate( LocalDateTime.parse( "2020-12-31T23:59:59" ) )
                                .price( 35.50)
                                .curr( "EUR" )
                                .build();
                        final Prices prices2 = Prices.builder()
                                .branchId( 1 )
                                .productId( 35455 )
                                .priority( 1 )
                                .startDate( LocalDateTime.parse( "2020-06-14T15:00:00" ) )
                                .endDate( LocalDateTime.parse( "2020-06-14T18:30:00" ) )
                                .price( 25.45 )
                                .curr( "EUR" )
                                .build();
                        final Prices prices3 = Prices.builder()
                                .branchId( 1 )
                                .productId( 35455 )
                                .priority( 1 )
                                .startDate( LocalDateTime.parse( "2020-06-15T00:00:00" ) )
                                .endDate( LocalDateTime.parse( "2020-06-15T11:00:00" ) )
                                .price( 30.50 )
                                .curr( "EUR" )
                                .build();
                        final Prices prices4 = Prices.builder()
                                .branchId( 1 )
                                .productId( 35455 )
                                .priority( 1 )
                                .startDate( LocalDateTime.parse( "2020-06-15T16:00:00" ) )
                                .endDate( LocalDateTime.parse( "2020-12-31T23:59:59" ) )
                                .price( 38.95)
                                .curr( "EUR" )
                                .build();
                        pricesRepository.save( prices1 ).subscribe();
                        pricesRepository.save( prices2 ).subscribe();
                        pricesRepository.save( prices3 ).subscribe();
                        pricesRepository.save( prices4 ).subscribe();
                    }
                } );
    }
}
