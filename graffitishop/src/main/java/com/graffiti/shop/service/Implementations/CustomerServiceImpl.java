package com.graffiti.shop.service.Implementations;

import com.graffiti.shop.domain.Customer;
import com.graffiti.shop.exceptions.NotFoundException;
import com.graffiti.shop.repository.CustomerRepository;
import com.graffiti.shop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        logger.info("getAllCustomers() entered");
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        logger.info("saveItem() entered with Entity = " + customer.toString());
        try {
            customer = customerRepository.save(customer);
            logger.info("Successfully created Customer with id = " + customer.getId());
            return customer;
        } catch (Exception e) {
            logger.error("Exception occurred while creating Customer: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomer(int id) {
        logger.info("getCustomer() entered with id = " + id);
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("Entity successfully found");
            return optional.get();
        } else {
            logger.error("Entity not found");
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        logger.info("deleteCustomer() deleted with id = " + id);
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Exception occurred while deleting Customer");
            throw new RuntimeException(e);
        }
    }
}
