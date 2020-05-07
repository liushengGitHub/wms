package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WmsSupplierMapper;
import com.ruoyi.system.domain.WmsSupplier;
import com.ruoyi.system.service.IWmsSupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-04
 */
@Service
public class WmsSupplierServiceImpl implements IWmsSupplierService 
{
    @Autowired
    private WmsSupplierMapper wmsSupplierMapper;

    /**
     * 查询供应商
     * 
     * @param id 供应商ID
     * @return 供应商
     */
    @Override
    public WmsSupplier selectWmsSupplierById(Long id)
    {
        return wmsSupplierMapper.selectWmsSupplierById(id);
    }

    /**
     * 查询供应商列表
     * 
     * @param wmsSupplier 供应商
     * @return 供应商
     */
    @Override
    public List<WmsSupplier> selectWmsSupplierList(WmsSupplier wmsSupplier)
    {
        return wmsSupplierMapper.selectWmsSupplierList(wmsSupplier);
    }

    /**
     * 新增供应商
     * 
     * @param wmsSupplier 供应商
     * @return 结果
     */
    @Override
    public int insertWmsSupplier(WmsSupplier wmsSupplier)
    {
        wmsSupplier.setCreateTime(DateUtils.getNowDate());
        return wmsSupplierMapper.insertWmsSupplier(wmsSupplier);
    }

    /**
     * 修改供应商
     * 
     * @param wmsSupplier 供应商
     * @return 结果
     */
    @Override
    public int updateWmsSupplier(WmsSupplier wmsSupplier)
    {
        wmsSupplier.setUpdateTime(DateUtils.getNowDate());
        return wmsSupplierMapper.updateWmsSupplier(wmsSupplier);
    }

    /**
     * 删除供应商对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsSupplierByIds(String ids)
    {
        return wmsSupplierMapper.deleteWmsSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息
     * 
     * @param id 供应商ID
     * @return 结果
     */
    @Override
    public int deleteWmsSupplierById(Long id)
    {
        return wmsSupplierMapper.deleteWmsSupplierById(id);
    }
}
