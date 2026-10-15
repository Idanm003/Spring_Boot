package ecom.firstProject.service.person;

import ecom.firstProject.model.person.Person;
import ecom.firstProject.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    @Override
    public void createPerson(Person person) {
        personRepository.createPerson(person);
        String personAsString = objectMapper.writeValueAsString(person);
        System.out.println("Starting to create a new person: " + personAsString);
        Person personFromString = objectMapper.readValue(personAsString, Person.class);
        System.out.println("Person Full Name: " +
                personFromString.getFirstName() + " "
                + personFromString.getLastName()
        );
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.updatePerson(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deletePerson(id);
    }
}
