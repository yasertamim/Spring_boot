package com.example.customer.customer;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();

    }

    public void addCustomer(Customer customer) {
        Optional<Customer> exists = customerRepository.findCustomerByEmail(customer.getEmail());
        if (exists.isPresent()){
            throw new IllegalStateException("the customer is already exists");
        }
        customerRepository.save(customer);

    }

    public void deleteCustomer(Long id) {
        boolean idExists = customerRepository.existsById(id);
        if (!idExists){
            throw new IllegalStateException("the customer with id: "+ id + "does not exists");
        }
        customerRepository.deleteById(id);
    }

    @Transactional
    public void updateCustomer(Long id, String name, String email){
        Customer customer = customerRepository.findById(id)
                .orElseThrow( ()-> new IllegalStateException(
                "the customer is not exsists"
        ) );



        if (name!= null
        && name.length()>0 &&
                !Objects.equals(customer.getName(), name)){

                customer.setName(name);
        }

        if (email!= null
        && email.length() > 0 &&
        !Objects.equals(customer.getEmail(),email)){
            customer.setEmail(email);
        }


    }
}
