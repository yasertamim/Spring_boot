package com.example.customer.customer;

import jakarta.transaction.Transactional;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CustomerController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @PostMapping

    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);

    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id){
        customerService.deleteCustomer(id);

    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email){

        customerService.updateCustomer(id,name,email);


    }
}
