package com.ydgk.crowd.service.api;

import com.ydgk.crowd.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    Integer getAdminById(Integer id);
    Integer updateAdmin(Admin admin);
    Admin getAdminByLoginAcct(String loginAcct,String userPswd);


}
