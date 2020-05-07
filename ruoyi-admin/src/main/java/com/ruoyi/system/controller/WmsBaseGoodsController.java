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
import com.ruoyi.system.domain.WmsBaseGoods;
import com.ruoyi.system.service.IWmsBaseGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货物基础信息Controller
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/goods")
public class WmsBaseGoodsController extends BaseController
{
    private String prefix = "system/goods";

    @Autowired
    private IWmsBaseGoodsService wmsBaseGoodsService;

    @RequiresPermissions("system:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询货物基础信息列表
     */
    @RequiresPermissions("system:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsBaseGoods wmsBaseGoods)
    {
        startPage();
        List<WmsBaseGoods> list = wmsBaseGoodsService.selectWmsBaseGoodsList(wmsBaseGoods);
        return getDataTable(list);
    }

    /**
     * 导出货物基础信息列表
     */
    @RequiresPermissions("system:goods:export")
    @Log(title = "货物基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsBaseGoods wmsBaseGoods)
    {
        List<WmsBaseGoods> list = wmsBaseGoodsService.selectWmsBaseGoodsList(wmsBaseGoods);
        ExcelUtil<WmsBaseGoods> util = new ExcelUtil<WmsBaseGoods>(WmsBaseGoods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 新增货物基础信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存货物基础信息
     */
    @RequiresPermissions("system:goods:add")
    @Log(title = "货物基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsBaseGoods wmsBaseGoods)
    {
        return toAjax(wmsBaseGoodsService.insertWmsBaseGoods(wmsBaseGoods));
    }

    /**
     * 修改货物基础信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WmsBaseGoods wmsBaseGoods = wmsBaseGoodsService.selectWmsBaseGoodsById(id);
        mmap.put("wmsBaseGoods", wmsBaseGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存货物基础信息
     */
    @RequiresPermissions("system:goods:edit")
    @Log(title = "货物基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsBaseGoods wmsBaseGoods)
    {
        return toAjax(wmsBaseGoodsService.updateWmsBaseGoods(wmsBaseGoods));
    }

    /**
     * 删除货物基础信息
     */
    @RequiresPermissions("system:goods:remove")
    @Log(title = "货物基础信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wmsBaseGoodsService.deleteWmsBaseGoodsByIds(ids));
    }
}
