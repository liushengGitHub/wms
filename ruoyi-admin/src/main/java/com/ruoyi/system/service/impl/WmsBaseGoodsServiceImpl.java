package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsBaseGoodsMapper;
import com.ruoyi.system.domain.WmsBaseGoods;
import com.ruoyi.system.service.IWmsBaseGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 货物基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsBaseGoodsServiceImpl implements IWmsBaseGoodsService 
{
    @Autowired
    private WmsBaseGoodsMapper wmsBaseGoodsMapper;

    /**
     * 查询货物基础信息
     * 
     * @param id 货物基础信息ID
     * @return 货物基础信息
     */
    @Override
    public WmsBaseGoods selectWmsBaseGoodsById(Long id)
    {
        return wmsBaseGoodsMapper.selectWmsBaseGoodsById(id);
    }

    /**
     * 查询货物基础信息列表
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 货物基础信息
     */
    @Override
    public List<WmsBaseGoods> selectWmsBaseGoodsList(WmsBaseGoods wmsBaseGoods)
    {
        return wmsBaseGoodsMapper.selectWmsBaseGoodsList(wmsBaseGoods);
    }

    /**
     * 新增货物基础信息
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 结果
     */
    @Override
    public int insertWmsBaseGoods(WmsBaseGoods wmsBaseGoods)
    {
        wmsBaseGoods.setCreateTime(DateUtils.getNowDate());
        return wmsBaseGoodsMapper.insertWmsBaseGoods(wmsBaseGoods);
    }

    /**
     * 修改货物基础信息
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 结果
     */
    @Override
    public int updateWmsBaseGoods(WmsBaseGoods wmsBaseGoods)
    {
        wmsBaseGoods.setUpdateTime(DateUtils.getNowDate());
        return wmsBaseGoodsMapper.updateWmsBaseGoods(wmsBaseGoods);
    }

    /**
     * 删除货物基础信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsBaseGoodsByIds(String ids)
    {
        return wmsBaseGoodsMapper.deleteWmsBaseGoodsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除货物基础信息信息
     * 
     * @param id 货物基础信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsBaseGoodsById(Long id)
    {
        return wmsBaseGoodsMapper.deleteWmsBaseGoodsById(id);
    }
}
