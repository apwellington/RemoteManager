package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RpaInputDetail
 * Date: 4/26/2019
 * Time: 2:32 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_input_detail")
public class RpaInputDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String fieldName;

    @OneToOne
    private RpaInputType rpaInputType;
}
