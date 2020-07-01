package com.ydgk.crowd.service.api;

import com.ydgk.crowd.entity.Admin;

import java.util.List;

public interface AdminService {

    Integer getAdminById(Integer id);
    Integer updateAdmin(Admin admin);
}
