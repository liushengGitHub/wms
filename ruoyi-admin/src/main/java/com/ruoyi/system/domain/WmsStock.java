package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存对象 wms_stock
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public class WmsStock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 物品名字 */
    @Excel(name = "物品名字")
    private String goodsName;

    /** 仓库名字 */
    @Excel(name = "仓库名字")
    private String warehonseName;

    /** 该物品库存量 */
    @Excel(name = "该物品库存量")
    private Long number;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
            .append("goodsName", getGoodsName())
            .append("warehonseName", getWarehonseName())
            .append("number", getNumber())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
