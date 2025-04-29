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
public class DogNGTest {
    
    public DogNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.Test
    public void testValidate() {
        
        Boolean result;
        Dog d = new Dog();
        
        result = d.validate();
        assertFalse(result);
        
        d.setName("Toto");
        result = d.validate();
        assertFalse(result);
        
        d.setName("");
        result = d.validate();
        assertFalse(result);
        
        d.setName(null);
        result = d.validate();
        assertFalse(result);
        
        d.setName("Toto");
        
        d.setBreed("Cairn Terrier");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2021-02-29");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2021-13-29");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2021-6-31");
        result = d.validate();
        assertFalse(result);
        
        d.setDateArrived("2016-02-29");
        result = d.validate();
        assertTrue(result);
    }
    
}
