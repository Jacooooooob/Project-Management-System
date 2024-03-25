package com.tg.mapper;

import com.github.pagehelper.Page;
import com.tg.annotation.AutoFill;
import com.tg.dto.ProjectPageQueryDTO;
import com.tg.entity.Project;
import org.apache.ibatis.annotations.*;
import com.tg.enumeration.OperationType;

import java.util.List;

@Mapper
public interface ProjectMapper {

    /**
     * 根据id查询项目
     * @param id
     * @return
     */
    @Select("SELECT * FROM project WHERE id = #{id}")
    Project getById(Integer id);

    /**
     * 根据项目编号查询
     * @param projectNumber
     * @return
     */
    @Select("SELECT * FROM project WHERE project_number = #{projectNumber}")
    Project getByProjectNumber(Integer projectNumber);

    /**
     * 根据项目名称查询
     * @param projectName
     * @return
     */
//    @Select("SELECT * FROM project WHERE project_name LIKE CONCAT('%', #{projectName}, '%')")
    List<Project> getByProjectName(String projectName);

    /**
     * 插入项目
     * @param project
     */
    @Insert("INSERT INTO project (project_number, project_name, department, manager, project_category, project_type, budget, product_type, product_name, product_number, industry, attachment, project_status) VALUES (#{projectNumber}, #{projectName}, #{department}, #{manager}, #{projectCategory}, #{projectType}, #{budget}, #{productType}, #{productName}, #{productNumber}, #{industry}, #{attachment}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @AutoFill(value = OperationType.INSERT)
    void insert(Project project);

    /**
     * 分页查询
     * @param projectPageQueryDTO
     * @return
     */
    Page<Project> pageQuery(ProjectPageQueryDTO projectPageQueryDTO);

    /**
     * 更新项目
     * @param project
     */
    @Update({
            "UPDATE project",
            "SET project_number = #{projectNumber},",
            "project_name = #{projectName},",
            "department = #{department},",
            "manager = #{manager},",
            "project_category = #{projectCategory},",
            "project_type = #{projectType},",
            "budget = #{budget},",
            "product_type = #{productType},",
            "product_name = #{productName},",
            "product_number = #{productNumber},",
            "industry = #{industry},",
            "attachment = #{attachment},",
            "project_status = #{projectStatus}",
            "WHERE id = #{id}"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @AutoFill(value = OperationType.UPDATE)
    void update(Project project);

    /**
     * 删除项目
     * @param projectNumber
     */
    @Delete("DELETE FROM project WHERE project_number = #{projectNumber}")
    void delete(Integer projectNumber);

    /**
     * 查询所有项目
     * @return
     */
    @Select("SELECT * FROM project")
    List<Project> findAll();

//    /**
//     * 更新项目状态
//     * @param id 项目ID
//     * @param projectStatus 新状态
//     */
//    @Update("UPDATE project SET status = #{status} WHERE id = #{projectId}")
//    void updateProjectStatus(@Param("id") Integer id, @Param("projectStatus") Integer projectStatus);
}
