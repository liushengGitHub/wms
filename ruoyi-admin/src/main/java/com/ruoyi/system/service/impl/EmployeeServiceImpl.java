package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeeMapper;
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.service.IEmployeeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓储管理系统的员工的管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService 
{
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询仓储管理系统的员工的管理
     * 
     * @param id 仓储管理系统的员工的管理ID
     * @return 仓储管理系统的员工的管理
     */
    @Override
    public Employee selectEmployeeById(Long id)
    {
        return employeeMapper.selectEmployeeById(id);
    }

    /**
     * 查询仓储管理系统的员工的管理列表
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 仓储管理系统的员工的管理
     */
    @Override
    public List<Employee> selectEmployeeList(Employee employee)
    {
        return employeeMapper.selectEmployeeList(employee);
    }

    /**
     * 新增仓储管理系统的员工的管理
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 结果
     */
    @Override
    public int insertEmployee(Employee employee)
    {
        return employeeMapper.insertEmployee(employee);
    }

    /**
     * 修改仓储管理系统的员工的管理
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 结果
     */
    @Override
    public int updateEmployee(Employee employee)
    {
        return employeeMapper.updateEmployee(employee);
    }

    /**
     * 删除仓储管理系统的员工的管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeByIds(String ids)
    {
        return employeeMapper.deleteEmployeeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓储管理系统的员工的管理信息
     * 
     * @param id 仓储管理系统的员工的管理ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeById(Long id)
    {
        return employeeMapper.deleteEmployeeById(id);
    }
}
