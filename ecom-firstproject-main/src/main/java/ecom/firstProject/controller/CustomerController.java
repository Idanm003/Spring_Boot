package ecom.firstProject.controller;

import ecom.firstProject.model.Customer;
import ecom.firstProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return  customerRepository.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

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
