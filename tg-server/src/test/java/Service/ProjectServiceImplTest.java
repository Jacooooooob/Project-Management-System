package Service;

import com.tg.dto.ProjectCreationDTO;
import com.tg.dto.ProjectUpdateDTO;
import com.tg.entity.Project;
import com.tg.mapper.ProjectMapper;
import com.tg.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {

    @Mock
    private ProjectMapper projectMapper;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Project project;
    private ProjectCreationDTO projectCreationDTO;

    @BeforeEach
    public void setUp() {
        // 只设置通用的对象，不设置存根
        projectCreationDTO = ProjectCreationDTO.builder()
                .projectName("Test Project")
                .department(1)
                .projectCategory(1)
                .projectType(1)
                .budget(BigDecimal.valueOf(1000.0))
                .build();

        project = Project.builder()
//                .id(1L)
                .projectName("Test Project")
                .department(1)
                .projectCategory(1)
                .projectType(1)
                .budget(projectCreationDTO.getBudget())
//                .createTime(LocalDateTime.now())
//                .updateTime(LocalDateTime.now())
//                .createUser(1L)
//                .updateUser(1L)
                .build();
    }

    @Test
    public void createProjectTest() {
        // Act
        Project createdProject = projectService.createProject(projectCreationDTO);

        // Assert
//        assertThat(createdProject.getId()).isEqualTo(1L);
        assertThat(createdProject.getProjectName()).isEqualTo("Test Project");
        assertThat(createdProject.getDepartment()).isEqualTo(1);
        assertThat(createdProject.getProjectCategory()).isEqualTo(1);
        assertThat(createdProject.getProjectType()).isEqualTo(1);
        assertThat(createdProject.getBudget()).isEqualByComparingTo(BigDecimal.valueOf(1000.0));

        // Verify
        verify(projectMapper).insert(any(Project.class));
    }

    @Test
    public void getByProjectNumberTest() {
        // Ensure 'project' is instantiated correctly before this line
        project = new Project(); // Assuming there's a default constructor
        project.setProjectNumber(1); // And any other necessary initialization

        // Arrange
        when(projectMapper.getByProjectNumber(1)).thenReturn(project);

        // Act
        Project foundProject = projectService.getByProjectNumber(1);

        // Assert
        assertThat(foundProject).isNotNull();
        assertThat(foundProject.getProjectNumber()).isEqualTo(1);

        // Verify
        verify(projectMapper).getByProjectNumber(1);
    }


    @Test
    public void updateProjectTest() {
        // Arrange
        ProjectUpdateDTO projectUpdateDTO = ProjectUpdateDTO.builder()
                .projectNumber(1) // Assuming projectNumber is used as the identifier
                .projectName("Updated Project Name")
                .department(1) // Assuming department is identified by an integer ID
                .manager(1) // Similarly for manager
                .projectCategory(1) // Similarly for projectCategory
                .projectType(1) // Similarly for projectType
                .budget(new BigDecimal("2000.0")) // Use BigDecimal directly
                .productType(1) // Similarly for productType
                .productName("New Product Name") // Adding productName
                .industry(1) // Similarly for industry
                .attachment(new byte[0]) // Assuming it's an empty byte array for the sake of the test
                .build();

        Project updatedProjectStub = new Project();
        updatedProjectStub.setProjectNumber(projectUpdateDTO.getProjectNumber());
        updatedProjectStub.setProjectName(projectUpdateDTO.getProjectName());
        updatedProjectStub.setDepartment(projectUpdateDTO.getDepartment());
        updatedProjectStub.setProjectType(projectUpdateDTO.getProjectType());
        updatedProjectStub.setProjectCategory(projectUpdateDTO.getProjectCategory());
        updatedProjectStub.setBudget(projectUpdateDTO.getBudget());

        when(projectMapper.getByProjectNumber(1)).thenReturn(updatedProjectStub);
        doNothing().when(projectMapper).update(any(Project.class));

        // Act
        projectService.updateProject(projectUpdateDTO);

        // Assert
        Project updatedProject = projectMapper.getByProjectNumber(1);
        assertThat(updatedProject.getProjectName()).isEqualTo("Updated Project Name");
        assertThat(updatedProject.getDepartment()).isEqualTo(1);
        assertThat(updatedProject.getProjectType()).isEqualTo(1);
        assertThat(updatedProject.getProjectCategory()).isEqualTo(1);
        assertThat(updatedProject.getBudget()).isEqualTo(BigDecimal.valueOf(2000.0));

        // Verify
        verify(projectMapper).update(any(Project.class));
    }


    @Test
    public void deleteProjectTest() {
        // Arrange
        Integer projectId = 1;
        doNothing().when(projectMapper).delete(projectId);

        // Act
        projectService.deleteProject(projectId);

        // Assert
        verify(projectMapper).delete(projectId);
    }

    @Test
    public void listAllProjectsTest() {
        // Arrange
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        when(projectMapper.findAll()).thenReturn(projects);

        // Act
        List<Project> foundProjects = projectService.listAllProjects();

        // Assert
        assertThat(foundProjects).isNotNull();
        assertThat(foundProjects.size()).isEqualTo(1);
        verify(projectMapper).findAll();
    }

}
