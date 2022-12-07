package com.example.ty.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.ty.bean.User;
import com.example.ty.bean.Worker;
import com.example.ty.config.AuthAccess;
import com.example.ty.exception.ServiceException;
import com.example.ty.service.IUserService;
import com.example.ty.service.IWorkerService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptorWorker implements HandlerInterceptor {
    @Resource
    private IWorkerService iWorkerService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            HandlerMethod h = (HandlerMethod) handler;
            AuthAccess authAccess = h.getMethodAnnotation(AuthAccess.class);
            if (authAccess != null) {
                return true;
            }
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException(401, "无token，请重新登录");
        }
        // 获取 token 中的 user id
        String workerId;
        try {
            workerId = JWT.decode(token).getAudience().get(0);
        } catch (Exception j) {
            throw new ServiceException(401, "token验证失败，请重新登录");
        }
        // 根据token中的userid查询数据库
        Worker worker = iWorkerService.getById(workerId);
        if (worker == null) {
            throw new ServiceException(401, "用户不存在，请重新登录");
        }
        // 用户密码加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(worker.getWpwd())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(401, "token验证失败，请重新登录");
        }
        return true;
    }
}
