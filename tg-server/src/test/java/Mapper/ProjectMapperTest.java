package Mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tg.InitiateProjectApplication;
import com.tg.dto.ProjectPageQueryDTO;
import com.tg.entity.Project;
import com.tg.mapper.ProjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {InitiateProjectApplication.class})
@Transactional
@Rollback(value = true) // 根据需要选择回滚或提交
public class ProjectMapperTest {

    @MockBean
    private ServerEndpointExporter serverEndpointExporter;

    @Autowired
    private ProjectMapper projectMapper;

    private Project testProject;

    @BeforeEach
    public void setUp() {
        testProject = new Project();
        testProject.setProjectNumber(1001);
        testProject.setProjectName("测试项目");
        testProject.setDepartment(1);
        testProject.setManager(1);
        testProject.setProjectCategory(1);
        testProject.setProjectType(1);
        testProject.setBudget(new BigDecimal("1000.0"));
        testProject.setProductType(1);
        testProject.setProductName("测试产品");
        testProject.setProductNumber(1);
        testProject.setIndustry(1);
        testProject.setAttachment(new byte[]{});
        testProject.setProjectStatus(1);

        projectMapper.insert(testProject);
    }

    @Test
    public void testInsert() {
        Project project = new Project();
        project.setProjectNumber(1001);
        project.setProjectName("测试项目");
        project.setDepartment(2);
        project.setManager(2);
        project.setProjectCategory(2);
        project.setProjectType(2);
        project.setBudget(new BigDecimal("2000.0"));
        project.setProductType(2);
        project.setProductName("测试产品");
        project.setProductNumber(2);
        project.setIndustry(2);
        project.setAttachment(new byte[]{});
        project.setProjectStatus(2);

        projectMapper.insert(project);

        assertThat(project.getId()).isNotNull();
    }

    @Test
    public void testFindByProjectNumber() {
        Integer projectNumber = 1001; // 假设这是您已经插入的测试数据中的项目编号
        Project project = projectMapper.getByProjectNumber(projectNumber);
        assertThat(project).isNotNull();
        assertThat(project.getProjectNumber()).isEqualTo(projectNumber);
    }

    @Test
    public void testFindByProjectName() {
        String projectName = "测试项目"; // 假设这是您已经插入的测试数据中的项目名称
        Project project = projectMapper.getByProjectName(projectName);
        assertThat(project).isNotNull();
        assertThat(project.getProjectName()).isEqualTo(projectName);
    }

    @Test
    public void testUpdate() {
        testProject.setProjectName("更新后的项目名称");
        projectMapper.update(testProject);

        Project updatedProject = projectMapper.getByProjectNumber(testProject.getProjectNumber());
        assertThat(updatedProject).isNotNull();
        assertThat(updatedProject.getProjectName()).isEqualTo("更新后的项目名称");
    }

    @Test
    public void testDelete() {
        Integer projectNumber = 1001; // 假设这是您想要删除的项目编号
        projectMapper.delete(projectNumber);
        Project project = projectMapper.getByProjectNumber(projectNumber);
        assertThat(project).isNull();
    }

    // TODO:
    @Test
    public void testPageQuery() {
        // Assume that PageHelper is configured properly.
        // Start paging. Note: Page numbers are 1-based.
        PageHelper.startPage(1, 10);
        ProjectPageQueryDTO queryDTO = new ProjectPageQueryDTO();
        queryDTO.setProjectName("测试项目"); // Set the project name filter

        // The actual search
        List<Project> projects = projectMapper.pageQuery(queryDTO);
        PageInfo<Project> pageInfo = new PageInfo<>(projects);

        // Assert that we have retrieved results
        assertThat(pageInfo.getList()).isNotEmpty();
    }


}
