package ecom.firstProject.repository.person;

import ecom.firstProject.model.person.Person;

import java.util.List;

public interface PersonRepository {
    Person getPersonById(Integer id);
    List<Person> getAllPersons();
    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Integer id);
}
