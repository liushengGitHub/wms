package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsCustomerMapper;
import com.ruoyi.system.domain.WmsCustomer;
import com.ruoyi.system.service.IWmsCustomerService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsCustomerServiceImpl implements IWmsCustomerService 
{
    @Autowired
    private WmsCustomerMapper wmsCustomerMapper;

    /**
     * 查询客户
     * 
     * @param id 客户ID
     * @return 客户
     */
    @Override
    public WmsCustomer selectWmsCustomerById(Long id)
    {
        return wmsCustomerMapper.selectWmsCustomerById(id);
    }

    /**
     * 查询客户列表
     * 
     * @param wmsCustomer 客户
     * @return 客户
     */
    @Override
    public List<WmsCustomer> selectWmsCustomerList(WmsCustomer wmsCustomer)
    {
        return wmsCustomerMapper.selectWmsCustomerList(wmsCustomer);
    }

    /**
     * 新增客户
     * 
     * @param wmsCustomer 客户
     * @return 结果
     */
    @Override
    public int insertWmsCustomer(WmsCustomer wmsCustomer)
    {
        wmsCustomer.setCreateTime(DateUtils.getNowDate());
        return wmsCustomerMapper.insertWmsCustomer(wmsCustomer);
    }

    /**
     * 修改客户
     * 
     * @param wmsCustomer 客户
     * @return 结果
     */
    @Override
    public int updateWmsCustomer(WmsCustomer wmsCustomer)
    {
        wmsCustomer.setUpdateTime(DateUtils.getNowDate());
        return wmsCustomerMapper.updateWmsCustomer(wmsCustomer);
    }

    /**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsCustomerByIds(String ids)
    {
        return wmsCustomerMapper.deleteWmsCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户信息
     * 
     * @param id 客户ID
     * @return 结果
     */
    @Override
    public int deleteWmsCustomerById(Long id)
    {
        return wmsCustomerMapper.deleteWmsCustomerById(id);
    }
}
