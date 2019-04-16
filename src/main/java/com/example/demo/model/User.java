

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "user_id")
//    private int id;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "name")
//    private String name;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(name = "active")
//    private int active;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns =
//    @JoinColumn(name = "user_id"), inverseJoinColumns =
//    @JoinColumn(name = "role_id"))
//    private Set<Role> roles;
//
//
//    public User() {
//    }
//
//    public User(User users) {
//
//        this.active = users.active;
//        this.email = users.email;
//        this.id = users.id;
//        this.lastName = users.lastName;
//        this.name = users.name;
//        this.password = users.password;
//        this.roles = users.roles;
//
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public int getActive() {
//        return active;
//    }
//
//    public void setActive(int active) {
//        this.active = active;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//}

@Entity
@Table(name="users")
public class User
{
	@Id
	String username;
	String password;
	
	public User()
	{
		username="sample";
		password="sample";
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(User users) {
		// TODO Auto-generated constructor stub
		this.username=users.username;
		this.password=users.password;
	}
	
	
}