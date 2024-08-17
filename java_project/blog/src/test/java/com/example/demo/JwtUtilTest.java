package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
 * JWT
 */
public class JwtUtilTest {

    private static final long expiration = 30*60*1000;//单位是毫秒
    private static final String s = "UVpV3VjPLWqmoDAuid8fL9Chg+s31iV0PNzwXJjOWOs=";

    @Test
    public void getToken() {
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(s));
        Map<String, Object>  claim = new Hashtable<>();
        claim.put("id",5);
        claim.put("name", "zhangsan");

        String token = Jwts.builder()
                .setClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(key)
                .compact();
        System.out.println(token);
    }

    @Test
    public void getKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String key = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(key);
    }

    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJpZCI6NSwiZXhwIjoxNzIzNjE1MjIzfQ.xg_IHrMDxjwUdMqtqy9N61Y06aZaNtROi-ifj_qyE1M";
        JwtParser build = Jwts.parserBuilder().setSigningKey(s).build();
        Claims body = build.parseClaimsJws(token).getBody();
        System.out.println(body);
    }
}
