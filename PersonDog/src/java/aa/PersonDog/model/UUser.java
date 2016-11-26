/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author aanciaes
 */
@Entity
@NamedQuery(name = "User.findUUserByEmail", query = "select u from UUser u where u.email = :email")
public class UUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_EMAIL = "User.findUUserByEmail";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// @Column(unique = true)
	private String email;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return Role.ADMIN.equals(role);
	}

	public boolean isUser() {
		return Role.USER.equals(role);
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UUser) {
			UUser user = (UUser) obj;
			return user.getId() == id;
		}

		return false;
	}
        
    @Override
    public String toString() {
        return "aa.persondog.model.UUser[ id=" + id + " ]";
    }        
}







