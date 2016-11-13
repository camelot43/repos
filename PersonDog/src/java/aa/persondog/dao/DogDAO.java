/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.persondog.dao;


import aa.persondog.model.Dog;

public class DogDAO extends GenericDAO<Dog> {

	private static final long serialVersionUID = 1L;

	public DogDAO() {
		super(Dog.class);
	}

	public void delete(Dog dog) {
		super.delete(dog.getId(), Dog.class);
	}

}