package ecom.firstProject.mapper.Person;

import ecom.firstProject.model.Order.Order;
import ecom.firstProject.model.Person.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person>
{
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"));
    }
}