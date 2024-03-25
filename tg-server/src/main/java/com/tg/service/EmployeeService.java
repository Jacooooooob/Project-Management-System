package com.tg.service;

import com.tg.dto.EmployeeDTO;
import com.tg.dto.EmployeeLoginDTO;
import com.tg.entity.Employee;

public interface EmployeeService {
    /**
     * 员工登录
     * @param employeeLoginDTO 登录信息DTO
     * @return 登录成功的员工信息，如果登录失败返回null
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

//    /**
//     * 员工退出
//     * @param id 员工ID
//     */
//    void logout(Integer id);

    /**
     * 根据ID查询员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    Employee getEmployeeById(Integer id);

    /**
     * 添加员工
     * @param employeeDTO 员工信息
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 修改员工信息
     * @param employeeDTO 员工信息
     */
    void updateEmployee(EmployeeDTO employeeDTO);
//
//    /**
//     * 删除员工
//     * @param id 员工ID
//     */
//    void removeEmployee(Integer id);
}
