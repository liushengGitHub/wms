package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsStockMapper;
import com.ruoyi.system.domain.WmsStock;
import com.ruoyi.system.service.IWmsStockService;
import com.ruoyi.common.core.text.Convert;

/**
 * 库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsStockServiceImpl implements IWmsStockService 
{
    @Autowired
    private WmsStockMapper wmsStockMapper;

    /**
     * 查询库存
     * 
     * @param id 库存ID
     * @return 库存
     */
    @Override
    public WmsStock selectWmsStockById(Long id)
    {
        return wmsStockMapper.selectWmsStockById(id);
    }

    /**
     * 查询库存列表
     * 
     * @param wmsStock 库存
     * @return 库存
     */
    @Override
    public List<WmsStock> selectWmsStockList(WmsStock wmsStock)
    {
        return wmsStockMapper.selectWmsStockList(wmsStock);
    }

    /**
     * 新增库存
     * 
     * @param wmsStock 库存
     * @return 结果
     */
    @Override
    public int insertWmsStock(WmsStock wmsStock)
    {
        wmsStock.setCreateTime(DateUtils.getNowDate());
        return wmsStockMapper.insertWmsStock(wmsStock);
    }

    /**
     * 修改库存
     * 
     * @param wmsStock 库存
     * @return 结果
     */
    @Override
    public int updateWmsStock(WmsStock wmsStock)
    {
        wmsStock.setUpdateTime(DateUtils.getNowDate());
        return wmsStockMapper.updateWmsStock(wmsStock);
    }

    /**
     * 删除库存对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsStockByIds(String ids)
    {
        return wmsStockMapper.deleteWmsStockByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存信息
     * 
     * @param id 库存ID
     * @return 结果
     */
    @Override
    public int deleteWmsStockById(Long id)
    {
        return wmsStockMapper.deleteWmsStockById(id);
    }
}
