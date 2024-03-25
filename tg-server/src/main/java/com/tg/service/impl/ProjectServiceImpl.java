package com.tg.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tg.constant.MessageConstant;
import com.tg.context.BaseContext;
import com.tg.dto.ProjectCreationDTO;
import com.tg.dto.ProjectUpdateStatusDTO;
import com.tg.dto.ProjectPageQueryDTO;
import com.tg.dto.ProjectUpdateDTO;
import com.tg.dto.ProjectUpdateStatusDTO;
import com.tg.entity.Project;
import com.tg.exception.ProjectNotFoundException;
import com.tg.mapper.ProjectMapper;
import com.tg.result.PageResult;
import com.tg.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 新增项目
     * @param projectCreationDTO
     * @return
     */

//    @Transactional
    public Project createProject(ProjectCreationDTO projectCreationDTO) {
//        Project project = Project.builder()
//                .name(projectCreationDTO.getProjectName())
//                .department(projectCreationDTO.getDepartment())
//                .projectCategory(projectCreationDTO.getProjectCategory())
//                .projectType(projectCreationDTO.getProjectType())
//                .budget(BigDecimal.valueOf(projectCreationDTO.getBudget()))
//                .build();
//        projectMapper.insert(project);
//        return project;

        Project project = new Project();

        // 对象属性拷贝
        BeanUtils.copyProperties(projectCreationDTO, project);
//        project.setProjectName(projectCreationDTO.getProjectName());
//        project.setBudget(projectCreationDTO.getBudget());

//        // 设置当前记录的创建时间和修改时间
        project.setCreateTime(LocalDateTime.now());
        project.setUpdateTime(LocalDateTime.now());

        projectMapper.insert(project);
        return project;
    }

    /**
     * 通过ID查找项目
     * @param projectNumber
     * @return
     */

//    @Transactional(readOnly = true)
    public Project getByProjectNumber(Integer projectNumber) {
        return projectMapper.getByProjectNumber(projectNumber);
    }

    /**
     * 通过项目名称查找项目
     * @param projectName
     * @return
     */
    public List<Project> getByProjectName(String projectName) {
        // 构造模糊查询的字符串
        String searchName = "%" + projectName + "%";
        // 执行查询并返回结果列表
        return projectMapper.getByProjectName(searchName);
    }

    /**
     * 编辑项目信息
     * @param projectUpdateDTO
     * @return
     */
//    @Transactional
    public Project updateProject(ProjectUpdateDTO projectUpdateDTO) {
        Project project = projectMapper.getByProjectNumber(projectUpdateDTO.getProjectNumber());
        if (project == null) {
            throw new ProjectNotFoundException("Project with ID " + projectUpdateDTO.getProjectNumber() + " not found");
        }

        // 使用BeanUtils进行大部分属性复制，然后对特殊字段进行手动设置
        BeanUtils.copyProperties(projectUpdateDTO, project);
//        project.setBudget(projectUpdateDTO.getBudget());

        // 设置当前记录的修改时间
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.update(project);
        return project;
    }

    @Transactional
    public Project updateProjectStatus(ProjectUpdateStatusDTO projectUpdateStatusDTO) {
        // 检查项目是否存在
        Project project = projectMapper.getByProjectNumber(projectUpdateStatusDTO.getProjectNumber());
        if (project == null) {
            // 如果项目不存在，返回false
            throw new ProjectNotFoundException("Project with project number: " + projectUpdateStatusDTO.getProjectNumber() + " not found");
        }

        // 更新项目状态和更新时间
        project.setProjectStatus(projectUpdateStatusDTO.getProjectStatus());
        project.setUpdateTime(LocalDateTime.now());
        projectMapper.update(project);
        return project;
    }

    //    @Transactional(readOnly = true)
    public PageResult pageQuery(ProjectPageQueryDTO projectPageQueryDTO) {
        // SELECT FROM project limit 0, 10
        // 开始分页查询
        PageHelper.startPage(projectPageQueryDTO.getPageNumber(), projectPageQueryDTO.getPageSize());

        Page<Project> page = projectMapper.pageQuery(projectPageQueryDTO);

        long total = page.getTotal();
        List<Project> records = page.getResult();

        return new PageResult(total, records);
    }

    /**
     * 删除项目
     * @param projectId
     */

//    @Transactional
    public void deleteProject(Integer projectId) {
        projectMapper.delete(projectId);
    }

    /**
     * 列出所有项目
     * @return
     */

//    @Transactional(readOnly = true)
    public List<Project> listAllProjects() {
        return projectMapper.findAll();
    }
}
