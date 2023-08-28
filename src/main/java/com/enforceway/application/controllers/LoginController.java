package com.enforceway.application.controllers;

import com.enforceway.application.constants.SystemConstant;
import com.enforceway.application.entity.Admin;
import com.enforceway.application.entity.R;
import com.enforceway.application.mappers.AdminMapper;
import com.enforceway.application.services.AdminService;
import com.enforceway.application.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(@RequestBody Admin admin) {
        this.log.info("登录进行中");
        R r = this.adminService.login(admin);
        return r;
    }

}
