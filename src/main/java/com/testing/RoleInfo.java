package com.testing;

import lombok.Data;

@Data
public class RoleInfo {
	private String id;
	private String name;
	
	public RoleInfo(Role role) {
		setId(role.getId());
		setName(role.getName());
	}
}
