package ecom.firstProject.repository;

import ecom.firstProject.model.Customer;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIdsByFirstName(@RequestParam String firstName);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Integer id);
}
