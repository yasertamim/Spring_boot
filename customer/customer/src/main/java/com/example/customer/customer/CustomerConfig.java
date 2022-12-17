package com.example.customer.customer;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer yaser = new Customer(
                    "yaser",
                    45546032L,
                    "Arendal",
                    "yaser@gmail.com"

            );
            Customer miral = new Customer(
                    "miral",
                    93076887L,
                    "Arendal",
                    "miral@gmail.com"

            );
            customerRepository.saveAll(List.of(yaser,miral));
        };

    }

}
