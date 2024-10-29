package streams;

import application.Runtime;

import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Streams_5_filteredNames_Tests {

    /*
     * tested object implements the Streams interface
     */
    private static Streams testObj;

    /**
     * Static setup method executed once for all tests. Creates
     * the test object.
     * 
     * @throws Exception is creation of test object fails
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        testObj = Runtime.getInstance().getBean(Streams.class)
            .orElseThrow(() -> new Exception(String.format(
                "no test object for: %s", Streams.class.getName())));
    }

    @Test
    @Order(500)
    void test500_filteredNames_regular() {
        //
        List<String> expected = List.of("Gonzalez", "Gomez", "Marquez");
        List<String> actual = testObj.filteredNames(Streams.names, ".*ez$");
        //
        assertEquals(3, actual.size());
        assertEquals(expected, actual);
    }

    @Test
    @Order(590)
    void test590_filteredNames_irregularNamesNull() {
        //
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testObj.filteredNames(null, ".*ez$");    // throw exception if names arg is null
        });
        assertEquals("names or regex argument is null.", thrown.getMessage());
    }

    @Test
    @Order(591)
    void test591_filteredNames_irregularRegexNull() {
        //
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testObj.filteredNames(Streams.names, null);    // throw exception if regex arg is null
        });
        assertEquals("names or regex argument is null.", thrown.getMessage());
    }

    @Test
    @Order(592)
    void test592_filteredNames_irregularNamesAndRegexNull() {
        //
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testObj.filteredNames(null, null);    // throw exception if both args are null
        });
        assertEquals("names or regex argument is null.", thrown.getMessage());
    }
}