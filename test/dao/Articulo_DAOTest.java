/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Articulo_DTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sadalsuud
 */
public class Articulo_DAOTest {
    
    public Articulo_DAOTest() {
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
     * Test of create method, of class Articulo_DAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Articulo_DTO art = new Articulo_DTO("cama", 2500, 6);
        boolean expResult = true;
       
        try {

            boolean result = Articulo_DAO.create(art);
            assertEquals(expResult, result);
            
        } catch (Exception ex) {
            System.err.println("Error conectando " +ex.getMessage()+ " en " +ex.getLocalizedMessage());
           // System.err.println("error al crear artículo -> "+ e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Articulo_DAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        int expResult = 7;
        ArrayList result = Articulo_DAO.getAll();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Articulo_DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Articulo_DTO art = null;
        int nuevo = 0;
        boolean expResult = false;
        boolean result = Articulo_DAO.update(art, nuevo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidadArticulo method, of class Articulo_DAO.
     */
    @Test
    public void testGetCantidadArticulo() throws Exception {
        System.out.println("getCantidadArticulo");
        Articulo_DTO art = new Articulo_DTO("papas", 1200, 19);
        int expResult = 0;
        int result = Articulo_DAO.getCantidadArticulo(art);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
