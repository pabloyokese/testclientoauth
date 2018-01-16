package com.testing;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by pabloyokese on 5/29/2017.
 */
@Data
@Document(collection="users")
public class User extends CustomObject implements IEntity{
	
    @Id
    private String id;
    
    private String email;
    
    private String password;
    
    private String firstName;
    
	private String lastName;
    
	private Integer age;
    
	private String gender;
    
    private String image;
	
    @DBRef
	private List<Role> roles;

    public User(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User() {
    }

	public User(String id, String email, String password, String firstName, String lastName, Integer age, String gender,
			List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.roles = roles;
	}

	
}
