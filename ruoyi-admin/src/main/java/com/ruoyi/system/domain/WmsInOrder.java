package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库单对象 wms_in_order
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public class WmsInOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderNo;

    /** 物品名字 */
    @Excel(name = "物品名字")
    private String goodsName;

    /** 仓库名字 */
    @Excel(name = "仓库名字")
    private String warehonseName;

    /** 供应商名字 */
    @Excel(name = "供应商名字")
    private String supplierName;
    /** 操作员工名字 */
    @Excel(name = "操作员工名字")
    private String employeeName;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /** 入库物品库存量 */
    @Excel(name = "入库物品库存量")
    private Long number;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setWarehonseName(String warehonseName) 
    {
        this.warehonseName = warehonseName;
    }

    public String getWarehonseName() 
    {
        return warehonseName;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderNo", getOrderNo())
            .append("goodsName", getGoodsName())
            .append("warehonseName", getWarehonseName())
            .append("supplierName", getSupplierName())
            .append("number", getNumber())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
