package com.xlabsoft.web.model;
/**
 * @author Shamen
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "accounts")
public class Account implements Serializable, UserDetails {
    static GrantedAuthority auth = new GrantedAuthority() {
        @Override
        public String getAuthority() {
            return "ROLE_USER";
        }
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer id;
    @Column(name = "RealName")
    private String name;
    @Column(name = "eMail")
    private String email;
    @Column(name = "Password")
    private String password;          
    private boolean banned;
    private boolean isAdmin;
    /*
    @Column(name = "NickName")
    private String nick;
    */
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public Account(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public Account(String name) {
        this.name = name;
    }
    
    public Account() {
        
    }
    
    public boolean isBanned() {
        return banned;
    }

    void setBanned(boolean banned) {
        this.banned = banned;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
/*
    public String getNickName() {
        return nick;
    }

    public void setNickName(String nick) {
        this.nick = nick;
    }
    */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(auth);
        return list;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}