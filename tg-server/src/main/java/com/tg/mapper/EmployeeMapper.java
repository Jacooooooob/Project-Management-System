package com.tg.mapper;

import com.tg.entity.Employee;
import com.tg.enumeration.OperationType;
import com.tg.annotation.AutoFill;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

//    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getById(Integer id);

//    @Insert("INSERT INTO employee (name, username, department, password) VALUES (#{name}, #{username}, #{department}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);

//    @Update("UPDATE employee SET name = #{name}, username = #{username}, department = #{department}, password = #{password} WHERE id = #{id}")
    @AutoFill(value = OperationType.UPDATE)
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void update(Employee employee);

//    @Delete("DELETE FROM employee WHERE id = #{id}")
    void delete(Integer id);

//    @Select("SELECT * FROM employee WHERE username = #{username}")
    Employee getByUsername(String username);
}
