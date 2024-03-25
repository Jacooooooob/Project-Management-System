package com.tg.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

// TODO:
@ApiModel(description = "项目启动信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInitiationVO {

    @ApiModelProperty(value = "项目ID", required = true)
    private Long id;

    @ApiModelProperty(value = "项目名称", required = true)
    private String projectName;

    @ApiModelProperty(value = "项目描述", notes = "对项目的简短描述")
    private String description;

    @ApiModelProperty(value = "项目经理ID", required = true)
    private Long projectManagerId;

    @ApiModelProperty(value = "项目经理姓名", required = true)
    private String projectManagerName;

    @ApiModelProperty(value = "启动日期", example = "2024-01-01", required = true)
    private LocalDate initiationDate;

    @ApiModelProperty(value = "预计结束日期", example = "2024-12-31")
    private LocalDate estimatedEndDate;

    @ApiModelProperty(value = "项目预算")
    private Double budget;

    @ApiModelProperty(value = "项目成员列表")
    private List<String> teamMembers;

    // 其他启动时需要的信息
}