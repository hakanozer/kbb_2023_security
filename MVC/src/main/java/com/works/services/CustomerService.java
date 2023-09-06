package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final TinkEncDec tinkEncDec;

    public Customer save( Customer customer ) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customer.getEmail());
        if (optionalCustomer.isPresent() ) {
            return null;
        }else {
            customer.setPassword( tinkEncDec.encrypt( customer.getPassword() ) );
            customerRepository.save(customer);
            return customer;
        }
    }


    public boolean login( Customer customer ) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailEqualsIgnoreCase(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            Customer dbCustomer = optionalCustomer.get();
            String dbPass = tinkEncDec.decrypt(dbCustomer.getPassword());
            if ( dbPass.equals( customer.getPassword() ) ) {
                return true;
            }
        }
        return false;
    }

}
