package com.testing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


/**
 * Created by pabloyokese on 5/29/2017.
 */
@Data
@Document(collection="roles")
public class Role extends CustomObject implements IEntity{
    @Id
    private String id;
    private String name;
    

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

}
