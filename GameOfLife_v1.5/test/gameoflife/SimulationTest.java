/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jirka
 */
public class SimulationTest {
    
    public SimulationTest() {
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
     * Test of update method, of class Simulation.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int i = 1;
        int j = 1;
        boolean[][] currentMove = { {false,false,false},
                                    {false,true,false},
                                    {false,false,false}    
        };
        boolean[][] nextMove = { {false,false,false},
                                    {false,true,false},
                                    {false,false,false}    
        };
        Simulation instance = new Simulation(3,3);
        boolean expResult = false;
        boolean result = instance.update(i, j, currentMove, nextMove);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberOfNeighbours method, of class Simulation.
     */
    @Test
    public void testNumberOfNeighbours() {
        System.out.println("numberOfNeighbours");
        int i = 1;
        int j = 1;
        boolean[][] currentMove = { {false,false,false},
                                    {false,true,false},
                                    {false,false,false}    
        };
        Simulation instance = new Simulation(3,3);
        
        int expResult = 0;
        int result = instance.numberOfNeighbours(i, j, currentMove);
        assertEquals(expResult, result);
        
        boolean[][] currentMove2 = { {true,true,false},
                                    {true,true,false},
                                    {false,false,true}    
        };
        expResult = 4;
        result = instance.numberOfNeighbours(i, j, currentMove2);
        assertEquals(expResult, result);
     
    }
    
}
