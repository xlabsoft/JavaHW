package com.xlabsoft.web.model;
/**
 * @author Shamen
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contactid")
    Integer id;
    @Column(name = "Name")
    String name;
    @Column(name = "OffName")
    String oname;
    @Column(name = "Company")
    String company;
    
    @Column(name = "accountid")
    Integer accountId;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String oname) {
        this.oname = company;
    }
}
