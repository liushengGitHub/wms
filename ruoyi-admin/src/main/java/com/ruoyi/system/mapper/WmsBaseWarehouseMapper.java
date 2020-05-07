package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WmsBaseWarehouse;

/**
 * 仓库信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface WmsBaseWarehouseMapper 
{
    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息ID
     * @return 仓库信息
     */
    public WmsBaseWarehouse selectWmsBaseWarehouseById(Long id);

    /**
     * 查询仓库信息列表
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 仓库信息集合
     */
    public List<WmsBaseWarehouse> selectWmsBaseWarehouseList(WmsBaseWarehouse wmsBaseWarehouse);

    /**
     * 新增仓库信息
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 结果
     */
    public int insertWmsBaseWarehouse(WmsBaseWarehouse wmsBaseWarehouse);

    /**
     * 修改仓库信息
     * 
     * @param wmsBaseWarehouse 仓库信息
     * @return 结果
     */
    public int updateWmsBaseWarehouse(WmsBaseWarehouse wmsBaseWarehouse);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库信息ID
     * @return 结果
     */
    public int deleteWmsBaseWarehouseById(Long id);

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsBaseWarehouseByIds(String[] ids);
}
