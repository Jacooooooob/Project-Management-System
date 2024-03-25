package com.tg.entity;

import lombok.*;

/**
 * 项目与与员工的分配关系
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAssignment {

    private Long id;

    private Project project;

    private Employee employee;

    private String role; // 可以是“开发人员”、“经理”等等
}
