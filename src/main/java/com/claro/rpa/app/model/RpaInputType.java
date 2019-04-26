package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RpaInputType
 * Date: 4/26/2019
 * Time: 2:36 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_input_type")
public class RpaInputType {

    @Id
    private Integer id;
    private String name;


    @OneToOne
    private List<RpaRobot> rpaRobot;
}
