package ecom.firstProject.repository.Customer;

import ecom.firstProject.mapper.Customer.CustomerMapper;
import ecom.firstProject.model.Customer.Customer;
import ecom.firstProject.model.Customer.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Customer getCustomerById(Integer id) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        try {
        return jdbcTemplate.queryForObject(
                sql,
                new CustomerMapper(),
                id
        );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME;
        try {
        return jdbcTemplate.query(
                sql,
                new CustomerMapper()
        );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Integer> getAllCustomerIdsByFirstName(@RequestParam String firstName) {
        String sql = "SELECT id FROM " + CUSTOMER_TABLE_NAME +
                " WHERE first_name=?";
        try {
            return jdbcTemplate.queryForList(
                    sql,
                    Integer.class,
                    firstName
            );
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomersByStatus(CustomerStatus customerStatus) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME +
                " WHERE customer_status=?";
        try{
            return jdbcTemplate.query(
                sql,
                new CustomerMapper(),
                customerStatus
            );
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " " +
                "(first_name,last_name, email, customer_status) values (?,?,?,?)";
        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getCustomerStatus().name()
        );
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE " +  CUSTOMER_TABLE_NAME + " " +
                "SET first_name=?, last_name=?, email=?, customer_status=? " +
                "WHERE id=?";
        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getCustomerStatus().name(),
                customer.getCustomerId()
        );
    }

    @Override
    public void deleteCustomerById(Integer id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}