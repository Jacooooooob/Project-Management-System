package com.tg.dto;

import lombok.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "项目更新时传递的数据模型")
public class ProjectUpdateDTO {

    @NotNull(message = "项目编号不能为空")
    @Positive(message = "项目编号必须是正数")
    @ApiModelProperty("项目编号")
    private Integer projectNumber;

    @NotBlank(message = "项目名称不能为空")
    @ApiModelProperty("项目名称")
    private String projectName;

    @NotNull(message = "责任部门不能为空")
    @Positive(message = "责任部门标识必须是正数")
    @ApiModelProperty("责任部门")
    private Integer department;

    @NotNull(message = "产品经理不能为空")
    @Positive(message = "产品经理标识必须是正数")
    @ApiModelProperty("产品经理")
    private Integer manager;

    @NotNull(message = "项目类别不能为空")
    @Positive(message = "项目类别标识必须是正数")
    @ApiModelProperty("项目类别")
    private Integer projectCategory;

    @NotNull(message = "项目类型不能为空")
    @Positive(message = "项目类型标识必须是正数")
    @ApiModelProperty("项目类型")
    private Integer projectType;

    @NotNull(message = "预算不能为空")
    @DecimalMin(value = "0.0", inclusive = false, message = "预算必须是正数")
    @ApiModelProperty("预算")
    private BigDecimal budget;

    @NotNull(message = "产品类型不能为空")
    @Positive(message = "产品类型标识必须是正数")
    @ApiModelProperty("产品类型")
    private Integer productType;

    @NotBlank(message = "产品名称不能为空")
    @ApiModelProperty("产品名称")
    private String productName;

    @NotNull(message = "产品编号不能为空")
    @Positive(message = "所属行业标识必须是正数")
    @ApiModelProperty("产品编号")
    private Integer productNumber;

    @NotNull(message = "所属行业不能为空")
    @Positive(message = "所属行业标识必须是正数")
    @ApiModelProperty("所属行业")
    private Integer industry;

    // 附件通常作为字节流处理，这里假设它是一个可选字段
    @ApiModelProperty("附件")
    private byte[] attachment;

    @ApiModelProperty("项目状态")
    @Positive(message = "所属行业标识必须是正数")
    private Integer projectStatus;
}
