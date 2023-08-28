package com.enforceway.application.services.impl;

import com.enforceway.application.constants.SystemConstant;
import com.enforceway.application.entity.Admin;
import com.enforceway.application.entity.R;
import com.enforceway.application.mappers.AdminMapper;
import com.enforceway.application.services.AdminService;
import com.enforceway.application.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public R login(Admin admin) {
        Admin ru = this.adminMapper.login(admin);
        R r = new R();
        if (ru == null) {
            return R.error("用户名或者密码错误");
        } else {
            String token = JwtUtils.createJWT(String.valueOf(ru.getId()), ru.getUserName(), SystemConstant.JWT_TTL);
            r.put("token", token);
        }
        return r;
    }

}
