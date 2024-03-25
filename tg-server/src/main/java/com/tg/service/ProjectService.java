package com.tg.service;

import com.tg.dto.ProjectCreationDTO;
import com.tg.dto.ProjectPageQueryDTO;
import com.tg.dto.ProjectUpdateDTO;
import com.tg.dto.ProjectUpdateStatusDTO;
import com.tg.entity.Project;
import com.tg.result.PageResult;

import java.util.List;

public interface ProjectService {
    /**
     * 新建项目
     * @param dto
     * @return
     */
    Project createProject(ProjectCreationDTO dto);

    /**
     * 根据项目编号获取项目信息
     * @param projectNumber
     * @return
     */
    Project getByProjectNumber(Integer projectNumber);

    /**
     * 根据项目名称获取项目信息
     * @param projectName
     * @return
     */
    List<Project> getByProjectName(String projectName);

    /**
     * 分页查询
     * @param projectPageQueryDTO
     * @return
     */
    PageResult pageQuery(ProjectPageQueryDTO projectPageQueryDTO);

    /**
     * 更新项目信息
     * @param projectUpdateDTO
     * @return
     */
    Project updateProject(ProjectUpdateDTO projectUpdateDTO);

    /**
     * 更新项目状态
     * @param projectUpdateStatusDTO
     * @return 更新结果
     */
    Project updateProjectStatus(ProjectUpdateStatusDTO projectUpdateStatusDTO);

    /**
     * 删除项目
     * @param projectNumber
     */
    void deleteProject(Integer projectNumber);

    /**
     * 列出所有项目
     * @return
     */
    List<Project> listAllProjects();
}
