package numbers;

import java.util.*;
import java.util.stream.Collectors;

import application.Runtime;
import application.Runtime.Run;
import numbers.Numbers.Pair;


/**
 * Class implements the driver to run numbers calculations from
 * the command line.
 */
@Run(priority=10)
public class NumbersDriver implements Runtime.Runnable {

    /**
     * Default constructor (required by Javadoc).
     */
    public NumbersDriver() { }


    /**
     * {@inheritDoc}
     */
    @Override
    public void run(Properties properties, String[] args) {
        System.out.println(String.format("%s called.", this.getClass().getSimpleName()));

        /*
         * parse args[] in form: <function name> <numbers array name> x=n y=n sum=n
         */
        String f=null; String n=null;
        int x=0; int y=0; int sum=0; int s = 0;
        //
        for(var arg : args) {
            switch(arg) {
            case "sum": case "sum_positive_even_numbers": case "sum_recursive":
            case "findFirst": case "findLast": case "findAll": case "findSums":
            case "findAllSums":
                if(s >= 2) {
                    run(f, n, x, y, sum);
                    n=null; x=y=sum=0; s=0;
                }
                f = arg; s++; continue;
            }
            switch(arg) {
            case "numbers": case "numb_1": case "numb_2": case "numb_3":
                n = arg; s++; continue;
            }
            String[] spl = arg.split("=");
            if(spl.length > 1) {
                int value = 0;
                try {
                    value = Integer.parseInt(spl[1]);
                } catch(NumberFormatException e) { }
                switch(spl[0]) {
                case "x": x = value; continue;
                case "y": y = value; continue;
                case "sum": sum = value; continue;
                }
            }
        }
        run(f, n, x, y, sum);
    }

    /**
     * Execute function and print result.
     * @param f function name
     * @param n name of numbers array
     * @param x value of parameter x
     * @param y value of parameter y
     * @param sum value of parameter sum
     */
    private void run(String f, String n, int x, int y, int sum) {
        if(f==null || n==null)
            return;
        //
        int[] narr = null;
        switch(n) {
        case "numbers": narr = NumbersImpl.numbers; break;
        case "numb_1": narr = NumbersImpl.numb_1; break;
        case "numb_2": narr = NumbersImpl.numb_2; break;
        case "numb_3": narr = NumbersImpl.numb_3; break;
        default: return;
        }
        Numbers numbers = null;
        int res=0; String text="";
        switch(f) {
        case "sum":
            // int sum(int[] numbers);
            res = numbers.sum(narr);
            text = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "sum_positive_even_numbers":
            // int sum_positive_even_numbers(int[] numbers);
            res = numbers.sum_positive_even_numbers(narr);
            text = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "sum_recursive":
            // int sum_recursive(int[] numbers, int i);
            res = numbers.sum_recursive(narr, 0);
            text = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "findFirst":
            // int findFirst(int[] numbers, int x);
            res = numbers.findFirst(narr, x);
            text = String.format("%s(%s, x=%d) -> %d", f, n, x, res);
            break;

        case "findLast":
            // int findLast(int[] numbers, int x);
            res = numbers.findLast(narr, x);
            text = String.format("%s(%s, x=%d) -> %d", f, n, x, res);
            break;

        case "findAll":
            // List<Integer> findAll(int[] numbers, int x);
            List<Integer> res2 = numbers.findAll(narr, x);
            text = String.format("%s(%s, x=%d) -> %s", f, n, x, res2);
            break;

        case "findSums":
            // Set<Pair> findSums(int[] numbers, int sum);
            var res3 = numbers.findSums(narr, sum);
            String res3Str = prettyPrintPairs(res3);
            text = String.format("%s(%s, sum=%d) -> %d", f, n, x, res3Str);
            break;

        case "findAllSums":
            // Set<Set<Integer>> findAllSums(int[] numbers, int sum);
            var res4 = numbers.findAllSums(narr, sum);
            String res4Str = prettyPrintNumberSet(res4);
            text = String.format("%s(%s, sum=%d) -> %d", f, n, x, res4Str);
            break;
        }
        if(text.length() > 0) {
            System.out.println(String.format(" --> %s", text));
        }
    }

    /**
     * Pretty-print variable length {@code Set<Pair>} numbers.
     * @param pairs to print
     * @return pretty-printed pairs
     */
    private String prettyPrintPairs(Set<Pair> pairs) {
        StringBuffer sb = new StringBuffer("[");
        String numStr = pairs != null? pairs.toString() : "";
        boolean large = numStr.length() > 40;
        int j=0;
        for(Pair p : pairs) {
            sb.append(sb.length() > 1? ", " : "");
            if(large && j % 5 == 0) {
                sb.append("\n    - ");
            }
            sb.append(p.toString());
            j++;
        }
        sb.append(large? "\n   ], " : "], ");
        sb.append(String.format("solutions: %d", j));
        return sb.toString();
    }

    /**
     * Pretty-print variable length, nested {@code Set<Set<Integer>>} numbers.
     * @param nested set to print
     * @return pretty-printed nested sets
     */
    private String prettyPrintNumberSet(Set<Set<Integer>> numbers) {
        StringBuffer sb = new StringBuffer("[");
        String numStr = numbers != null? numbers.toString() : "";
        boolean large = numStr.length() > 40;
        var solutions = numbers.stream()
            .sorted((a, b) -> Integer.compare(a.size(), b.size()))
            .map(sol -> {
                sb.append(sb.length() > 1? ", " : "");
                sb.append(large? "\n    - " : "").append(sol.toString());
                return sol;
            }).collect(Collectors.toList());
        sb.append(large? "\n   ], " : "], ");
        sb.append(String.format("solutions: %d", solutions.size()));
        return sb.toString();
    }
}