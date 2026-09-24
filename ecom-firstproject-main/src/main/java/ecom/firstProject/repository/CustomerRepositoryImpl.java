package ecom.firstProject.repository;

import ecom.firstProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " " +
                "(first_name,last_name, email) values (?,?,?)";
        jdbcTemplate.update
                (sql,
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail()
                );
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE " +  CUSTOMER_TABLE_NAME + " " +
                "SET first_name=?, last_name=?, email=? " +
                "WHERE id=?";
        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getCustomerId()
        );
    }

    @Override
    public void deleteCustomerById(Integer id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}