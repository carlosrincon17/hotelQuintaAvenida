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
import util.BaseDeDatos;

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
        Articulo_DTO art = new Articulo_DTO("computadores", 2500, 6);
        boolean expResult = true;

        try {
            BaseDeDatos.getInstance().conectar();
            boolean result = Articulo_DAO.create(art);
            assertEquals(expResult, result);

        } catch (Exception ex) {
            System.err.println("Error ->" + ex.getMessage());
        }
    }

    /**
     * Test of getAll method, of class Articulo_DAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        int expResult = 11;
        try {
            BaseDeDatos.getInstance().conectar();
            ArrayList result = Articulo_DAO.getAll();
            assertEquals(expResult, result.size());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    /**
     * Test of update method, of class Articulo_DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Articulo_DTO art = new Articulo_DTO("computadores", 2500, 6);;
        int nuevo = 1986;
        boolean expResult = true;
        try {
            BaseDeDatos.getInstance().conectar();
            boolean result = Articulo_DAO.update(art, nuevo);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        
    }

    /**
     * Test of getCantidadArticulo method, of class Articulo_DAO.
     */
    @Test
    public void testGetCantidadArticulo() throws Exception {
        System.out.println("getCantidadArticulo");
        Articulo_DTO art = new Articulo_DTO("papas", 1200, 19);
        int expResult = 19;
        try {
            BaseDeDatos.getInstance().conectar();
            int result = Articulo_DAO.getCantidadArticulo(art);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());

        }
    }
}
