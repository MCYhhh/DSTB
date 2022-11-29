package com.example.ty.utils;


import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;



/**
 * jwt通用工具类
**/
public class JwtUtil {
    public static String getToken(String uid, String upwd) {
        return JWT.create().withAudience(uid) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 100)) // 100小时后token过期
                .sign(Algorithm.HMAC256(upwd)); // 以 password 作为 token 的密钥
    }
}
