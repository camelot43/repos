/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Person.findUserByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_USER_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int age;
	private String name;

	@ManyToMany
	private List<Dog> dogs;

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
}











/**
 *
 * Codigo Original
 * 
 * @author aanciaes

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aa.PersonDog.model.Person[ id=" + id + " ]";
    }
    
}
 */
