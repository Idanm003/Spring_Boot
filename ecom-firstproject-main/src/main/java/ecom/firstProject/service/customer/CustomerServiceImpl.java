package ecom.firstProject.service.customer;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.customer.CustomerStatus;
import ecom.firstProject.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Integer> getAllCustomerIdsByFirstName(String firstName) {
        return customerRepository.getAllCustomerIdsByFirstName(firstName);
    }

    @Override
    public Integer createCustomer(Customer customer) throws Exception {
        //Object Mapper reference
        String customerAsString = objectMapper.writeValueAsString(customer);
        System.out.println("Starting create a customer : " + customerAsString);
        Customer customerFromString = objectMapper.readValue(customerAsString, Customer.class);
        System.out.println(customerFromString.getFirstName());

        if (customer.getCustomerStatus() == CustomerStatus.VIP) {
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);

            if (!(vipCustomers.size() >= 10)) {
                return customerRepository.createCustomer(customer);
            } else {
                throw new Exception("ould not create new customer with status VIP - Out of limit");
            }
        } else {
            return customerRepository.createCustomer(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        if (customer.getCustomerStatus() == CustomerStatus.VIP) {
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);

            if (!(vipCustomers.size() >= 10)) {
                throw new Exception("Cannot update customer with status VIP - Out of limit");
            }
        } else {
            customerRepository.updateCustomer(customer);
        }
    }

    @Override
    public void deleteCustomerById(Integer id) throws Exception {
        customerRepository.deleteCustomerById(id);
    }
}
