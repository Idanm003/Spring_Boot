package ecom.firstProject.mapper.customer;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.customer.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                CustomerStatus.valueOf(rs.getString("customer_status"))
        );
    }
}