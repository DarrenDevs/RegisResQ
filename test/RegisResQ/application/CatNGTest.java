/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package RegisResQ.application;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author mydar
 */
public class CatNGTest {
    
    public CatNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSomeMethod() {
        Boolean result;
        Cat c = new Cat();
        
        result = c.validate();
        assertFalse(result);
        
        c.setName("Dobby");
        result = c.validate();
        assertFalse(result);
        
        c.setName("");
        result = c.validate();
        assertFalse(result);
        
        c.setName(null);
        result = c.validate();
        assertFalse(result);
        
        c.setName("dobby");
        
        c.setBreed("Persian");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2021-02-29");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2023-15-29");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2021/9/31");
        result = c.validate();
        assertFalse(result);
        
        c.setDateArrived("2016-02-29");
        result = c.validate();
        assertTrue(result);
    }
    
}
