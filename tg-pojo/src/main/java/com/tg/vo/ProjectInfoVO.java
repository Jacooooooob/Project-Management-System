package com.tg.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// TODO:
@ApiModel(description = "项目基础信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoVO {

    @ApiModelProperty(value = "项目ID", required = true)
    private Long id;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "项目类别")
    private String projectCategory;

    // 其他项目相关信息
}
