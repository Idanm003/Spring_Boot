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
    public void createCustomer(Customer customer) {
        List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);

        String customerAsString = objectMapper.writeValueAsString(customer);
        Customer customerFromString = objectMapper.readValue(customerAsString, Customer.class);

        if (!(vipCustomers.size() >= 10 )) {
            customerRepository.createCustomer(customer);
        }
        else {
            System.out.println("Max VIP Customers Exists");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (customer.getCustomerStatus() == CustomerStatus.VIP) {
            List<Customer> vipCustomers = customerRepository.getAllCustomersByStatus(CustomerStatus.VIP);
            if (!(vipCustomers.size() > 5)) {
                customerRepository.updateCustomer(customer);
            } else {
                System.out.println("Max VIP Customers Reached");
            }
        } else {
            customerRepository.updateCustomer(customer);
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteCustomerById(id);
    }
}
