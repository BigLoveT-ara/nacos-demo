package org.yshu.nacos.faced.dto;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDTO implements Serializable {


    private static final long serialVersionUID = 67286697815183057L;

    private Long id;

    private String name;

    private int male;

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

    public UserDTO() {
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }
}
