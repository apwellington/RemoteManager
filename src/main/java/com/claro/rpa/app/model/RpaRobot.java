package com.claro.rpa.app.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frodriguez
 * RobotService
 * Date: 4/26/2019
 * Time: 1:58 PM
 */

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "rpa_robot")
public class RpaRobot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String description;
    private String version;
    private String location;
    private String status;
    private String system;
    private String request_by;
    private String department;
    private String created_by;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date execute_date;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date stop_date;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date pause_time;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date create_date;





}
