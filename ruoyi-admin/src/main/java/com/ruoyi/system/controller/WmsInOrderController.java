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

import javax.servlet.http.HttpSession;

/**
 * 入库单Controller
 *
 * @author ruoyi
 * @date 2020-04-04
 */
@Controller
@RequestMapping("/system/InOrder")
public class WmsInOrderController extends BaseController {
    private String prefix = "system/InOrder";

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

  /*  @RequiresPermissions("system:InOrder:view")*/
    @GetMapping()
    public String InOrder() {
        return prefix + "/InOrder";
    }

    @Autowired
    private IWmsStockService wmsStockService;

    /**
     * 查询入库单列表
     */
  /*  @RequiresPermissions("system:InOrder:list")*/
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WmsInOrder wmsInOrder) {
        startPage();
        List<WmsInOrder> list = getWmsInOrders(wmsInOrder);
        return getDataTable(list);
    }

    private List<WmsInOrder> getWmsInOrders(WmsInOrder wmsInOrder) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Long operateId = user.getOperateId();
        Long roleId = getRoleId(user);
        if (Objects.nonNull(operateId) && Objects.nonNull(roleId) && roleId == 100) {
            WmsSupplier wmsSupplier = supplierService.selectWmsSupplierById(operateId);
            wmsInOrder.setSupplierName(wmsSupplier.getName());
        }
        return wmsInOrderService.selectWmsInOrderList(wmsInOrder);
    }

    /**
     * 导出入库单列表
     */
  /*  @RequiresPermissions("system:InOrder:export")*/
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WmsInOrder wmsInOrder) {
        List<WmsInOrder> list = getWmsInOrders(wmsInOrder);
        ExcelUtil<WmsInOrder> util = new ExcelUtil<WmsInOrder>(WmsInOrder.class);
        return util.exportExcel(list, "InOrder");
    }

    /**
     * 新增入库单
     */
    @GetMapping("/add")
    public String add(Model model) {
        putData(model);
        return prefix + "/add";
    }

    private void putData(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Long operateId = user.getOperateId();
        Long roleId = getRoleId(user);

        List<WmsBaseGoods> wmsBaseGoods = baseGoodsService.selectWmsBaseGoodsList(new WmsBaseGoods());
        List<WmsSupplier>  wmsSuppliers= null;
        if (Objects.nonNull(roleId) && roleId == 100) {
            wmsSuppliers = Arrays.asList(supplierService.selectWmsSupplierById(operateId));
        }else {
            wmsSuppliers = supplierService.selectWmsSupplierList(new WmsSupplier());
        }

        List<WmsBaseWarehouse> warehouses = baseWarehouseService.selectWmsBaseWarehouseList(new WmsBaseWarehouse());
        List<Employee> employees = iEmployeeService.selectEmployeeList(new Employee());
        model.addAttribute("goods",wmsBaseGoods);
        model.addAttribute("suppliers",wmsSuppliers);
        model.addAttribute("warehouses",warehouses);
        model.addAttribute("employees",employees);
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
     * 新增保存入库单
     */
  /*  @RequiresPermissions("system:InOrder:add")*/
    @Log(title = "入库单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WmsInOrder wmsInOrder) {


        wmsInOrder.setOrderNo(UUID.randomUUID().toString());
        WmsStock wmsStock = convert(wmsInOrder);
        List<WmsStock> stockList = wmsStockService.selectWmsStockList(wmsStock);
        if (stockList.isEmpty()) {
            wmsStock.setNumber(wmsInOrder.getNumber());
            wmsStockService.insertWmsStock(wmsStock);
        } else {
            WmsStock stock = stockList.get(0);
            stock.setNumber(stock.getNumber() + wmsInOrder.getNumber());
            wmsStockService.updateWmsStock(stock);
        }
        return toAjax(wmsInOrderService.insertWmsInOrder(wmsInOrder));
    }
    private WmsStock convert(WmsInOrder wmsInOrder) {
        String goodsName = wmsInOrder.getGoodsName();
        String warehonseName = wmsInOrder.getWarehonseName();
        WmsStock wmsStock = new WmsStock();
        wmsStock.setGoodsName(goodsName);
        wmsStock.setWarehonseName(warehonseName);
        return wmsStock;
    }

    /**
     * 修改入库单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap,Model model) {
        WmsInOrder wmsInOrder = wmsInOrderService.selectWmsInOrderById(id);
        mmap.put("wmsInOrder", wmsInOrder);
        putData(model);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库单
     */
  /*  @RequiresPermissions("system:InOrder:edit")*/
    @Log(title = "入库单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WmsInOrder wmsInOrder) {
      /*  WmsStock wmsStock = convert(wmsInOrder);
        List<WmsStock> stockList = wmsStockService.selectWmsStockList(wmsStock);
        WmsStock stock = stockList.get(0);
        WmsInOrder wmsInOrder1 = wmsInOrderService.selectWmsInOrderById(wmsInOrder.getId());
        stock.setNumber(stock.getNumber() + wmsInOrder.getNumber() - wmsInOrder1.getNumber());
        wmsStockService.updateWmsStock(stock);*/
        return toAjax(wmsInOrderService.updateWmsInOrder(wmsInOrder));
    }

    /**
     * 删除入库单
     */
    /*@RequiresPermissions("system:InOrder:remove")*/
    @Log(title = "入库单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wmsInOrderService.deleteWmsInOrderByIds(ids));
    }
}
