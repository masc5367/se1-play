package numbers;

import java.util.*;
import java.util.stream.Collectors;

import application.Runtime;
import numbers.Numbers.Pair;


/**
 * Driver class to run numbers calculations from the command line.
 * 
 */
public class NumbersDriver {

    /*
     * Numbers object used for calculations that implements the {@link Numbers} interface.
     */
    private final Numbers numbers;


    /**
     * Constructor with injected {@link Numbers} instance.
     * @param numbers injected reference of a {@link Numbers} instance
     */
    public NumbersDriver(Numbers numbers) {
        this.numbers = numbers;
    }

    /**
     * Method invoked by the {@link Runtime} system to execute calculations
     * passed from the commandline through {@code args[]}.
     * @param properties properties extracted from the
     *          {@code application.properties} file
     * @param args arguments passed from command line
     */
    public void run(Properties properties, String[] args) {
        //
        System.out.println(String.format("%s executing %s",
            this.getClass().getSimpleName(), numbers.getClass().getSimpleName()));
        /*
         * if not passed from command line, fetch args[] from 'application.properties'
         */
        if(args.length==0) {
            String property = Optional.ofNullable(properties.get("numbers.run"))
                .map(p -> (String)properties.get(p))
                .filter(p -> p != null)
                .orElse("noop");
            var argList = Arrays.asList(property.split("\\s"));
            System.out.println(String.format("using args[] from 'application.properties': %s", argList));
            args = argList.toArray(String[]::new);
        }
        /*
         * parse args[] in form: f=<function_name> n=<array_name> x=n y=n sum=n
         */
        String f="noop"; String n="numbers"; int x=0, y=0, sum=0;
        for(var arg : args) {
            boolean reset = false;
            String[] spl = arg.split("\\s*=\\s*");
            if(spl.length > 1) {
                switch(spl[0]) {
                case "f":
                    reset=printResult(f, n, x, y, sum);
                    f=spl[1];
                    break;
                case "n": n = spl[1]; break;
                case "x": x = parseInt(spl[1]); break;
                case "y": y = parseInt(spl[1]); break;
                case "sum": sum = parseInt(spl[1]); break;
                }
            } else {
                switch(arg) {
                case "sum": case "sum_positive_even_numbers": case "sum_recursive":
                case "findFirst": case "findLast": case "findAll": case "findSums":
                case "findAllSums":
                    reset=printResult(f, n, x, y, sum);
                    f=arg;
                    break;
                case "numbers": case "numb_1": case "numb_2": case "numb_3":
                    n=arg;
                    break;
                }
            }
            if(reset) {
                n="numbers"; x=0; y=0; sum=0;
            }
        }
        printResult(f, n, x, y, sum);
    }

    /**
     * Execute function and print result.
     * @param f function name
     * @param n name of numbers array
     * @param x value of parameter x
     * @param y value of parameter y
     * @param sum value of parameter sum
     */
    private boolean printResult(String f, String n, int x, int y, int sum) {
        if("noop".equals(f)) {
            return false;
        }
        int[] narr = NumbersImpl.numbers;
        switch(n) {
            case "numb_1": narr = NumbersImpl.numb_1; break;
            case "numb_2": narr = NumbersImpl.numb_2; break;
            case "numb_3": narr = NumbersImpl.numb_3; break;
        }
        String result = execute(f, n, narr, x, y, sum);
        System.out.println(String.format(" - %s", result));
        return true;
    }

    /**
     * Execute function.
     * @param f function name
     * @param narr numbers array
     * @param x value of parameter x
     * @param y value of parameter y
     * @param sum value of parameter sum
     */
    private String execute(String f, String n, int[] narr, int x, int y, int sum) {
        String result="";
        switch(f) {
        // ignore no operations
        case "":
        case "noop": break;

        case "sum":
            // int sum(int[] numbers);
            int res = numbers.sum(narr);
            result = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "sum_positive_even_numbers":
            // int sum_positive_even_numbers(int[] numbers);
            res = numbers.sum_positive_even_numbers(narr);
            result = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "sum_recursive":
            // int sum_recursive(int[] numbers, int i);
            res = numbers.sum_recursive(narr, 0);
            result = String.format("%s(%s) -> %d", f, n, res);
            break;

        case "findFirst":
            // int findFirst(int[] numbers, int x);
            res = numbers.findFirst(narr, x);
            result = String.format("%s(%s, x=%d) -> %d", f, n, x, res);
            break;

        case "findLast":
            // int findLast(int[] numbers, int x);
            res = numbers.findLast(narr, x);
            result = String.format("%s(%s, x=%d) -> %d", f, n, x, res);
            break;

        case "findAll":
            // List<Integer> findAll(int[] numbers, int x);
            List<Integer> res2 = numbers.findAll(narr, x);
            result = String.format("%s(%s, x=%d) -> %s", f, n, x, res2);
            break;

        case "findSums":
            // Set<Pair> findSums(int[] numbers, int sum);
            var res3 = numbers.findSums(narr, sum);
            String res3Str = prettyPrintPairs(res3);
            result = String.format("%s(%s, sum=%d) -> %s", f, n, sum, res3Str);
            break;

        case "findAllSums":
            // Set<Set<Integer>> findAllSums(int[] numbers, int sum);
            var res4 = numbers.findAllSums(narr, sum);
            String res4Str = prettyPrintNumberSet(res4);
            result = String.format("%s(%s, sum=%d) -> %s", f, n, sum, res4Str);
            break;
        }
        return result;
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

    /**
     * Return integer value from numbers string.
     * @param numberStr numbers as string
     * @return integer value
     */
    private int parseInt(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch(NumberFormatException e) { return 0; }
    }
}