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
import com.ruoyi.system.domain.WmsBaseWarehouse;
import com.ruoyi.system.service.IWmsBaseWarehouseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库信息Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/warehouse")
public class WmsBaseWarehouseController extends BaseController
{
    private String prefix = "system/warehouse";

    @Autowired
    private IWmsBaseWarehouseService wmsBaseWarehouseService;

    @RequiresPermissions("/system/warehouse")
    @GetMapping()
    public String warehouse()
    {
        return prefix + "/warehouse";
    }

    /**
     * 查询仓库信息列表
     */
    @RequiresPermissions("system:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsBaseWarehouse wmsBaseWarehouse)
    {
        startPage();
        List<WmsBaseWarehouse> list = wmsBaseWarehouseService.selectWmsBaseWarehouseList(wmsBaseWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @RequiresPermissions("system:warehouse:export")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsBaseWarehouse wmsBaseWarehouse)
    {
        List<WmsBaseWarehouse> list = wmsBaseWarehouseService.selectWmsBaseWarehouseList(wmsBaseWarehouse);
        ExcelUtil<WmsBaseWarehouse> util = new ExcelUtil<WmsBaseWarehouse>(WmsBaseWarehouse.class);
        return util.exportExcel(list, "warehouse");
    }

    /**
     * 新增仓库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库信息
     */
    @RequiresPermissions("system:warehouse:add")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsBaseWarehouse wmsBaseWarehouse)
    {
        return toAjax(wmsBaseWarehouseService.insertWmsBaseWarehouse(wmsBaseWarehouse));
    }

    /**
     * 修改仓库信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WmsBaseWarehouse wmsBaseWarehouse = wmsBaseWarehouseService.selectWmsBaseWarehouseById(id);
        mmap.put("wmsBaseWarehouse", wmsBaseWarehouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库信息
     */
    @RequiresPermissions("system:warehouse:edit")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsBaseWarehouse wmsBaseWarehouse)
    {
        return toAjax(wmsBaseWarehouseService.updateWmsBaseWarehouse(wmsBaseWarehouse));
    }

    /**
     * 删除仓库信息
     */
    @RequiresPermissions("system:warehouse:remove")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wmsBaseWarehouseService.deleteWmsBaseWarehouseByIds(ids));
    }
}
