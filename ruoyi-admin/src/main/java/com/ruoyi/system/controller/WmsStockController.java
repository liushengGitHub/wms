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
import com.ruoyi.system.domain.WmsStock;
import com.ruoyi.system.service.IWmsStockService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/stock")
public class WmsStockController extends BaseController
{
    private String prefix = "system/stock";

    @Autowired
    private IWmsStockService wmsStockService;

    @RequiresPermissions("system:stock:view")
    @GetMapping()
    public String stock()
    {
        return prefix + "/stock";
    }

    /**
     * 查询库存列表
     */
    @RequiresPermissions("system:stock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsStock wmsStock)
    {
        startPage();
        List<WmsStock> list = wmsStockService.selectWmsStockList(wmsStock);
        return getDataTable(list);
    }

    /**
     * 导出库存列表
     */
    @RequiresPermissions("system:stock:export")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsStock wmsStock)
    {
        List<WmsStock> list = wmsStockService.selectWmsStockList(wmsStock);
        ExcelUtil<WmsStock> util = new ExcelUtil<WmsStock>(WmsStock.class);
        return util.exportExcel(list, "stock");
    }

    /**
     * 新增库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存
     */
    @RequiresPermissions("system:stock:add")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsStock wmsStock)
    {
        return toAjax(wmsStockService.insertWmsStock(wmsStock));
    }

    /**
     * 修改库存
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WmsStock wmsStock = wmsStockService.selectWmsStockById(id);
        mmap.put("wmsStock", wmsStock);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存
     */
    @RequiresPermissions("system:stock:edit")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsStock wmsStock)
    {
        return toAjax(wmsStockService.updateWmsStock(wmsStock));
    }

    /**
     * 删除库存
     */
    @RequiresPermissions("system:stock:remove")
    @Log(title = "库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wmsStockService.deleteWmsStockByIds(ids));
    }
}
