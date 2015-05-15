/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2omeros;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author GeorgeKirm
 * @author GT
 */
public class UsersTest {
    
    public UsersTest() {
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
     * Test of registerNewUser method, of class Users.
     */
    @Test
    public void testRegisterNewUser() {
        System.out.println("registerNewUser");
        String newName = "Admin4";
        String newPassword1 = "4441";
        String newPassword2 = "4441";
        String rights = "A";
        Users instance = new Users();
        instance.registerNewUser(newName, newPassword1, newPassword2, rights);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logIn method, of class Users.
     */
    @Test
    public void testLogIn() {
        System.out.println("logIn");
        String logInName = "Admin4";
        String logInPassword = "4441";
        Users instance = new Users();
        instance.logIn(logInName, logInPassword);
        assertEquals(Account.cName, logInName );
        assertEquals(Account.cPasswordAndRights[0], "4441");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class Users.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String givenPassword = "4441";
        String newPassword1 = "1234";
        String newPassword2 = "1234";
        Users instance = new Users();
        instance.changePassword(givenPassword, newPassword1, newPassword2);
        assertEquals(newPassword1, "1234");
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class Users.
     */
    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        
        Users instance = new Users();
        Account.cName = "Admin4";
        Account.cPasswordAndRights[0] = "123456789";
        Account.cPasswordAndRights[1] = "A";
        instance.deleteAccount();
        fail("The test case is a prototype.");
    }

    /**
     * Test of logOut method, of class Users.
     */
    @Test
    public void testLogOut() {
        System.out.println("logOut");
        Users instance = new Users();
        instance.logOut();
        assertEquals(Account.cName, null);
        assertEquals(Account.cPasswordAndRights[0], null);
        fail("The test case is a prototype.");
    }

  
    
}
