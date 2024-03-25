package com.tg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
@ApiModel(description = "项目")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("项目ID")
    private Integer id;

    @Column(name = "project_number", nullable = false)
    @ApiModelProperty("项目编号")
    private Integer projectNumber;

    @Column(name = "project_name", nullable = false)
    @ApiModelProperty("项目名称")
    private String projectName;

    // 如果department, manager等是外键引用其他表，则应该用@ManyToOne或@JoinColumn
    @Column(name = "department", nullable = false)
    @ApiModelProperty("所属部门")
    private Integer department;

    @Column(name = "manager", nullable = false)
    @ApiModelProperty("产品经理")
    private Integer manager;

    @Column(name = "project_category", nullable = false)
    @ApiModelProperty("项目类别")
    private Integer projectCategory;

    @Column(name = "project_type", nullable = false)
    @ApiModelProperty("项目类型")
    private Integer projectType;

    @Column(name = "budget", nullable = false, precision = 10, scale = 6)
    @ApiModelProperty("预算")
    private BigDecimal budget;

    @Column(name = "product_type", nullable = false)
    @ApiModelProperty("产品类型")
    private Integer productType;

    @Column(name = "product_name", nullable = false)
    @ApiModelProperty("产品名称")
    private String productName;

    @Column(name = "product_number", nullable = false)
    @ApiModelProperty("产品编号")
    private Integer productNumber;

    @Column(name = "industry", nullable = false)
    @ApiModelProperty("所属行业")
    private Integer industry;

    // 附件字段可能需要更复杂的处理，比如保存文件路径而不是字节内容
    @Lob
    @Column(name = "attachment")
    @ApiModelProperty("附件")
    private byte[] attachment;

    @Column(name = "projectStatus")
    @ApiModelProperty("项目状态")
    private Integer projectStatus;
}