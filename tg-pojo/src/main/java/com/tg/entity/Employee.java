package com.tg.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import nonapi.io.github.classgraph.json.Id;

/**
 * 员工
 */
//@Entity
//@Table(name = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@ApiModel(description = "员工")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("员工ID")
    private Integer id;

    @Column(name = "name", nullable = false)
    @ApiModelProperty("员工姓名编号")
    private Integer name;

    @Column(name = "username")
    @ApiModelProperty("员工用户名")
    private String username;

    @Column(name = "department", nullable = false)
    @ApiModelProperty("所属部门")
    private Integer department;

    @Column(name = "password", nullable = false)
    @ApiModelProperty("员工密码")
    private String password;
}
