package com.assement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.assement.config.DatabaseConfig;

@SpringBootApplication
@Import( DatabaseConfig.class )
public class AssessmentApplication
{

	public static void main(String[] args) {
		SpringApplication.run( AssessmentApplication.class, args);
	}

}
