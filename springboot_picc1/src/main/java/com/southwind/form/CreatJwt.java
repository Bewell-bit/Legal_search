package com.southwind.form;

import com.southwind.entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

import java.util.Date;

@Data
public class CreatJwt {
    public static String getoken(User user){
        Jwts.builder();//生成
        Jwts.parser();//解密

        JwtBuilder jwtBuilder=Jwts.builder()
                .setId(user.getId()+"")//设置需要加密的内容
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())//token保留时间
                .signWith(SignatureAlgorithm.HS256,"my-123").setExpiration(
                        new Date(new Date().getTime()+86400000) //getTime()得到的是毫秒数
                );
        System.out.println(jwtBuilder.compact());
        return jwtBuilder.compact();
    }
}