package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * CategoryService
 * Date: 4/26/2019
 * Time: 2:14 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_category")
public class RpaCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RpaRobot> rpaRobot;
}
