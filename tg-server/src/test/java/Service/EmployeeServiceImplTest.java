package Service;

import com.tg.constant.MessageConstant;
import com.tg.dto.EmployeeDTO;
import com.tg.dto.EmployeeLoginDTO;
import com.tg.entity.Employee;
import com.tg.exception.AccountNotFoundException;
import com.tg.exception.PasswordErrorException;
import com.tg.mapper.EmployeeMapper;
import com.tg.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccess() {
        EmployeeLoginDTO loginDTO = new EmployeeLoginDTO();
        loginDTO.setUsername("user");
        loginDTO.setPassword("password");

        Employee employee = new Employee();
        employee.setUsername("user");
        employee.setPassword(DigestUtils.md5DigestAsHex("password".getBytes()));

        when(employeeMapper.getByUsername(eq("user"))).thenReturn(employee);

        Employee result = employeeService.login(loginDTO);

        assertNotNull(result);
        assertEquals("user", result.getUsername());
    }

    @Test
    public void testLoginFailureAccountNotFound() {
        EmployeeLoginDTO loginDTO = new EmployeeLoginDTO();
        loginDTO.setUsername("user");
        loginDTO.setPassword("password");

        when(employeeMapper.getByUsername(anyString())).thenReturn(null);

        assertThrows(AccountNotFoundException.class, () -> {
            employeeService.login(loginDTO);
        });
    }

    @Test
    public void testLoginFailurePasswordError() {
        EmployeeLoginDTO loginDTO = new EmployeeLoginDTO();
        loginDTO.setUsername("user");
        loginDTO.setPassword("wrongPassword");

        Employee employee = new Employee();
        employee.setUsername("user");
        employee.setPassword(DigestUtils.md5DigestAsHex("password".getBytes()));

        when(employeeMapper.getByUsername(eq("user"))).thenReturn(employee);

        assertThrows(PasswordErrorException.class, () -> {
            employeeService.login(loginDTO);
        });
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setUsername("testUser");
        employee.setPassword("****");

        when(employeeMapper.getById(eq(1))).thenReturn(employee);

        Employee result = employeeService.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
        assertEquals("****", result.getPassword());
    }

    @Test
    public void testAddEmployee() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .username("newUser")
                .password("password")
                .name(1) // 假定姓名是通过编号标识
                .department(1) // 假定部门也是通过编号标识
                .build();

        doNothing().when(employeeMapper).insert(any(Employee.class));

        employeeService.addEmployee(employeeDTO);

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeMapper).insert(employeeCaptor.capture());
        Employee capturedEmployee = employeeCaptor.getValue();

        assertEquals(employeeDTO.getUsername(), capturedEmployee.getUsername());
        assertNotEquals(employeeDTO.getPassword(), capturedEmployee.getPassword()); // 应该加密密码
        assertEquals(employeeDTO.getName(), capturedEmployee.getName());
        assertEquals(employeeDTO.getDepartment(), capturedEmployee.getDepartment());
    }

    @Test
    public void testUpdateEmployee() {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(1)
                .username("updatedUser")
                .password("newPassword")
                .name(2) // 假定更新后的姓名编号
                .department(2) // 假定更新后的部门编号
                .build();

        doNothing().when(employeeMapper).update(any(Employee.class));

        employeeService.updateEmployee(employeeDTO);

        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeMapper).update(employeeCaptor.capture());
        Employee capturedEmployee = employeeCaptor.getValue();

        assertEquals(employeeDTO.getId(), capturedEmployee.getId());
        assertEquals(employeeDTO.getUsername(), capturedEmployee.getUsername());
        assertNotEquals(employeeDTO.getPassword(), capturedEmployee.getPassword()); // 密码应该是加密的
        assertEquals(employeeDTO.getName(), capturedEmployee.getName());
        assertEquals(employeeDTO.getDepartment(), capturedEmployee.getDepartment());
    }

}
