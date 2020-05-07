package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库信息对象 wms_base_warehouse
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public class WmsBaseWarehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    private String warehouseNo;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 仓库类型 */
    @Excel(name = "仓库类型")
    private String warehouseType;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String warehouseAddress;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseNo(String warehouseNo) 
    {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseNo() 
    {
        return warehouseNo;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setWarehouseType(String warehouseType) 
    {
        this.warehouseType = warehouseType;
    }

    public String getWarehouseType() 
    {
        return warehouseType;
    }
    public void setWarehouseAddress(String warehouseAddress) 
    {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseAddress() 
    {
        return warehouseAddress;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseNo", getWarehouseNo())
            .append("warehouseName", getWarehouseName())
            .append("warehouseType", getWarehouseType())
            .append("warehouseAddress", getWarehouseAddress())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
