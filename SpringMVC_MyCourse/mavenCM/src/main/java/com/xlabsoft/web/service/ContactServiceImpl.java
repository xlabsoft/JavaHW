package com.xlabsoft.web.service;
/**
 * @author Shamen
 */
import com.xlabsoft.web.model.Contact;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "contactService")
@Transactional
public class ContactServiceImpl implements ContactService{
    @Autowired
    SessionFactory sf;
    
    @Override
    public List<Contact> all() {
        //Contact
        return sf.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public List<Contact> all(Integer accountId) {
        Query q = sf.getCurrentSession().createQuery("from Contact g where g.accountId =:cat");
       q.setInteger("cat", accountId);
       return q.list();
    }
}
