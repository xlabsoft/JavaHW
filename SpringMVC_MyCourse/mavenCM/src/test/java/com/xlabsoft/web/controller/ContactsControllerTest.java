package com.xlabsoft.web.controller;

import com.xlabsoft.web.model.Contact;
import com.xlabsoft.web.service.ContactService;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

/**
 *
 * @author Shamen
 */


public class ContactsControllerTest {
    
    class TestableContactsController extends ContactsController {

        public void setContactService(ContactService contactService) {
            this.contactService = contactService;
        }
        
    }
    
    public ContactsControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of all method, of class ContactsController.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        Integer id = 1;
        Model model = new BindingAwareModelMap();
        TestableContactsController instance = new TestableContactsController();
        instance.setContactService(new ContactService() {

            @Override
            public List<Contact> all() {
                return new ArrayList<>();
            }

            @Override
            public List<Contact> all(Integer accountId) {
                return new ArrayList<>();
            }
        });
        String expResult = "all";
        String result = instance.all(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of test method, of class ContactsController.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Model model = new BindingAwareModelMap();
        TestableContactsController instance = new TestableContactsController();
        instance.setContactService(new ContactService() {

            @Override
            public List<Contact> all() {
                return new ArrayList<>();
            }

            @Override
            public List<Contact> all(Integer accountId) {
                return new ArrayList<>();
            }
        });
        String expResult = "test";
        String result = instance.test(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
