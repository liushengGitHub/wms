package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WmsOutOrder;

/**
 * 出库单Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface WmsOutOrderMapper 
{
    /**
     * 查询出库单
     * 
     * @param id 出库单ID
     * @return 出库单
     */
    public WmsOutOrder selectWmsOutOrderById(Long id);

    /**
     * 查询出库单列表
     * 
     * @param wmsOutOrder 出库单
     * @return 出库单集合
     */
    public List<WmsOutOrder> selectWmsOutOrderList(WmsOutOrder wmsOutOrder);

    /**
     * 新增出库单
     * 
     * @param wmsOutOrder 出库单
     * @return 结果
     */
    public int insertWmsOutOrder(WmsOutOrder wmsOutOrder);

    /**
     * 修改出库单
     * 
     * @param wmsOutOrder 出库单
     * @return 结果
     */
    public int updateWmsOutOrder(WmsOutOrder wmsOutOrder);

    /**
     * 删除出库单
     * 
     * @param id 出库单ID
     * @return 结果
     */
    public int deleteWmsOutOrderById(Long id);

    /**
     * 批量删除出库单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsOutOrderByIds(String[] ids);
}
