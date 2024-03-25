package com.tg.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

// TODO:
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "项目详情展示对象")
public class ProjectDetailVO {

    @ApiModelProperty("项目ID")
    private Long id;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("所属部门")
    private String department;

    @ApiModelProperty("项目状态")
    private String status;

    @ApiModelProperty("预算")
    private Double budget;

    @ApiModelProperty("项目开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("项目结束时间")
    private LocalDateTime endTime;

    // 其他字段根据实际情况添加
}
