package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsInOrderMapper;
import com.ruoyi.system.domain.WmsInOrder;
import com.ruoyi.system.service.IWmsInOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 入库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsInOrderServiceImpl implements IWmsInOrderService 
{
    @Autowired
    private WmsInOrderMapper wmsInOrderMapper;

    /**
     * 查询入库单
     * 
     * @param id 入库单ID
     * @return 入库单
     */
    @Override
    public WmsInOrder selectWmsInOrderById(Long id)
    {
        return wmsInOrderMapper.selectWmsInOrderById(id);
    }

    /**
     * 查询入库单列表
     * 
     * @param wmsInOrder 入库单
     * @return 入库单
     */
    @Override
    public List<WmsInOrder> selectWmsInOrderList(WmsInOrder wmsInOrder)
    {
        return wmsInOrderMapper.selectWmsInOrderList(wmsInOrder);
    }

    /**
     * 新增入库单
     * 
     * @param wmsInOrder 入库单
     * @return 结果
     */
    @Override
    public int insertWmsInOrder(WmsInOrder wmsInOrder)
    {
        wmsInOrder.setCreateTime(DateUtils.getNowDate());
        return wmsInOrderMapper.insertWmsInOrder(wmsInOrder);
    }

    /**
     * 修改入库单
     * 
     * @param wmsInOrder 入库单
     * @return 结果
     */
    @Override
    public int updateWmsInOrder(WmsInOrder wmsInOrder)
    {
        wmsInOrder.setUpdateTime(DateUtils.getNowDate());
        return wmsInOrderMapper.updateWmsInOrder(wmsInOrder);
    }

    /**
     * 删除入库单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsInOrderByIds(String ids)
    {
        return wmsInOrderMapper.deleteWmsInOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除入库单信息
     * 
     * @param id 入库单ID
     * @return 结果
     */
    @Override
    public int deleteWmsInOrderById(Long id)
    {
        return wmsInOrderMapper.deleteWmsInOrderById(id);
    }
}
