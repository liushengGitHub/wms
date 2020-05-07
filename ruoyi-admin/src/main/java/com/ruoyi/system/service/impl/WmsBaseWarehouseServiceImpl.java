package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsBaseWarehouseMapper;
import com.ruoyi.system.domain.WmsBaseWarehouse;
import com.ruoyi.system.service.IWmsBaseWarehouseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓库信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsBaseWarehouseServiceImpl implements IWmsBaseWarehouseService 
{
    @Autowired
    private WmsBaseWarehouseMapper wmsBaseWarehouseMapper;

    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息ID
     * @return 仓库信息
     */
    @Override
    public WmsBaseWarehouse selectWmsBaseWarehouseById(Long id)
    {
        return wmsBaseWarehouseMapper.selectWmsBaseWarehouseById(id);
    }

    /**
     * 查询仓库信息列表
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<WmsBaseWarehouse> selectWmsBaseWarehouseList(WmsBaseWarehouse wmsBaseWarehouse)
    {
        return wmsBaseWarehouseMapper.selectWmsBaseWarehouseList(wmsBaseWarehouse);
    }

    /**
     * 新增仓库信息
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 结果
     */
    @Override
    public int insertWmsBaseWarehouse(WmsBaseWarehouse wmsBaseWarehouse)
    {
        wmsBaseWarehouse.setCreateTime(DateUtils.getNowDate());
        return wmsBaseWarehouseMapper.insertWmsBaseWarehouse(wmsBaseWarehouse);
    }

    /**
     * 修改仓库信息
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 结果
     */
    @Override
    public int updateWmsBaseWarehouse(WmsBaseWarehouse wmsBaseWarehouse)
    {
        wmsBaseWarehouse.setUpdateTime(DateUtils.getNowDate());
        return wmsBaseWarehouseMapper.updateWmsBaseWarehouse(wmsBaseWarehouse);
    }

    /**
     * 删除仓库信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsBaseWarehouseByIds(String ids)
    {
        return wmsBaseWarehouseMapper.deleteWmsBaseWarehouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓库信息信息
     * 
     * @param id 仓库信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsBaseWarehouseById(Long id)
    {
        return wmsBaseWarehouseMapper.deleteWmsBaseWarehouseById(id);
    }
}
