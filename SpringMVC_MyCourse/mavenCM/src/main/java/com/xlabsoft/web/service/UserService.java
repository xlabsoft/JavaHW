package com.xlabsoft.web.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.xlabsoft.web.model.User;

@Transactional
public interface UserService {
   User find(Integer id);
    List<User> findAll() throws SQLException;
    int save(User u); 
}
