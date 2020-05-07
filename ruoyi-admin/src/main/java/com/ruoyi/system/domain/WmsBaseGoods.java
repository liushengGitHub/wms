package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 货物基础信息对象 wms_base_goods
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public class WmsBaseGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 货物编号 */
    @Excel(name = "货物编号")
    private String goodsNo;

    /** 条形码 */
    @Excel(name = "条形码")
    private String pn;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goodsName;

    /** 货物简介 */
    @Excel(name = "货物简介")
    private String goodsBrief;

    /** 货物图片 */
    @Excel(name = "货物图片")
    private String goodsImg;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouseNo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsNo(String goodsNo) 
    {
        this.goodsNo = goodsNo;
    }

    public String getGoodsNo() 
    {
        return goodsNo;
    }
    public void setPn(String pn) 
    {
        this.pn = pn;
    }

    public String getPn() 
    {
        return pn;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsBrief(String goodsBrief) 
    {
        this.goodsBrief = goodsBrief;
    }

    public String getGoodsBrief() 
    {
        return goodsBrief;
    }
    public void setGoodsImg(String goodsImg) 
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsImg() 
    {
        return goodsImg;
    }
    public void setWarehouseNo(String warehouseNo) 
    {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseNo() 
    {
        return warehouseNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsNo", getGoodsNo())
            .append("pn", getPn())
            .append("goodsName", getGoodsName())
            .append("goodsBrief", getGoodsBrief())
            .append("goodsImg", getGoodsImg())
            .append("warehouseNo", getWarehouseNo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
