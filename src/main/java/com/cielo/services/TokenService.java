package com.cielo.services;

import com.cielo.dao.TokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by 63289 on 2017/4/30.
 */
@Service
public class TokenService {
    private final TokenDao tokenDao;

    @Autowired
    public TokenService(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    public String generateToken(String name){
        String token= UUID.randomUUID().toString().replace("-","");
        tokenDao.put(token,name);
        return token;
    }

    public String getName(String token){
        return tokenDao.get(token);
    }

    public void delete(String token){
        tokenDao.delete(token);
    }
}
