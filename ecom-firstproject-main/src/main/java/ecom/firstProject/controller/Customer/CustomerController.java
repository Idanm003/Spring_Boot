package ecom.firstProject.controller.Customer;

import ecom.firstProject.Service.Customer.CustomerService;
import ecom.firstProject.model.Customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return  customerService.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/ids")
    public List<Integer> getAllCustomerIdsByFirstName(@RequestParam String firstName){
        return customerService.getAllCustomerIdsByFirstName(firstName);
    }

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
    }
}
