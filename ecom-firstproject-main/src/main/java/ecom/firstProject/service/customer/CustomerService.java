package ecom.firstProject.service.customer;

import ecom.firstProject.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIdsByFirstName(String firstName);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Integer id);
}
