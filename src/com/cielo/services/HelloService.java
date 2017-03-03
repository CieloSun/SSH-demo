package com.cielo.services;

import com.cielo.dao.HelloDao;
import com.cielo.entity.HelloEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 63289 on 2017/2/22.
 */
@Service
public class HelloService {
    @Autowired
    public HelloDao helloDao;
    public void addByName(String name){
        HelloEntity helloEntity=new HelloEntity();
        helloEntity.setName(name);
        helloDao.add(helloEntity);
    }
}
