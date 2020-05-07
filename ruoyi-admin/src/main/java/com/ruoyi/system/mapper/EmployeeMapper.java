package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Employee;

/**
 * 仓储管理系统的员工的管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface EmployeeMapper 
{
    /**
     * 查询仓储管理系统的员工的管理
     * 
     * @param id 仓储管理系统的员工的管理ID
     * @return 仓储管理系统的员工的管理
     */
    public Employee selectEmployeeById(Long id);

    /**
     * 查询仓储管理系统的员工的管理列表
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 仓储管理系统的员工的管理集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增仓储管理系统的员工的管理
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改仓储管理系统的员工的管理
     * 
     * @param employee 仓储管理系统的员工的管理
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除仓储管理系统的员工的管理
     * 
     * @param id 仓储管理系统的员工的管理ID
     * @return 结果
     */
    public int deleteEmployeeById(Long id);

    /**
     * 批量删除仓储管理系统的员工的管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeByIds(String[] ids);
}
