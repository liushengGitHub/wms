package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.WmsInOrder;

/**
 * 入库单Service接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface IWmsInOrderService 
{
    /**
     * 查询入库单
     * 
     * @param id 入库单ID
     * @return 入库单
     */
    public WmsInOrder selectWmsInOrderById(Long id);

    /**
     * 查询入库单列表
     * 
     * @param wmsInOrder 入库单
     * @return 入库单集合
     */
    public List<WmsInOrder> selectWmsInOrderList(WmsInOrder wmsInOrder);

    /**
     * 新增入库单
     * 
     * @param wmsInOrder 入库单
     * @return 结果
     */
    public int insertWmsInOrder(WmsInOrder wmsInOrder);

    /**
     * 修改入库单
     * 
     * @param wmsInOrder 入库单
     * @return 结果
     */
    public int updateWmsInOrder(WmsInOrder wmsInOrder);

    /**
     * 批量删除入库单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsInOrderByIds(String ids);

    /**
     * 删除入库单信息
     * 
     * @param id 入库单ID
     * @return 结果
     */
    public int deleteWmsInOrderById(Long id);
}
