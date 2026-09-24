package ecom.firstProject.repository;

import ecom.firstProject.model.Customer;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Integer id);
}
