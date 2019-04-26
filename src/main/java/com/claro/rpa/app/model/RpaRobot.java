package com.claro.rpa.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RpaRobot
 * Date: 4/26/2019
 * Time: 1:58 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_robot")
public class RpaRobot {

    @Id
    private Integer id;
    private Integer category_id;
    private Integer input_type_id;
    private Integer user_id;
    private String name;
    private String description;
    private String version;
    private String location;
    private String status;
    private String system;
    private LocalDate execute_date;
    private LocalDate stop_date;
    private LocalDate pause_time;
    private String request_by;
    private String department;
    private String create_date;
    private String created_by;




}
