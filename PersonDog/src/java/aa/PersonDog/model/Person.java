/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Person.findPersonByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_PERSON_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int age;
    private String name;

    //https://howtoprogramwithjava.com/hibernate-eager-vs-lazy-fetch-type/
    //@ManyToMany(fetch=FetchType.EAGER)
    @ManyToMany
    private List<Dog> dogs = null; //new ArrayList<Dog>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getId() == id;
        }

        return false;
    }

    public String toString() {
        String ret;

        ret = "Person: " + getId() + ","
                + getName() + ","
                + getAge();

        return ret;
    }
}
