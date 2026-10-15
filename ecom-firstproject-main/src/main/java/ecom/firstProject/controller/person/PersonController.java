package ecom.firstProject.controller.person;

import ecom.firstProject.service.person.PersonService;
import ecom.firstProject.model.person.Person;
import ecom.firstProject.repository.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable(value = "id") Integer id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @PostMapping(value = "/create")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }

    @PutMapping(value = "/update")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePerson(@PathVariable(value = "id") Integer id) {
        personService.deletePerson(id);
    }
}
