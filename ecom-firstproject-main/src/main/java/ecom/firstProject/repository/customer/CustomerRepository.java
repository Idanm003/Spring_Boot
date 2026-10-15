package ecom.firstProject.repository.customer;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.customer.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Integer id);
}
