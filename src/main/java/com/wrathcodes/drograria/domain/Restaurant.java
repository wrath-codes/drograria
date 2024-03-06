package com.wrathcodes.drograria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Restaurant extends GenericDomain {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
