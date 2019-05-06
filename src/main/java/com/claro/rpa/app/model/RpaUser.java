package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RpaUser
 * Date: 4/26/2019
 * Time: 2:16 PM
 */
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_user")
public class RpaUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String ipAddress;
    private String dnsAddress;
    private String shareDirectoryPath;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<RpaAuthority> authority;



    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RpaRobot> rpaRobot;



    public Set<RpaAuthority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<RpaAuthority> authority) {
        this.authority = authority;
    }
}
