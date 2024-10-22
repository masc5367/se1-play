package numbers;

import java.util.*;

import application.Runtime;
import application.Runtime.Run;


/**
 * Implementation class of the {@link Numbers} and {@link Runtime.Runnable}
 * interfaces.
 * <p>
 * The {@link Numbers} interface defines methods:
 * <pre>
 *  - int sum(int[] numbers);
 *  - int sum_positive_even_numbers(int[] numbers);
 *  - int sum_recursive(int[] numbers, int i);
 *  - int findFirst(int[] numbers, int x);
 *  - int findLast(int[] numbers, int x);
 *  - {@code List<Integer> findAll(int[] numbers, int x);}
 *  - {@code Set<Pair> findSums(int[] numbers, int sum);}
 *  - {@code Set<Set<Integer>> findAllSums(int[] numbers, int sum);}
 * </pre>
 */
@Run(priority=10)
public class NumbersImpl implements Numbers, Runtime.Runnable {

    /*
     * Numbers with negative numbers and duplicates.
     */
    static final int[] numbers = {-2, 4, 9, 4, -3, 4, 9, 5};

    /*
     * Numbers with no negative numbers and no duplicates.
     */
    static final int[] numb_1 = {8, 10, 7, 2, 14, 5, 4};

    /*
     * Larger set of 24 numbers, no negatives, no duplicates.
     */
    static final int[] numb_2 = {   // 24 numbers
        371,  682,  446,  754,  205,  972,  600,  163,  541,  672,
         27,  170,  226,    7,  190,  639,   87,  773,  651,  370,
        125,  774,  903,  636//,225,  463,  286,  569,  384,    9,
    }; // add more numbers to find more solutions

    /*
     * Even larger set of 63 numbers, no negatives, no duplicates.
     */
    static final int numb_3[] = {
        799, 2377,  936, 3498, 1342,  493, 1635, 4676, 1613, 3851,
       1445, 4506, 3346,    7, 2141, 2064, 1491,  908,   78, 3325,
       1756, 3691,   23, 1995, 1800,   15, 2784, 4305,   36, 2532,
       4292, 4802, 2522, 4183, 3261, 2610,  803, 2656,  498, 1668,
       2038, 2194,  440,  463, 4047, 4235, 3931,  756,  521, 4042,
       3302,  485, 1002,  408, 4691, 3387, 3104, 3658, 2241, 4382,
       1220, 3656,  500,
    };

    /**
     * Default constructor (required by Javadoc).
     */
    public NumbersImpl() { }


    /**
     * Aufgabe 1.) Calculate sum of numbers[].
     * @param numbers input
     * @return sum of numbers[]
     */
    @Override
    public int sum(int[] numbers) {
        return 0;
    }

    /**
     * Aufgabe 2.) Calculate sum of positive even numbers[].
     * @param numbers input
     * @return sum of positive even numbers[]
     */
    @Override
    public int sum_positive_even_numbers(int[] numbers) {
        return 0;
    }

    /**
     * Aufgabe 3.) Calculate sum of numbers[] recursively without using loops
     * (for, while, do/while).
     * @param numbers input numbers
     * @param i start index, calculate sum from index i in numbers[]
     * @return sum of numbers[]
     */
    @Override
    public int sum_recursive(int[] numbers, int i) {
        return 0;
    }

    /**
     * Aufgabe 4.) Return index of first occurrence of x in numbers[]
     * or return -1 if x was not found.
     * @param numbers input
     * @param x number to find
     * @return index of first occurrence of x in numbers[] or -1 if not found
     */
    @Override
    public int findFirst(int[] numbers, int x) {
        return 0;
    }

    /**
     * Aufgabe 5.) Return index of last occurrence of x in numbers[]
     * or return -1 if x was not found.
     * @param numbers input
     * @param x number to find
     * @return index of last occurrence of x in numbers[] or -1 if not found
     */
    @Override
    public int findLast(int[] numbers, int x) {
        return 0;
    }

    /**
     * Aufgabe 6.) Return list of all indices of number x in numbers[].
     * Return empty list, if x was not found.
     * @param numbers input
     * @param x number to find
     * @return list with all indices of x in numbers[]
     */
    @Override
    public List<Integer> findAll(int[] numbers, int x) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    /**
     * Aufgabe 7.) Return all pairs (a, b) in numbers[] with a + b = sum with
     * consolidating mirror copies such as (a, b) and (b, a) by returning
     * either (a, b) or (b, a), not both.
     * @param numbers input
     * @param sum to find
     * @return Set of all Pairs (a, b) that add to sum
     */
    @Override
    public Set<Pair> findSums(int[] numbers, int sum) {
        Set<Pair> result = new HashSet<>();
        return result;
    }

    /**
     * Aufgabe 8.) Find all combinations of numbers in numbers[] that add to sum.
     * @param numbers input
     * @param sum to find
     * @return set of all combinations of numbers that add to sum or empty list
     */
    @Override
    public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
        Set<Set<Integer>> result = new HashSet<>();
        return result;
    }

    /**
     * Method of the {@link Runtime.Runnable} interface called on an instance
     * created by the {@link Runtime}. Program execution starts here.
     * @param properties properties from the {@code application.properties} file
     * @param args arguments passed from the command line
     */
    @Override
    public void run(Properties properties, String[] args) {
        NumbersDriver driver = new NumbersDriver(this);
        driver.run(properties, args);
    }
}