package ecom.firstProject.repository.person;

import ecom.firstProject.mapper.person.PersonMapper;
import ecom.firstProject.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    public static final String PERSON_TABLE_NAME = "person";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Person getPersonById(Integer id) {
        String sql = "SELECT * FROM " + PERSON_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    new PersonMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM " + PERSON_TABLE_NAME;
        try{
            return jdbcTemplate.query(
                    sql,
                    new PersonMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void createPerson(Person person) {
        String sql = "INSERT INTO " + PERSON_TABLE_NAME + " " +
                "(first_name, last_name) VALUES (?,?)";
        jdbcTemplate.update(
                sql,
                person.getFirstName(),
                person.getLastName()
        );
    }

    @Override
    public void updatePerson(Person person) {
        String sql = "UPDATE " + PERSON_TABLE_NAME + " " +
                "SET first_name=?, last_name=? " +
                "WHERE id=?";
        jdbcTemplate.update(
                sql,
                person.getFirstName(),
                person.getLastName(),
                person.getId()
        );
    }

    @Override
    public void deletePerson(Integer id) {
        String sql = "DELETE FROM " + PERSON_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
