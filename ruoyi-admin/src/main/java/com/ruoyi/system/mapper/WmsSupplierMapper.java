package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WmsSupplier;

/**
 * 供应商Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface WmsSupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    public WmsSupplier selectWmsSupplierById(Long id);

    /**
     * 查询供应商列表
     * 
     * @param wmsSupplier 供应商
     * @return 供应商集合
     */
    public List<WmsSupplier> selectWmsSupplierList(WmsSupplier wmsSupplier);

    /**
     * 新增供应商
     * 
     * @param wmsSupplier 供应商
     * @return 结果
     */
    public int insertWmsSupplier(WmsSupplier wmsSupplier);

    /**
     * 修改供应商
     * 
     * @param wmsSupplier 供应商
     * @return 结果
     */
    public int updateWmsSupplier(WmsSupplier wmsSupplier);

    /**
     * 删除供应商
     * 
     * @param id 供应商ID
     * @return 结果
     */
    public int deleteWmsSupplierById(Long id);

    /**
     * 批量删除供应商
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsSupplierByIds(String[] ids);
}
