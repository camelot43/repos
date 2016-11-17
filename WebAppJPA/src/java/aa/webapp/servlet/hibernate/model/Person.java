/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://www.journaldev.com/2905/hibernate-tomcat-jndi-datasource-example-tutorial

CREATE TABLE Person (
  id int(11)  NOT NULL,
  name varchar(20) DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  insert_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Person (id, name, role, insert_time)
VALUES	(14, 'David', 'Developer', null);
INSERT INTO Person (id, name, role, insert_time)
VALUES	(3, 'Pankaj', 'CEO', null);

 */
package aa.webapp.servlet.hibernate.model;

import java.util.Date;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;

/**
 *
 * @author aanciaes
 */
@Entity
@Table(name = "Person",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"ID"})})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private Long id;

    @Column(name = "NAME", length = 20, nullable = true)
    private String name;

    @Column(name = "ROLE", length = 20, nullable = true)
    private String role;

    @Column(name = "insert_time", nullable = true)
    private Date insertTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "aa.webapp.servlet.hibernate.model.Person[ id=" + id + " ]";
    }

}
