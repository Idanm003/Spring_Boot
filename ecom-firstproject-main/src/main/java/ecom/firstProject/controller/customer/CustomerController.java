package ecom.firstProject.controller.customer;

import ecom.firstProject.service.customer.CustomerService;
import ecom.firstProject.model.customer.Customer;
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
    public void createCustomer(@RequestBody Customer customer) throws Exception {
        customerService.createCustomer(customer);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer) throws Exception {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) throws Exception {
        customerService.deleteCustomerById(id);
    }
}
