package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import application.Runtime;
import application.Runtime.Bean;


/**
 * Implementation class of the {@link Streams} and {@link Runtime.Runnable}
 * interfaces.
 * <p>
 * The {@link Streams} interface defines methods:
 * <pre>
 *  - List<Integer> tenRandomNumbers();
 *  - List<Integer> tenEvenRandomNumbers();
 *  - List<Integer> tenSortedEvenRandomNumbers();
 *  - List<Integer> filteredNumbers(String filter, int limit);
 *  - List<String> filteredNames(List<String> names, String regex);
 *  - List<String> sortedNames(List<String> names, int limit);
 *  - List<String> sortedNamesByLength(List<String> names);
 *  - long calculateValue(List<Order> orders);
 *  - List<Order> sortOrdersByValue(List<Order> orders);
 * </pre>
 */
@Bean(priority=20)
public class StreamsImpl implements Streams, Runtime.Runnable {

    /*
     * Random generator.
     */
    final Random rand = new Random();

    /*
     * Aufgabe 4: Map of lambda expressions used as filter function
     * <pre>
     *  - key="even": lambda yields true when a number is even
     *  - key="div3": lambda yields true when a number divides by 3
     *  - key="prime": lambda yields true when a number is three-digit prime number
     * </pre>
     */
    final Map<String, Function<Integer, Boolean>> filterFunctions = new HashMap<>();

    /*
     * Function variable with Lambda expression that accepts one argument and
     * returns a Stream of random Integer numbers between [1, upperBound].
     */
    final Function<Integer, Stream<Integer>> randIntStream =
            (upperBound)  -> Stream.generate(() -> rand.nextInt(1, upperBound));

    /**
     * Constructor.
     */
    public StreamsImpl() {
        // add first filter function for key: "even" that yields true when a number is even
        filterFunctions.put("even", (n) -> n % 2 == 0 );
        /*
         * TODO: add other filter functions for
         *  - key="div3": lambda yields true when a number divides by 3
         *  - key="prime3": lambda yields true when a number is three-digit prime number
         */
        filterFunctions.put("div3", (n) -> true );
        filterFunctions.put("prime3", (n) -> true );
    }

    /**
     * Method of the {@link Runtime.Runnable} interface called on an instance
     * created by the {@link Runtime}. Program execution starts here.
     * @param properties properties from the {@code application.properties} file
     * @param args arguments passed from the command line
     */
    @Override
    public void run(Properties properties, String[] args) {
        StreamsDriver driver = new StreamsDriver(this);
        driver.run(properties, args);
    }

    /**
     * Aufgabe 1: Return 10 random integer numbers generated from a Stream<Integer>.
     * @return 10 random numbers
     */
    @Override
    public List<Integer> tenRandomNumbers() {
        List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
    }

    /**
     * Aufgabe 2: Return 10 even random integer numbers generated from a Stream<Integer>.
     * @return 10 even random numbers
     */
    @Override
    public List<Integer> tenEvenRandomNumbers() {
        List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
    }

    /**
     * Aufgabe 3: Return 10 even sorted random integer numbers generated from a Stream<Integer>.
     * @return 10 even sorted random numbers
     */
    @Override
    public List<Integer> tenSortedEvenRandomNumbers() {
        List<Integer> result = new ArrayList<>();

        /*
         * TODO: write code to implement the method
         */
        return result;
    }

    /**
     * Aufgabe 4: Method applies function from {@link filterFunctions} to a stream
     * of integer numbers returning only numbers matching the selected filter:
     * <pre>
     *  - filter="even": filter even numbers
     *  - filter="div3": filter numbers divisible by 3
     *  - filter="prime3": filter 3-digit prime numbers
     * </pre>
     * @param filter name of filter function in {@link filterFunctions}
     * @param limit amount of numbers returned
     * @return numbers matching the selected filter
     */
    @Override
    public List<Integer> filteredNumbers(String filter, int limit) {
        //
        if(filter==null || ! filterFunctions.containsKey(filter))
            throw new IllegalArgumentException(String.format("filter null or unknown: %s",
                filter==null? "null" : String.format("\"%s\"", filter)));
        //
        // if(limit < 0)
        //     throw new IllegalArgumentException(String.format("negative limit: %d", limit));

        /*
         * TODO: write code to implement the method
         * use lambda expressions from {@link filterFunctions} (see {@link Streams} interface)
         */
        return List.of();
    }

    /**
     * Aufgabe 5: Return sub-list from input names filtered by a regular expression.
     * Order of names remains unchanged, regular expression refers to {@link java.util.regex.Pattern}.
     * @param names input names
     * @param regex regular expression according to {@link java.util.regex.Pattern}
     * @return sub-list of names
     */
    @Override
    public List<String> filteredNames(List<String> names, String regex) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
    }

    /**
     * Aufgabe 6: Return alphabetically sorted list of names up to limit.
     * @param names input names
     * @param limit maximum number of names returned
     * @return alphabetically sorted list of names up to limit
     */
    @Override
    public List<String> sortedNames(List<String> names, int limit) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
    }

    /**
     * Aufgabe 7: Return list of names sorted by name length (first criteria)
     * and alphabetically (second criteria) for names of equal length.
     * @param names input names
     * @return names sorted by name length
     */
    @Override
    public List<String> sortedNamesByLength(List<String> names) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
    }

    /**
     * Aufgabe 8: Calculate value of orders.
     * @param orders list of orders to process
     * @return value of orders
     */
    @Override
    public long calculateValue(List<Order> orders) {

        /*
         * TODO: write code to implement the method
         */
        return 0L;
    }

    /**
     * Aufgabe 9: Return list of orders sorted by order value (highest-value first).
     * @param orders list to sort
     * @return orders sorted by order value (highest-value first)
     */
    @Override
    public List<Order> sortOrdersByValue(List<Order> orders) {

        /*
         * TODO: write code to implement the method
         */
        return List.of();
    }
}