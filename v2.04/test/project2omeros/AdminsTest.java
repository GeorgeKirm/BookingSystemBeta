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
 *
 * @author GeorgeKirm
 * @author GT
 */
public class AdminsTest {
    
    public AdminsTest() {
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
     * Test of adminChecker method, of class Admins.
     */
    @Test
    public void testAdminChecker() {
        System.out.println("adminChecker");
        String adminName = "99999999";
        String adminPassword = "999999999"; //invalid usernames and passwords for administrator
        Admins instance = new Admins();
        boolean expResult = false;
        boolean result = instance.adminChecker(adminName, adminPassword);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
}
