package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库单Controller
 *
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/OutOrder")
public class WmsOutOrderController extends BaseController {
    private String prefix = "system/OutOrder";
    @Autowired
    private IWmsInOrderService wmsInOrderService;

    @Autowired
    private IWmsBaseGoodsService baseGoodsService;
    @Autowired
    private IWmsSupplierService supplierService;
    @Autowired
    private IWmsBaseWarehouseService baseWarehouseService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IWmsOutOrderService wmsOutOrderService;

    @Autowired
    private IWmsCustomerService customerService;
    @Autowired
    private IWmsStockService wmsStockService;

    /*@RequiresPermissions("system:OutOrder:view")*/
    @GetMapping()
    public String OutOrder() {
        return prefix + "/OutOrder";
    }

    /**
     * 查询出库单列表
     */
    /*@RequiresPermissions("system:OutOrder:list")*/
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsOutOrder wmsOutOrder) {
        startPage();
        List<WmsOutOrder> list = getWmsOutOrders(wmsOutOrder);
        return getDataTable(list);
    }

    private List<WmsOutOrder> getWmsOutOrders(WmsOutOrder wmsOutOrder) {

        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Long operateId = user.getOperateId();
        Long roleId = getRoleId(user);
        if (Objects.nonNull(operateId) && Objects.nonNull(roleId) && roleId == 101) {
            WmsCustomer wmsCustomer = customerService.selectWmsCustomerById(operateId);
            wmsOutOrder.setCustomerName(wmsCustomer.getName());
        }
        return wmsOutOrderService.selectWmsOutOrderList(wmsOutOrder);
    }

    /**
     * 导出出库单列表
     */
    /*@RequiresPermissions("system:OutOrder:export")*/
    @Log(title = "出库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsOutOrder wmsOutOrder) {

        List<WmsOutOrder> list = getWmsOutOrders(wmsOutOrder);
        ExcelUtil<WmsOutOrder> util = new ExcelUtil<WmsOutOrder>(WmsOutOrder.class);
        return util.exportExcel(list, "OutOrder");
    }

    /**
     * 新增出库单
     */
    @GetMapping("/add")
    public String add(Model model) {
        putData(model);
        return prefix + "/add";
    }

    /**
     * 新增保存出库单
     */
    /*@RequiresPermissions("system:OutOrder:add")*/
    @Log(title = "出库单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsOutOrder wmsOutOrder) {
        wmsOutOrder.setOrderNo(UUID.randomUUID().toString());
        WmsStock wmsStock = convert(wmsOutOrder);
        List<WmsStock> stockList = wmsStockService.selectWmsStockList(wmsStock);
        if (stockList.isEmpty()) {
            return error("货物数量不足  0");
        } else {
            WmsStock stock = stockList.get(0);
            long number = stock.getNumber() - wmsOutOrder.getNumber();
            if (number < 0) {
                return error("货物数量不足 " + stock.getNumber());
            }
            stock.setNumber(number);
            wmsStockService.updateWmsStock(stock);
        }
        return toAjax(wmsOutOrderService.insertWmsOutOrder(wmsOutOrder));
    }

    private WmsStock convert(WmsOutOrder wmsOutOrder) {
        String goodsName = wmsOutOrder.getGoodsName();
        String warehonseName = wmsOutOrder.getWarehonseName();
        WmsStock wmsStock = new WmsStock();
        wmsStock.setGoodsName(goodsName);
        wmsStock.setWarehonseName(warehonseName);
        return wmsStock;
    }


    private void putData(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Long operateId = user.getOperateId();
        Long roleId = getRoleId(user);
        List<WmsStock> wmsStocks = wmsStockService.selectWmsStockList(new WmsStock());
        List<WmsCustomer> wmsSuppliers = null;
        if ( Objects.nonNull(roleId) && roleId == 101) {
            wmsSuppliers = Arrays.asList(customerService.selectWmsCustomerById(operateId));
        } else {
            wmsSuppliers = customerService.selectWmsCustomerList(new WmsCustomer());
        }
        List<WmsBaseWarehouse> warehouses = baseWarehouseService.selectWmsBaseWarehouseList(new WmsBaseWarehouse());
        List<Employee> employees = iEmployeeService.selectEmployeeList(new Employee());
        model.addAttribute("stocks", wmsStocks);
        model.addAttribute("suppliers", wmsSuppliers);
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("employees", employees);
    }
    private Long getRoleId(SysUser user) {
        if (user.getRoleId() == null) {
            List<SysRole> roles = user.getRoles();

            if (Objects.isNull(roles) || roles.isEmpty()) return null;

            return roles.get(0).getRoleId();
        }
        return user.getRoleId();
    }
    /**
     * 修改出库单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap, Model model) {
        WmsOutOrder wmsOutOrder = wmsOutOrderService.selectWmsOutOrderById(id);
        mmap.put("wmsOutOrder", wmsOutOrder);
        putData(model);
        return prefix + "/edit";
    }

    /**
     * 修改保存出库单
     */
    /*@RequiresPermissions("system:OutOrder:edit")*/
    @Log(title = "出库单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsOutOrder wmsOutOrder) {

        return toAjax(wmsOutOrderService.updateWmsOutOrder(wmsOutOrder));
    }

    /**
     * 删除出库单
     */
   /* @RequiresPermissions("system:OutOrder:remove")*/
    @Log(title = "出库单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wmsOutOrderService.deleteWmsOutOrderByIds(ids));
    }
}
