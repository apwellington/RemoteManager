package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class RpaInputDetail {

    @Id
    private Integer id;
    private String name;
    private String inputTypeId;
    private String fieldName;

    @OneToOne
    private RpaInputType rpaInputType;
}
