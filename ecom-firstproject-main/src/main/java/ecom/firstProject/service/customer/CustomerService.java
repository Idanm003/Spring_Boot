package ecom.firstProject.service.customer;

import ecom.firstProject.model.customer.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIdsByFirstName(String firstName);
    Integer createCustomer(Customer customer) throws Exception;
    void updateCustomer(Customer customer) throws Exception;
    void deleteCustomerById(Integer id) throws Exception;
}
