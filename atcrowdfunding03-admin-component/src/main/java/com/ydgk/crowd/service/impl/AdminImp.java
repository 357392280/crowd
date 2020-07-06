package com.ydgk.crowd.service.impl;

import com.ydgk.crowd.entity.Admin;
import com.ydgk.crowd.entity.AdminExample;
import com.ydgk.crowd.mapper.AdminMapper;
import com.ydgk.crowd.service.api.AdminService;
import com.ydgk.crowd.ssm.constant.CrowdConstant;
import com.ydgk.crowd.ssm.exception.LoginFailedException;
import com.ydgk.crowd.ssm.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class AdminImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Integer getAdminById(Integer id) {
        return null;
    }

    public Integer updateAdmin(Admin admin) {
        return null;
    }

    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
//根据数据查询对象
        //1.创建adminexample对象
        AdminExample adminExample=new AdminExample();
        //创建critera对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAcctEqualTo(loginAcct);
        //调用adminmapper查询
        List<Admin> list = adminMapper.selectByExample(adminExample);

        if (list==null||list.size()==0){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if (list.size()>1){
            throw new RuntimeException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        Admin admin=list.get(0);
        if (admin==null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        String userPswdForm= CrowdUtil.md5(admin.getUserPswd());

        if (!Objects.equals(userPswdForm,CrowdUtil.md5(userPswd))){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
//如果一致返回admin
        return admin;
    }
}
