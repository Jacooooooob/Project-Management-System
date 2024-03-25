package Mapper;

import com.tg.InitiateProjectApplication;
import com.tg.entity.Employee;

import com.tg.mapper.EmployeeMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;


import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {InitiateProjectApplication.class})
@Transactional
@Rollback(value = true) // 根据需要选择回滚或提交
public class EmployeeMapperTest {

    @MockBean
    private ServerEndpointExporter serverEndpointExporter;

    @Autowired
    private EmployeeMapper employeeMapper;

    private Employee testEmployee;

    @BeforeEach
    public void setUp() {
        testEmployee = new Employee();
        testEmployee.setName(1);
        testEmployee.setUsername("test");
        testEmployee.setPassword("test");
        testEmployee.setDepartment(1);

        employeeMapper.insert(testEmployee);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setName(1);
        employee.setUsername("test");
        employee.setPassword("test");
        employee.setDepartment(1);

        employeeMapper.insert(employee);
        assertThat(employee.getId()).isNotNull(); // TODO
    }

    @Test
    public void testGetById() {
        Integer id = 1;
        Employee employee = employeeMapper.getById(id);
        assertThat(employee).isNotNull();
        assertThat(employee.getId()).isEqualTo(id);
    }

    @Test
    public void testUpdate() {
        testEmployee.setUsername("更新后的用户名");
        employeeMapper.update(testEmployee);

        Employee updatedEmployee = employeeMapper.getByUsername(testEmployee.getUsername());
        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getUsername()).isEqualTo("更新后的用户名");
    }

    @Test
    public void testDelete() {
        Integer id = 3; // 假设这是您想要删除的项目编号
        employeeMapper.delete(id);
        Employee employee = employeeMapper.getById(id);
        assertThat(employee).isNull();
    }

    @Test
    public void testGetByUsername() {
        String username = "test";
        Employee employee = employeeMapper.getByUsername(username);
        assertThat(employee).isNotNull();
        assertThat(employee.getUsername()).isEqualTo(username);
    }


}
