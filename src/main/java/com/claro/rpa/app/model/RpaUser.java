package com.claro.rpa.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @JsonIgnore
    private String username;
    private String password;
    private String ipAddress;
    private String dnsAddress;
    private String shareDirectoryPath;
    private boolean enabled;



    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RpaRobot> rpaRobot;






}
