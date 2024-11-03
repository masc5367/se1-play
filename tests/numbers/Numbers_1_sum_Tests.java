package numbers;

import application.Runtime;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit 5 test class of Numbers class, sum() method.
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Numbers_1_sum_Tests {

    /*
     * tested object is an instance of the Numbers class
     */
    private static Numbers testObj;


    /**
     * Static setup method executed once for all tests. Creates
     * the test object.
     * @throws Exception when test creation fails
     */
    @BeforeAll
    public static void setUpBeforeTests() throws Exception {
        testObj = Runtime.getBean(Numbers.class)
            .orElseThrow(() -> new Exception(String.format(
                "no test object for: %s", Numbers.class.getName())));
    }

    @Test
    @Order(100)
    void test100_sum_regular() {
        assertEquals(30, testObj.sum(NumbersImpl.numbers));
    }

    @Test
    @Order(101)
    void test101_sum_regular() {
        assertEquals(50, testObj.sum(NumbersImpl.numb_1));
    }

    @Test
    @Order(102)
    void test102_sum_regular() {
        assertEquals(10984, testObj.sum(NumbersImpl.numb_2));
    }

    @Test
    @Order(103)
    void test103_sum_regular() {
        assertEquals(141466, testObj.sum(NumbersImpl.numb_3));
    }
}