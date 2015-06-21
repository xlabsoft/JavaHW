package com.xlabsoft.web.service;
/**
 * @author Shamen
 */
import com.xlabsoft.web.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> all();
    List<Contact> all(Integer accountId);
}
