package com.tg.service.impl;

import com.tg.constant.MessageConstant;
import com.tg.constant.PasswordConstant;
import com.tg.dto.EmployeeDTO;
import com.tg.dto.EmployeeLoginDTO;
import com.tg.entity.Employee;
import com.tg.exception.AccountNotFoundException;
import com.tg.exception.PasswordErrorException;
import com.tg.mapper.EmployeeMapper;
import com.tg.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.AccountLockedException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

//    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
//        this.employeeMapper = employeeMapper;
//    }

    /**
     * 员工登录
     *
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Employee employee = employeeMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (employee == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(employee.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //3、返回实体对象
        return employee;
    }

//    /**
//     * 员工退出
//     * @param id 员工ID
//     */
//    @Override
//    public void logout(Integer id) {
//        // 退出登录逻辑，比如清除登录状态等
//    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    // TODO:
    @Transactional(readOnly = true)
    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeMapper.getById(id);
        employee.setPassword("****");
        return employee;
    }

    // 员工信息映射表，用于存储员工的编号和对应的名字。
    // 键为员工编号，值为员工名字。
    private final ConcurrentHashMap<Integer, Employee> employees = new ConcurrentHashMap<>();

    /**
     * 添加一个员工到员工列表中。
     * 如果提供的员工对象为null，或者该员工ID已经存在于列表中，则抛出IllegalArgumentException异常。
     * @param employeeDTO 要添加的员工对象，不可为null且ID不能在列表中已存在。
     * @throws IllegalArgumentException 如果员工对象为null或员工ID已存在，则抛出此异常。
     */

    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        //对象属性拷贝
        BeanUtils.copyProperties(employeeDTO, employee);

        employee.setPassword(DigestUtils.md5DigestAsHex(employeeDTO.getPassword().getBytes()));
        // 设置密码，默认密码123456
//        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        //设置当前记录的创建时间和修改时间
        //employee.setCreateTime(LocalDateTime.now());
        //employee.setUpdateTime(LocalDateTime.now());

        //设置当前记录创建人id和修改人id
        //employee.setCreateUser(BaseContext.getCurrentId());
        //employee.setUpdateUser(BaseContext.getCurrentId());

        employeeMapper.insert(employee);
    }


    /**
     * 更新员工信息。
     * @param employeeDTO 员工信息
     */
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setPassword(DigestUtils.md5DigestAsHex(employeeDTO.getPassword().getBytes()));

        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(BaseContext.getCurrentId());

        employeeMapper.update(employee);
    }


//    /**
//     * 从员工列表中移除指定ID的员工。
//     *
//     * @param id 要移除的员工的ID。
//     * @return 如果成功移除员工返回true，如果员工ID不存在则返回false。
//     */
//    public boolean removeEmployee(Integer id) {
//        // 检查员工ID是否存在
//        if(employees.containsKey(id)) {
//            employees.remove(id); // 移除指定ID的员工
//            return true;
//        }
//        return false;
//    }

//
//    /**
//     * 获取所有员工的列表。
//     * <p>此方法不接受任何参数，返回当前实例中管理的所有员工的列表。</p>
//     *
//     * @return List<Employee> - 所有员工的列表，列表中的元素类型为Employee。
//     */
//    public List<Employee> getAllEmployees() {
//        // 通过stream方式将employees Map中的所有值（Employee对象）收集到List中并返回
//        return employees.values().stream().collect(Collectors.toList());
//    }
}
