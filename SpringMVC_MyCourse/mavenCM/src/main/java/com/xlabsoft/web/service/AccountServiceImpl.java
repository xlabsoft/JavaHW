package com.xlabsoft.web.service;
/**
 * @author Shamen
 */
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.xlabsoft.web.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@Repository(value = "userDAO")
@Transactional
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    @Qualifier(value = "sessionFactory")
    SessionFactory sf;
    
    Properties props;
    //@Autowired
    Connection conn;
    
    @Override
    public List<Account> findAll() throws SQLException {
        return sf.getCurrentSession().createQuery("from Account").list();
    }
    /*
    @Override
    public int save(Account u) {
        return  (Integer) sf.getCurrentSession().save(u);
    }
    */
    
    @Override
    public int save(Account u) {
        //String query = "INSERT INTO accounts (RealName, eMail, Password, Level) values (?, ?, ?, ?)";
        String query = "INSERT INTO accounts (NickName, eMail, Level, Login, Password, Item, Balance, Amount, CreditLimit, Phone, banned) values (?, ?, ?, null,null,null,null,null,null,null,?)";
        PreparedStatement stmt = null;      
        try {
            //stmt = conn.prepareStatement(query);
            stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setBoolean(4, u.isIsAdmin());
            
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
            //return stmt.execute();
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Can't close the statement! " + e.getMessage());
            } catch (NullPointerException e) {
                System.err.println("Null Pointer Error! " + e.getMessage());
            }
        }
    }
    
    
    
    @Override
    public Account find(Integer id) {
        return (Account) sf.getCurrentSession().get(Account.class, id);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Account user = null;
        
        try {
            Query q = sf.getCurrentSession().createQuery("from Account u where u.email = :email");
            q.setString("email", string);
            List<Account> users = q.list();
            if (users.isEmpty()) {
                throw new UsernameNotFoundException("User " + string + " not found");
            } else {
                return users.get(0);
            }
        } catch (Exception e) {
            System.err.println("ohshit");
        }
        return null;
    }

        
}
