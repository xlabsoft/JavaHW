package org.itstep.java.web.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.itstep.java.web.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@Transactional
public class GoodServiceImpl implements GoodService {

    @Autowired
    SessionFactory sf;
    
    @Override
    public List<Good> all() {
        return sf.getCurrentSession().createQuery("from Good").list();
    }

    @Override
    public List<Good> all(Integer categoryId) {
        Query q = sf.getCurrentSession().createQuery("from Good g where g.categoryId=:cat");
        q.setInteger("cat", categoryId);
        System.out.println(q.getQueryString());
        return q.list();
    }
    
}
