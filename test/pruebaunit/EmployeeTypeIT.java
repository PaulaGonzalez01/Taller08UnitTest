/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaunit;

import java.util.Currency;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static pruebaunit.EmployeeType.Manager;
import static pruebaunit.EmployeeType.Worker;

/**
 *
 * @author CltControl
 */
public class EmployeeTypeIT {
    
    public EmployeeTypeIT() {
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
     * Test of values method, of class EmployeeType.
     */
  /*  @Test
    public void testValues() {
        System.out.println("values");
        EmployeeType[] expResult = null;
        EmployeeType[] result = EmployeeType.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of valueOf method, of class EmployeeType.
     */
  /*  @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "Worker";
        EmployeeType expResult = Worker;
        EmployeeType result = EmployeeType.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    /*EVALUACION DE BONUS ANUAL DEL EMPLEADO WORKER DONDE SU VALOR DEBE SER 386*/
    @Test
    public void testBonusWorker(){
        System.out.println("Test Bonus Worker");
        Double bonus=386.0;
        Currency c = Currency.getInstance(Locale.US);
        Employee e= new Employee((float) 200.0, c, 10, Worker);
        System.out.println(e.CalculateYearBonus());
        assertTrue(bonus.equals(Double.valueOf(e.CalculateYearBonus())));
    }
     /*EVALUACION DE BONUS ANUAL DEL EMPLEADO MANAGER DONDE SU VALOR DEBE SER 386*/

    @Test
    public void testBonusManager(){
        System.out.println("Test Bonus Manager");
        Double bonus = 386.0;
        Currency c = Currency.getInstance(Locale.US);
        Employee e= new Employee((float) 200.0, c, 10, Manager);
        System.out.println(e.CalculateYearBonus());
        assertFalse(bonus.equals(e.CalculateYearBonus()));
    }
    
    /*Evaluacion de salario Worker US*/
    @Test
    public void testSalarioWorker(){
        System.out.println("Test salario Worker currency US");
        Double salarioExp=200.0;
        Currency c = Currency.getInstance(Locale.US);
        Employee e= new Employee((float) 200.0, c, 10, Worker);
        System.out.println(e.cs());
        assertTrue(salarioExp.equals(Double.valueOf(e.cs())));
    }
    /*Evaluacion de salario Worker UK*/
    @Test
    public void testSalarioWorkerUK(){
        System.out.println("Test salario Worker currency UK");
        Double salarioExp=190.0;
        Currency c = Currency.getInstance(Locale.UK);
        Employee e= new Employee((float) 200.0, c, 10, Worker);
        System.out.println(e.cs());
        assertTrue(salarioExp.equals(Double.valueOf(e.cs())));
    }
    
}
