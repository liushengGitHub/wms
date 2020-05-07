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
import com.ruoyi.system.domain.WmsCustomer;
import com.ruoyi.system.service.IWmsCustomerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/customer")
public class WmsCustomerController extends BaseController
{
    private String prefix = "system/customer";

    @Autowired
    private IWmsCustomerService wmsCustomerService;

    @RequiresPermissions("system:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询客户列表
     */
    @RequiresPermissions("system:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsCustomer wmsCustomer)
    {
        startPage();
        List<WmsCustomer> list = wmsCustomerService.selectWmsCustomerList(wmsCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @RequiresPermissions("system:customer:export")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsCustomer wmsCustomer)
    {
        List<WmsCustomer> list = wmsCustomerService.selectWmsCustomerList(wmsCustomer);
        ExcelUtil<WmsCustomer> util = new ExcelUtil<WmsCustomer>(WmsCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 新增客户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户
     */
    @RequiresPermissions("system:customer:add")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsCustomer wmsCustomer)
    {
        return toAjax(wmsCustomerService.insertWmsCustomer(wmsCustomer));
    }

    /**
     * 修改客户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WmsCustomer wmsCustomer = wmsCustomerService.selectWmsCustomerById(id);
        mmap.put("wmsCustomer", wmsCustomer);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户
     */
    @RequiresPermissions("system:customer:edit")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsCustomer wmsCustomer)
    {
        return toAjax(wmsCustomerService.updateWmsCustomer(wmsCustomer));
    }

    /**
     * 删除客户
     */
    @RequiresPermissions("system:customer:remove")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wmsCustomerService.deleteWmsCustomerByIds(ids));
    }
}
