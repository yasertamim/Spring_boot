package com.example.customer.customer;

import jakarta.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String name;
    private Long tlf;
    private String address;
    private String email;


    public Customer(String name, Long tlf, String address, String email) {
        this.name = name;
        this.tlf = tlf;
        this.address = address;
        this.email = email;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTlf() {
        return tlf;
    }

    public void setTlf(Long tlf) {
        this.tlf = tlf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tlf=" + tlf +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
