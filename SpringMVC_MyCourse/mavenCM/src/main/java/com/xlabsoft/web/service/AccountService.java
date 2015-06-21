package com.xlabsoft.web.service;
/**
 * @author Shamen
 */
import java.sql.SQLException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.xlabsoft.web.model.Account;

@Transactional
public interface AccountService {
    Account find(Integer id);
    List<Account> findAll() throws SQLException;
    int save(Account u); 
}
