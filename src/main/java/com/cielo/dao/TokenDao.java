package com.cielo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by 63289 on 2017/4/27.
 */
@Repository
public class TokenDao {
    private final RedisTemplate<String, String> redisTemplate;
    private final static long validTime=60;

    @Autowired
    public TokenDao(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void put(String token, String name){
        redisTemplate.boundValueOps(token).set(name,validTime,TimeUnit.MINUTES);
    }

    public String get(String token) {
        return redisTemplate.opsForValue().get(token);
    }

    public void delete(String token){
        redisTemplate.delete(token);
    }
}
