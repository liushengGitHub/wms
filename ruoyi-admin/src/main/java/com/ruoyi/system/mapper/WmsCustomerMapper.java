package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WmsCustomer;

/**
 * 客户Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
public interface WmsCustomerMapper 
{
    /**
     * 查询客户
     * 
     * @param id 客户ID
     * @return 客户
     */
    public WmsCustomer selectWmsCustomerById(Long id);

    /**
     * 查询客户列表
     * 
     * @param wmsCustomer 客户
     * @return 客户集合
     */
    public List<WmsCustomer> selectWmsCustomerList(WmsCustomer wmsCustomer);

    /**
     * 新增客户
     * 
     * @param wmsCustomer 客户
     * @return 结果
     */
    public int insertWmsCustomer(WmsCustomer wmsCustomer);

    /**
     * 修改客户
     * 
     * @param wmsCustomer 客户
     * @return 结果
     */
    public int updateWmsCustomer(WmsCustomer wmsCustomer);

    /**
     * 删除客户
     * 
     * @param id 客户ID
     * @return 结果
     */
    public int deleteWmsCustomerById(Long id);

    /**
     * 批量删除客户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsCustomerByIds(String[] ids);
}
