package ecom.firstProject.mapper.person;

import ecom.firstProject.model.order.Order;
import ecom.firstProject.model.person.Person;
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