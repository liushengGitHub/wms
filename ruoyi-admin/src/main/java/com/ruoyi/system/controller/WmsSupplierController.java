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
import com.ruoyi.system.domain.WmsSupplier;
import com.ruoyi.system.service.IWmsSupplierService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/supplier")
public class WmsSupplierController extends BaseController
{
    private String prefix = "system/supplier";

    @Autowired
    private IWmsSupplierService wmsSupplierService;

    @RequiresPermissions("system:supplier:view")
    @GetMapping()
    public String supplier()
    {
        return prefix + "/supplier";
    }

    /**
     * 查询供应商列表
     */
    @RequiresPermissions("system:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsSupplier wmsSupplier)
    {
        startPage();
        List<WmsSupplier> list = wmsSupplierService.selectWmsSupplierList(wmsSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @RequiresPermissions("system:supplier:export")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsSupplier wmsSupplier)
    {
        List<WmsSupplier> list = wmsSupplierService.selectWmsSupplierList(wmsSupplier);
        ExcelUtil<WmsSupplier> util = new ExcelUtil<WmsSupplier>(WmsSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增供应商
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商
     */
    @RequiresPermissions("system:supplier:add")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsSupplier wmsSupplier)
    {
        return toAjax(wmsSupplierService.insertWmsSupplier(wmsSupplier));
    }

    /**
     * 修改供应商
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WmsSupplier wmsSupplier = wmsSupplierService.selectWmsSupplierById(id);
        mmap.put("wmsSupplier", wmsSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商
     */
    @RequiresPermissions("system:supplier:edit")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsSupplier wmsSupplier)
    {
        return toAjax(wmsSupplierService.updateWmsSupplier(wmsSupplier));
    }

    /**
     * 删除供应商
     */
    @RequiresPermissions("system:supplier:remove")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wmsSupplierService.deleteWmsSupplierByIds(ids));
    }
}
