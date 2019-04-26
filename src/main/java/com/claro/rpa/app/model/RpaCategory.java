package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RpaCategory
 * Date: 4/26/2019
 * Time: 2:14 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_category")
public class RpaCategory {

    @Id
    private Integer id;
    private String name;

    @OneToMany (cascade= CascadeType.ALL, mappedBy="RpaCategory")
    @JoinColumn(name="rpa_robot_id")
    private List<RpaRobot> rpaRobot;
}
