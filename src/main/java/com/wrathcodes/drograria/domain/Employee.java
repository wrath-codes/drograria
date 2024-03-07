package com.wrathcodes.drograria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends GenericDomain {
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 14, nullable = false)
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}