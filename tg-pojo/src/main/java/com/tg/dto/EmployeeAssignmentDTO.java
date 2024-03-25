package com.tg.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAssignmentDTO {
    private Integer projectId;
    private Integer employeeId;
    private String role; // 例如：开发者、项目经理等

}
