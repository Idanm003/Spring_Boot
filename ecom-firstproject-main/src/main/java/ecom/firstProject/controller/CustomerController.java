package ecom.firstProject.controller;

import ecom.firstProject.model.Customer;
import ecom.firstProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerRepository.updateCustomer(customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id){
        customerRepository.deleteCustomerById(id);
    }
}
