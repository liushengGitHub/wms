package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WmsBaseGoods;

/**
 * 货物基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface WmsBaseGoodsMapper 
{
    /**
     * 查询货物基础信息
     * 
     * @param id 货物基础信息ID
     * @return 货物基础信息
     */
    public WmsBaseGoods selectWmsBaseGoodsById(Long id);

    /**
     * 查询货物基础信息列表
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 货物基础信息集合
     */
    public List<WmsBaseGoods> selectWmsBaseGoodsList(WmsBaseGoods wmsBaseGoods);

    /**
     * 新增货物基础信息
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 结果
     */
    public int insertWmsBaseGoods(WmsBaseGoods wmsBaseGoods);

    /**
     * 修改货物基础信息
     * 
     * @param wmsBaseGoods 货物基础信息
     * @return 结果
     */
    public int updateWmsBaseGoods(WmsBaseGoods wmsBaseGoods);

    /**
     * 删除货物基础信息
     * 
     * @param id 货物基础信息ID
     * @return 结果
     */
    public int deleteWmsBaseGoodsById(Long id);

    /**
     * 批量删除货物基础信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsBaseGoodsByIds(String[] ids);
}
