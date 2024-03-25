package com.tg.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class ProjectPageQueryDTO implements Serializable{

    // 项目姓名可以为空，如果是非空搜索，可以添加@NotBlank注解
    private String projectName;

    @Min(value = 1, message = "页码必须是正数")
    private int pageNumber;

    @Min(value = 1, message = "每页记录数至少为1")
    private int pageSize;
}
