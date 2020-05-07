package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.service.IEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓储管理系统的员工的管理Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/employee")
public class EmployeeController extends BaseController
{
    private String prefix = "system/employee";

    @Autowired
    private IEmployeeService employeeService;

    @RequiresPermissions("system:employee:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }

    /**
     * 查询仓储管理系统的员工的管理列表
     */
    @RequiresPermissions("system:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Employee employee)
    {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 导出仓储管理系统的员工的管理列表
     */
    @RequiresPermissions("system:employee:export")
    @Log(title = "仓储管理系统的员工的管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Employee employee)
    {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增仓储管理系统的员工的管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓储管理系统的员工的管理
     */
    @RequiresPermissions("system:employee:add")
    @Log(title = "仓储管理系统的员工的管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Employee employee)
    {
        return toAjax(employeeService.insertEmployee(employee));
    }

    /**
     * 修改仓储管理系统的员工的管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Employee employee = employeeService.selectEmployeeById(id);
        mmap.put("employee", employee);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓储管理系统的员工的管理
     */
    @RequiresPermissions("system:employee:edit")
    @Log(title = "仓储管理系统的员工的管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Employee employee)
    {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除仓储管理系统的员工的管理
     */
    @RequiresPermissions("system:employee:remove")
    @Log(title = "仓储管理系统的员工的管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(employeeService.deleteEmployeeByIds(ids));
    }
}
