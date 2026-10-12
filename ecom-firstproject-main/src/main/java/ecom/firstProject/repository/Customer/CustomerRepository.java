package ecom.firstProject.repository.Customer;

import ecom.firstProject.model.Customer.Customer;
import ecom.firstProject.model.Customer.CustomerStatus;

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
