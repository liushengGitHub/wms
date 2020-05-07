package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.WmsStock;

/**
 * 库存Service接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface IWmsStockService 
{
    /**
     * 查询库存
     * 
     * @param id 库存ID
     * @return 库存
     */
    public WmsStock selectWmsStockById(Long id);

    /**
     * 查询库存列表
     * 
     * @param wmsStock 库存
     * @return 库存集合
     */
    public List<WmsStock> selectWmsStockList(WmsStock wmsStock);

    /**
     * 新增库存
     * 
     * @param wmsStock 库存
     * @return 结果
     */
    public int insertWmsStock(WmsStock wmsStock);

    /**
     * 修改库存
     * 
     * @param wmsStock 库存
     * @return 结果
     */
    public int updateWmsStock(WmsStock wmsStock);

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsStockByIds(String ids);

    /**
     * 删除库存信息
     * 
     * @param id 库存ID
     * @return 结果
     */
    public int deleteWmsStockById(Long id);
}
