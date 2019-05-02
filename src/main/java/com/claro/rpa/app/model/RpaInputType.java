package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * InputTypeService
 * Date: 4/26/2019
 * Time: 2:36 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_input_type")
public class RpaInputType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

}
