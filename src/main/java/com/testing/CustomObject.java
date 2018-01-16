package com.testing;
import java.util.Date;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class CustomObject {
	@Version
	@JsonIgnore
	private int version;
	
	@CreatedDate
	@JsonProperty("creation_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date creationDate;

	@LastModifiedDate
	@JsonProperty("update_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	@CreatedBy
	@JsonProperty("created_by")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String createdBy;

	@LastModifiedBy
	@JsonProperty("update_by")
	private String updatedBy;

	private boolean enabled = true;
}
