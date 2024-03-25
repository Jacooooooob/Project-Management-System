package com.tg.dto;

import lombok.*;
import javax.validation.constraints.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "员工数据传递的数据模型")
public class EmployeeDTO {

    @NotNull(message = "主键值不能为空")
    @Positive(message = "主键值必须是正数")
    @ApiModelProperty("员工ID")
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    @Positive(message = "姓名标识必须是正数")
    @ApiModelProperty("姓名")
    private Integer name;

    @NotNull(message = "用户名不能为空")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @NotNull(message = "责任部门不能为空")
    @Positive(message = "责任部门标识必须是正数")
    @ApiModelProperty("责任部门")
    private Integer department;

    @NotNull(message = "密码不能为空")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

}
