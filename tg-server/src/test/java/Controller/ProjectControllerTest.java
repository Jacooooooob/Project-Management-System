package Controller;

import com.tg.controller.admin.ProjectController;
import com.tg.dto.ProjectCreationDTO;
import com.tg.entity.Project;
import com.tg.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// TODO:
@WebMvcTest(ProjectController.class)
@ContextConfiguration(classes = {ProjectController.class, ProjectService.class})
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Test
    public void testCreateProject() throws Exception {
        ProjectCreationDTO projectCreationDTO = new ProjectCreationDTO();
        projectCreationDTO.setProjectName("Test Project");
        projectCreationDTO.setManager(2);

        Mockito.when(projectService.createProject(Mockito.any(ProjectCreationDTO.class))).thenReturn(new Project());

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"projectName\":\"Test Project\",\"description\":\"Test Description\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // TODO: Test update project
}
