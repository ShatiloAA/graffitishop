package com.graffiti.shop.service;

import com.graffiti.shop.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
