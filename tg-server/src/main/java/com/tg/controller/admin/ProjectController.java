package com.tg.controller.admin;

import com.tg.dto.ProjectCreationDTO;
import com.tg.dto.ProjectPageQueryDTO;
import com.tg.dto.ProjectUpdateDTO;
import com.tg.dto.ProjectUpdateStatusDTO;
import com.tg.entity.Project;
import com.tg.result.PageResult;
import com.tg.result.Result;
import com.tg.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/projects")
@Api(tags = "项目相关接口")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 新增项目
     * @param projectCreationDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增项目")
    public Result<Project> createProject(@RequestBody ProjectCreationDTO projectCreationDTO) {
        log.info("开始创建项目，项目名称：{}", projectCreationDTO.getProjectName());
        Project project = projectService.createProject(projectCreationDTO);
        log.info("项目创建成功，项目ID：{}", project.getId());
        return Result.success(project);
    }

    /**
     * 根据ID查询项目信息
     * @param projectNumber
     * @return
     */
    @GetMapping("/number/{projectNumber}")
    @ApiOperation("根据项目编号查询项目信息")
    public Result<Project> getByProjectNumber(@PathVariable Integer projectNumber) {
        log.info("根据项目编号获取项目信息，项目ID：{}", projectNumber);
        Project project = projectService.getByProjectNumber(projectNumber);
        if (project == null) {
            log.warn("项目项目编号：{} 的项目未找到", projectNumber);
            return Result.error("项目未找到");
        }
        return Result.success(project);
    }

    /**
     * 根据名称查询项目信息
     * @param projectName
     * @return
     */
    @GetMapping("/name/{projectName}")
    @ApiOperation("根据项目名称查询项目信息")
    public Result<List<Project>> getByProjectName(@PathVariable String projectName) {
        log.info("根据项目名称获取项目信息，项目名称：{}", projectName);
        List<Project> projects = projectService.getByProjectName(projectName);
        if (projects == null || projects.isEmpty()) {
            log.warn("项目项目名称：{} 的项目未找到", projectName);
            return Result.error("项目未找到");
        }
        return Result.success(projects);
    }


    /**
     * 编辑项目信息
     * @param projectUpdateDTO
     * @return
     */
    @PutMapping("/updateInfo")
    @ApiOperation("编辑项目信息")
    public Result<Project> updateProject(@RequestBody ProjectUpdateDTO projectUpdateDTO) {
        log.info("开始更新项目信息，项目编号：{}", projectUpdateDTO.getProjectNumber());
        Project updatedProject = projectService.updateProject(projectUpdateDTO);
        log.info("项目信息更新成功，项目ID：{}", updatedProject.getId());
        return Result.success(updatedProject);
    }

    @PutMapping("/updateStatus")
    @ApiOperation("更新项目状态")
    public Result<Project> updateProjectStatus(@RequestBody ProjectUpdateStatusDTO projectUpdateStatusDTO) {
        log.info("开始更新项目信息，项目编号：{}", projectUpdateStatusDTO.getProjectNumber());
        Project updatedProjectStatus = projectService.updateProjectStatus(projectUpdateStatusDTO);
        log.info("项目信息更新成功，项目ID：{}", updatedProjectStatus.getId());
        return Result.success(updatedProjectStatus);
    }

    /**
     * 删除项目
     * @param projectNumber
     * @return
     */
    @DeleteMapping("/{projectNumber}")
    @ApiOperation("删除项目")
    public Result<Void> deleteProject(@PathVariable Integer projectNumber) {
        log.info("开始删除项目，项目编号：{}", projectNumber);
        projectService.deleteProject(projectNumber);
        log.info("项目删除成功，项目编号：{}", projectNumber);
        return Result.success();
    }

    /**
     * 项目分页查询
     * @param projectPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("项目分页查询")
    public Result<PageResult> pageQuery(ProjectPageQueryDTO projectPageQueryDTO) {
        log.info("开始进行项目分页查询，页码：{}，每页数量：{}", projectPageQueryDTO.getPageNumber(), projectPageQueryDTO.getPageSize());
        PageResult pageResult = projectService.pageQuery(projectPageQueryDTO);
        log.info("项目分页查询成功，总项目数：{}", pageResult.getTotal());
        return Result.success(pageResult);
    }

    /**
     * 列出所有项目
     * @return
     */
    @GetMapping("/listAll")
    @ApiOperation("列出所有项目")
    public Result<List<Project>> listAllProjects() {
        log.info("开始列出所有项目");
        List<Project> projects = projectService.listAllProjects();
        log.info("成功列出所有项目，总数：{}", projects.size());
        return Result.success(projects);
    }
}