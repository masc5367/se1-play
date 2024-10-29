package streams;

import java.util.*;

import application.Runtime;


/**
 * Driver class to run numbers calculations from the command line.
 * 
 */
public class StreamsDriver {

    /*
     * Object that implements the {@link Streams} interface.
     */
    final Streams streams;


    /**
     * Constructor with injected {@link Streams} instance.
     * @param numbers injected reference of a {@link Streams} instance
     */
    public StreamsDriver(Streams streams) {
        this.streams = streams;
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
            this.getClass().getSimpleName(), streams.getClass().getSimpleName()));
        //
        var res = streams.tenRandomNumbers();
        System.out.println(format("tenRandomNumbers()", null, res));
        //
        res = streams.tenEvenRandomNumbers();
        System.out.println(format("tenEvenRandomNumbers()", null, res));
        //
        res = streams.tenSortedEvenRandomNumbers();
        System.out.println(format("tenSortedEvenRandomNumbers()", null, res));
        //
        res = streams.filteredNumbers("even", 15);          // 15 random even numbers
        System.out.println(format("filteredNumbers(\"even\", 15)", "// 15 random even numbers", res));
        //
        res = streams.filteredNumbers("div3", 15);          // 15 random numbers divisible by 3
        System.out.println(format("filteredNumbers(\"div3\", 15)", "// 15 random numbers divisible by 3", res));
        //
        res = streams.filteredNumbers("prime3", 15);        // 15 random 3-digit prime numbers
        System.out.println(format("filteredNumbers(\"prime3\", 15)", "// 15 random two-digit prime numbers", res));
        //
        var nams = streams.filteredNames(Streams.names, ".*ez$");   // names ending with "ez"
        System.out.println(format("filteredNames(names, \".*ez$\")", "// names ending with \"ez\"", nams));
        //
        nams = streams.sortedNames(Streams.names, 8);       // first 8 names from sorted name list
        System.out.println(format("sortedNames(names, 8)", "// first 8 names from sorted name list", nams));
        //
        // names sorted by length and alphabetically for names with same length
        nams = streams.sortedNamesByLength(Streams.names);
        System.out.println(format("sortedNamesByLength(names)", "// names sorted by length", nams));
        //
        long value = streams.calculateValue(Streams.orders);
        System.out.println(format("calculateValue(orders)", null, value));
        //
        StringBuilder ordSb = new StringBuilder("\n");
        streams.sortOrdersByValue(Streams.orders).stream()
            .forEach(or -> ordSb.append(String.format("    - %s\n", or.toString())));
        //
        ordSb.append(" ".repeat(22)).append("--------\n");
        ordSb.append(" ".repeat(22)).append(String.format("%8d\n", value));
        ordSb.append(" ".repeat(22)).append("========");
        //
        System.out.println(format("sortOrdersByValue(orders)", "// orders sorted by value", ordSb));
    }

    /**
     * Return formatted output from parameters.
     * @param func function name invoked
     * @param comment provided comment
     * @param result result to show
     * @return formatted output
     */
    private String format(String func, String comment, Object result) {
        var cmt = comment==null? "" : "\t" + comment;
        return String.format("- %s:%s\n    -> %s\n", func, cmt, result);
    }
}