package com.example.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.example.datasource.model.ProfileMaster;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class DatasourceApplication implements CommandLineRunner{

    @Autowired
    MongoTemplate mongoTemplate;
    
	public static void main(String[] args) {
		SpringApplication.run(DatasourceApplication.class, args);
	}

    @Override
    public void run(String... args) {
        
        mongoTemplate.dropCollection(ProfileMaster.class);
        
        mongoTemplate.save(ProfileMaster.builder().about("10 years of experience in Insurance Domain.")
        		                                  .technical_competancy("C5")
        		                                  .current_practice_manager("Deottam")
        		                                  .current_practice_manager_email("deottam.jha@gmail.com")
        		                                  .experience_in_months(25)
        		                                  .build());
        mongoTemplate.save(ProfileMaster.builder().about("15 years of experience in MDM Domain.")
									              .technical_competancy("C6")
									              .current_practice_manager("Pramod")
									              .current_practice_manager_email("pramod.panday@gmail.com")
									              .experience_in_months(25)
									              .build());
        
        log.info("-------------------------------");
        log.info("Cards found: " + mongoTemplate.count(new Query(), ProfileMaster.class));
        log.info("-------------------------------");
    }
}
