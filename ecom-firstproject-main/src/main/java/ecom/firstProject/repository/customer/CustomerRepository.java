package ecom.firstProject.repository.customer;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.customer.CustomerStatus;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus);
    Integer createCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer) throws Exception;
    void deleteCustomerById(Integer id) throws Exception;
}
