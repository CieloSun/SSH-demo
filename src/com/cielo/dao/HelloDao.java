package com.cielo.dao;

import com.cielo.entity.HelloEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 63289 on 2017/2/22.
 */
@Repository
public class HelloDao{
    @Autowired
    public HibernateTemplate hibernateTemplate;
    @Transactional
    public void add(HelloEntity helloEntity){
        hibernateTemplate.save(helloEntity);
    }
}
