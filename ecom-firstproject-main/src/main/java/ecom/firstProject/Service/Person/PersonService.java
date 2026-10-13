package ecom.firstProject.Service.Person;

import ecom.firstProject.model.Person.Person;

import java.util.List;

public interface PersonService {
    Person getPersonById(Integer id);
    List<Person> getAllPersons();
    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Integer id);
}
