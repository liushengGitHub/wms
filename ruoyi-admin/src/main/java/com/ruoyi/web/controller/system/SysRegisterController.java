package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.domain.WmsCustomer;
import com.ruoyi.system.domain.WmsSupplier;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.IWmsCustomerService;
import com.ruoyi.system.service.IWmsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.shiro.service.SysRegisterService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysConfigService;

import java.util.Arrays;

/**
 * 注册验证
 *
 * @author ruoyi
 */
@Controller
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;
    @Autowired
    private IWmsCustomerService customerService;
    @Autowired
    private IWmsSupplierService supplierService;
    @Autowired
    private SysUserRoleMapper roleMapper;
    @Autowired
    private ISysConfigService configService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public AjaxResult ajaxRegister(SysUser user, String type, String companyName, String name, String phone) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        Long id = null;
        if (type.equals("0")) {
            WmsSupplier wmsSupplier = new WmsSupplier();
            wmsSupplier.setLead(name);
            wmsSupplier.setName(companyName);
            wmsSupplier.setPhone(phone);
            supplierService.insertWmsSupplier(wmsSupplier);
            id = wmsSupplier.getId();
            user.setRoleId(100L);

        } else if (type.equals("1")) {
            WmsCustomer wmsCustomer = new WmsCustomer();
            wmsCustomer.setLead(name);
            wmsCustomer.setName(companyName);
            wmsCustomer.setPhone(phone);
            customerService.insertWmsCustomer(wmsCustomer);
            id = wmsCustomer.getId();
            user.setRoleId(101L);
        }


        user.setOperateId(id);
        String msg = registerService.register(user);

        if (StringUtils.isEmpty(msg)) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(user.getUserId());
            sysUserRole.setRoleId(user.getRoleId());
            roleMapper.batchUserRole(Arrays.asList(sysUserRole));
            return success();
        } else {
            return error(msg);
        }

    }
}
