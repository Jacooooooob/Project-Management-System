package com.tg.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(description = "项目审计信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAuditVO {

    @ApiModelProperty(value = "项目ID", required = true)
    private Long projectId;

    @ApiModelProperty(value = "审计人姓名")
    private String auditorName;

    @ApiModelProperty(value = "审计状态")
    private String auditStatus;

    @ApiModelProperty(value = "审计备注")
    private String comments;

    @ApiModelProperty(value = "审计时间", example = "2024-01-01T12:00:00")
    private LocalDateTime auditTime;
}