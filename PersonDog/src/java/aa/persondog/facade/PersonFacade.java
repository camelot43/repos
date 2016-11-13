/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.persondog.facade;


import java.io.Serializable;
import java.util.List;

import aa.persondog.dao.DogDAO;
import aa.persondog.dao.PersonDAO;
import aa.persondog.model.Dog;
import aa.persondog.model.Person;

public class PersonFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PersonDAO personDAO = new PersonDAO();
	private DogDAO dogDAO = new DogDAO();

	public void createPerson(Person person) {
		personDAO.beginTransaction();
		personDAO.save(person);
		personDAO.commitAndCloseTransaction();
	}

	public void updatePerson(Person person) {
		personDAO.beginTransaction();
		Person persistedPerson = personDAO.find(person.getId());
		persistedPerson.setName(person.getName());
		persistedPerson.setAge(person.getAge());
		personDAO.commitAndCloseTransaction();
	}
	
	public void deletePerson(Person person){
		personDAO.beginTransaction();
		Person persistedPersonWithIdOnly = personDAO.findReferenceOnly(person.getId());
		personDAO.delete(persistedPersonWithIdOnly);
		personDAO.commitAndCloseTransaction();
		
	}

	public Person findPerson(int personId) {
		personDAO.beginTransaction();
		Person person = personDAO.find(personId);
		personDAO.closeTransaction();
		return person;
	}

	public List<Person> listAll() {
		personDAO.beginTransaction();
		List<Person> result = personDAO.findAll();
		personDAO.closeTransaction();

		return result;
	}

	public Person findPersonWithAllDogs(int personId) {
		personDAO.beginTransaction();
		Person person = personDAO.findPersonWithAllDogs(personId);
		personDAO.closeTransaction();
		return person;
	}

	public void addDogToPerson(int dogId, int personId) {
		personDAO.beginTransaction();
		dogDAO.joinTransaction();
		Dog dog = dogDAO.find(dogId);
		Person person = personDAO.find(personId);
		person.getDogs().add(dog);
		dog.getPerson().add(person);
		personDAO.commitAndCloseTransaction();
	}

	public void removeDogFromPerson(int dogId, int personId) {
		personDAO.beginTransaction();
		dogDAO.joinTransaction();
		Dog dog = dogDAO.find(dogId);
		Person person = personDAO.find(personId);
		person.getDogs().remove(dog);
		dog.getPerson().remove(person);
		personDAO.commitAndCloseTransaction();
	}
}