package com.tg.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

// TODO:
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "项目更新状态时传递的数据模型")
public class ProjectUpdateStatusDTO {

    @NotNull(message = "项目编号不能为空")
    @Positive(message = "项目编号必须是正数")
    @ApiModelProperty("项目编号")
    private Integer projectNumber;

    @NotNull(message = "项目状态不能为空")
    @Positive(message = "项目状态必须是正数")
    @ApiModelProperty("项目状态")
    private Integer projectStatus;
}

