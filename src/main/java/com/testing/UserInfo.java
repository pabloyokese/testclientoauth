package com.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class UserInfo {
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String image;
	private List<RoleInfo> roles;

	public UserInfo(User user) {
		setId(user.getId());
		setEmail(user.getEmail());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setAge(user.getAge());
		setGender(user.getGender());
		setImage(user.getImage());
		List<RoleInfo> rolesInfo = user.getRoles().stream().map(role -> new RoleInfo(role))
				.collect(Collectors.toList());
		setRoles(rolesInfo);
	}
}
