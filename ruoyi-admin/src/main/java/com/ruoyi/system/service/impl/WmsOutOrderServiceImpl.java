package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsOutOrderMapper;
import com.ruoyi.system.domain.WmsOutOrder;
import com.ruoyi.system.service.IWmsOutOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsOutOrderServiceImpl implements IWmsOutOrderService 
{
    @Autowired
    private WmsOutOrderMapper wmsOutOrderMapper;

    /**
     * 查询出库单
     * 
     * @param id 出库单ID
     * @return 出库单
     */
    @Override
    public WmsOutOrder selectWmsOutOrderById(Long id)
    {
        return wmsOutOrderMapper.selectWmsOutOrderById(id);
    }

    /**
     * 查询出库单列表
     * 
     * @param wmsOutOrder 出库单
     * @return 出库单
     */
    @Override
    public List<WmsOutOrder> selectWmsOutOrderList(WmsOutOrder wmsOutOrder)
    {
        return wmsOutOrderMapper.selectWmsOutOrderList(wmsOutOrder);
    }

    /**
     * 新增出库单
     * 
     * @param wmsOutOrder 出库单
     * @return 结果
     */
    @Override
    public int insertWmsOutOrder(WmsOutOrder wmsOutOrder)
    {
        wmsOutOrder.setCreateTime(DateUtils.getNowDate());
        return wmsOutOrderMapper.insertWmsOutOrder(wmsOutOrder);
    }

    /**
     * 修改出库单
     * 
     * @param wmsOutOrder 出库单
     * @return 结果
     */
    @Override
    public int updateWmsOutOrder(WmsOutOrder wmsOutOrder)
    {
        wmsOutOrder.setUpdateTime(DateUtils.getNowDate());
        return wmsOutOrderMapper.updateWmsOutOrder(wmsOutOrder);
    }

    /**
     * 删除出库单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsOutOrderByIds(String ids)
    {
        return wmsOutOrderMapper.deleteWmsOutOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除出库单信息
     * 
     * @param id 出库单ID
     * @return 结果
     */
    @Override
    public int deleteWmsOutOrderById(Long id)
    {
        return wmsOutOrderMapper.deleteWmsOutOrderById(id);
    }
}
