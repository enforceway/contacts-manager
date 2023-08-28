package com.enforceway.application.interceptors;

import com.enforceway.application.entity.CheckResult;
import com.enforceway.application.entity.R;
import com.enforceway.application.utils.JwtUtils;
import com.enforceway.application.utils.StringUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.enforceway.application.constants.SystemConstant;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class SysInterceptor implements HandlerInterceptor {

    private boolean isInExcludedCheck(String pendingCheckURL) {
        boolean isIn = false;
        for( int i = 0; i < SystemConstant.excludedCheckURLs.length; i++) {
            if (SystemConstant.excludedCheckURLs[i].contains(pendingCheckURL)) {
                isIn = true;
                break;
            }
        }
        return isIn;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        this.log.info("拦截器拦截url:" + requestURI);
        if (this.isInExcludedCheck(requestURI)) {
            return true ;
        }
        String token = request.getHeader("token");

        if(handler instanceof HandlerMethod) {
            if (StringUtil.isEmpty(token)) {
                this.print(response, R.error("签名缺失"));
                return false;
            } else {
                CheckResult c = JwtUtils.validateJWT(token);
                if(c.isSuccess()) {
                    this.log.info("签名验证成功");
                    return true;
                } else {
                    R r = null;
                    switch (c.getErrCode()) {
                        case SystemConstant.JWT_ERRCODE_NULL:
                            r = R.error("签名不存在");
                            print(response, r);
                            break;
                        case SystemConstant.JWT_ERRCODE_EXPIRE:
                            r = R.error("签名过期");
                            print(response, r);
                            break;
                        case SystemConstant.JWT_ERRCODE_FAIL:
                            r = R.error("签名不正确");
                            print(response, r);
                            break;
                    }
                    this.log.info("签名认证失败：" + r.toString());
                    return false;
                }
            }
        }
        return true;
    }

    private void print(HttpServletResponse response, Object message){
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            PrintWriter writer = response.getWriter();
            writer.write(message.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
