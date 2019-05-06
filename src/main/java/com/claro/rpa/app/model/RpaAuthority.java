package com.claro.rpa.app.model;

import javax.persistence.*;

@Entity
@Table(name = "rpa_authority")
public class RpaAuthority {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
