# Project: *se1-play*, branch *b2-streams*

Branch *b2-streams* contains code and tasks for the assignment.

Code and JUnit-tests must work in the IDE and in the terminal.

Steps:

1. [Introduction to the Java *Streams API*](#1-introduction-to-the-java-streams-api)

1. [*Setup* and *Build* Project](#2-setup-and-build-project)

1. [Implement *Stream* - Methods](#3-implement-stream-methods)

1. [*JUnit*-Tests](#4-junit---tests)

1. [Final Result](#final-result)


&nbsp;

## 1. Introduction to the Java *Streams API*

The
[*Java Streams API*](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/stream/Stream.html)
has been introduced with Java version 8 (2014) to support *data-streams* and *stream-based programming*.

A `Stream` consists of three parts:

1. a `Source` from where data originates,

    - can be a *Collection* (List, Array, ...), a *Range* or a *Supplier* (*Generator*),

1. a concatenated sequence of `Functions` applied to data objects,

    - any *none-terminal* method of the *Java Streams API*, e.g.
        *map()*, *filter()*, *findAny()*,

1. a `Sink` that *pulls data* from the stream producing a *result*

    - any *terminal* method of the *Java Streams API*, e.g.
        *reduce()*, *sum()*, *collect()*, *forEach()*.

<img src="https://s1.o7planning.com/web-rs/web-image/en/arf-1189995-vi.webp" width="600"/>


Create in project `se1-play` a new package `streams` and in it a file
`StreamPlay.java` with:

```java
/*
 * Numbers with negative numbers and duplicates.
 */
final List<Integer> numbers = List.of(-2, 14, 9, 4, -3, 4, 9, 5);

/**
 * Return even numbers from input in ascending order with duplicates
 * removed.
 * @param input numbers
 * @return even numbers in ascending order with no duplicates
 */
List<Integer> sortedEvenNumbersNoDuplicates(List<Integer> input) {
    return input.stream()           // Source: input list as stream source
        .filter(n -> n % 2 == 0)    // only even numbers pass
        .distinct()                 // remove duplicates from stream
        .sorted()                   // sort stream
        .toList();                  // Sink: collect results as List<Integer>
}

public void run() {
    var result = sortedEvenNumbersNoDuplicates(numbers);
    var report = String.format("sortedEvenNumbers: %s", result);
    System.out.println(report);
}
```

Run `StreamPlay.java`:

```
sortedEvenNumbers: [-2, 4, 14]
```

Add method:


```java
/**
 * Return ten random numbers in an interval of a lower and an upper
 * bound: {@code lower <= number <= upper} in ascending order.
 * @param lower lower bound
 * @param upper upper bound
 * @return ten random numbers in ascending order
 */
List<Integer> tenSortedRandomNumbers(int lower, int upper) {
    Random rand = new Random();
    return Stream.generate(     // Source: generator
        () -> Integer.valueOf(rand.nextInt(upper)))
        // ...
        .limit(10)
        // ...
        .toList();
}
```

Run `tenSortedRandomNumbers(100, 999)` to return ten three-digit
random numbers:

```
sortedEvenNumbers: [-2, 4, 14]
tenSortedRandomNumbers: [108, 554, 602, 675, 693, 813, 889, 923, 965, 987]
```

Add argument: `boolean ascending` to control order and run function
with:

- `tenSortedRandomNumbers(100, 999, true)`

- `tenSortedRandomNumbers(100, 999, false)`

producing output:

```
# with: ascending=true
tenSortedRandomNumbers: [132, 274, 456, 527, 665, 700, 750, 859, 915, 980]

# with: ascending=false
tenSortedRandomNumbers: [940, 916, 718, 685, 561, 504, 493, 364, 213, 128]
```


&nbsp;

## 2. *Setup* and *Build* Project

Add branch
[b2-streams](https://github.com/sgra64/se1-play/tree/b2-streams)
to the project `se1-play`.

```sh
cd se1-play                 # change into the project directory

# update the 'main'-branch in the project directory (pull the latest
# changes from the remote directory giving incoming changes ("theirs")
# priority in case of conflicts)
# 
git pull origin main --strategy-option theirs

# pull content from branch 'b2-streams'
# 
git pull origin b2-streams --strategy-option theirs
```


New source files appear in package:
[*streams*](src/streams) with an interface:
[*Streams.java*](src/streams/Streams.java)
and implementation class:
[*StreamsImpl.java*](src/streams/StreamsImpl.java)
and driver code
[*StreamsDriver.java*](src/streams/StreamsDriver.java).


```sh
<se1-play>              # project directory
 |
 # regular content of the project from the 'main'-branch
 +--.gitignore              # files for git to ignore
 +-- README.md              # this markup file
 | ...
 |
 +-<src>                    # source code for 'numbers'
 |  +-<applications>            # original 'main'-branch
 |  +-<numbers>                 # pulled from branch: 'b1-numbers'
 |  +-<streams>                 # pulled from branch: 'b1-streams'
 |    +--StreamsPlay.java       # class used in introduction
 |    +--Streams.java           # interface of methods to implement
 |    +--StreamsImpl.java       # implementation class with implemented methods
 |    +--StreamsDriver.java     # driver that runs code
 |    +--package-info.java      # package documentation
 |
 +-<tests>                  # source code for 'numbers' JUnit tests
    +-<applications>            # original 'main'-branch
    +-<numbers>                 # pulled from branch: 'b1-numbers-tests'
    +-<streams>                 # pulled from branch: 'b1-streams-tests'
      +--Streams_1_tenRandomNumbers_Tests.java
      +--Streams_2_tenEvenRandomNumbers_Tests.java
      +--Streams_3_tenSortedEvenRandomNumbers_Tests.java
      +--Streams_4_filteredNumbers_Tests.java
      +--Streams_5_filteredNames_Tests.java
      +--Streams_6_sortedNames_Tests.java
      +--Streams_7_sortedNamesByLength_Tests.java
      +--Streams_8_calculateOrderValue_Tests.java
      +--Streams_9_sortByOrderValue_Tests.java
```


*Build* and *Run* the project:

```sh
mk compile                  # compile sources
mk run                      # run program
```

Output:

```
java application.Runtime
StreamsDriver executing StreamsImpl
- tenRandomNumbers():
    -> []

- tenEvenRandomNumbers():
    -> []

- tenSortedEvenRandomNumbers():
    -> []

- filteredNumbers("even", 15):  // 15 random even numbers
    -> []

- filteredNumbers("div3", 15):  // 15 random numbers divisible by 3
    -> []

- filteredNumbers("prime3", 15):        // 15 random two-digit prime numbers
    -> []

- filteredNames(names, ".*ez$"):        // names ending with "ez"
    -> []

- sortedNames(names, 8):        // first 8 names from sorted name list
    -> []

- sortedNamesByLength(names):   // names sorted by length
    -> []

- calculateValue(orders):
    -> 0

- sortOrdersByValue(orders):    // orders sorted by value
    ->
                      --------
                             0
                      ========
done.
```


&nbsp;

## 3. Implement *Stream* - Methods

Interface: [*Streams.java*](src/streams/Streams.java) defines
methods of the assignment that need to be implemented in the
corresponding implementation class:
[*StreamsImpl.java*](src/streams/StreamsImpl.java):

```java
/**
 * Interface defining functions for the <i>"b2-streams"</i> assignment.
 */
public interface Streams {

    // Aufgabe 1:
    List<Integer> tenRandomNumbers();

    // Aufgabe 2:
    List<Integer> tenEvenRandomNumbers();

    // Aufgabe 3:
    List<Integer> tenSortedEvenRandomNumbers();

    // Aufgabe 4:
    List<Integer> filteredNumbers(String filter, int limit);

    // Aufgabe 5:
    List<String> filteredNames(List<String> names, String regex);

    // Aufgabe 6:
    List<String> sortedNames(List<String> names, int limit);

    // Aufgabe 7:
    List<String> sortedNamesByLength(List<String> names);

    // Aufgabe 8:
    long calculateValue(List<Order> orders);

    // Aufgabe 9:
    List<Order> sortOrdersByValue(List<Order> orders);
}
```

The interface also defines `Class Order` that is used in examples:

```java
/*
 * Class 'Order' defines an order (Bestellung) of an
 * article of n units at a price per unit (in Cent). 
 */
class Order {
    final String article;
    final long units;
    final long unitPrice;
    //
    public Order(String description, long units, long unitPrice) {
        this.article = description;
        this.units = units;
        this.unitPrice = unitPrice;
    }
    public String toString() {
        return String.format("        - %-7s %dx %4d = %6d", article + ",", units, unitPrice, units * unitPrice);
    }
}
```

Interface: [*Streams.java*](src/streams/Streams.java) also provides
some test data used by the driver code and in JUnit tests:

```java
final List<String> names = List.of(
    "Hendricks", "Raymond", "Pena", "Gonzalez", "Nielsen", "Hamilton",
    "Graham", "Gill", "Vance", "Howe", "Ray", "Talley", "Brock", "Hall",
    "Gomez", "Bernard", "Witt", "Joyner", "Rutledge", "Petty", "Strong",
    "Soto", "Duncan", "Lott", "Case", "Richardson", "Crane", "Cleveland",
    "Casey", "Buckner", "Hardin", "Marquez", "Navarro"
);

final List<Order> orders = List.of(
    new Order("Becher", 2,  199),   // 2x  199 =  398
    new Order("Tasse",  7,  249),   // 7x  249 = 1743
    new Order("Stift",  4,   49),   // 4x   49 =  196
    new Order("Vase",   2,  999),   // 2x  999 = 1998
    new Order("Kanne",  5, 1499),   // 5x 1499 = 7495
    new Order("Lampe",  2, 1999),   // 2x 1999 = 3998
    new Order("Messer", 6,  789)    // 6x  789 = 4734
);                                  // Summe:   20562 = 205,62€
```

Implement Methods: `1..9` one after another in your IDE *using Streams*
and verify the output.

If output is corrent, perform the corresponding JUnit-test.
When it passes, proceed with the next method.

Output of implemented methods:

```
- tenRandomNumbers():
    -> [339, 629, 521, 308, 979, 264, 725, 8, 819, 603]

- tenEvenRandomNumbers():
    -> [806, 182, 172, 510, 110, 294, 880, 212, 698, 814]

- tenSortedEvenRandomNumbers():
    -> [20, 48, 64, 188, 480, 692, 852, 890, 956, 990]

- filteredNumbers("even", 15):  // 15 random even numbers
    -> [266, 218, 366, 744, 840, 914, 170, 834, 86, 182, 966, 284, 98, 886, 24]

- filteredNumbers("div3", 15):  // 15 random numbers divisible by 3
    -> [657, 849, 885, 669, 177, 30, 195, 474, 963, 867, 513, 6, 366, 45, 288]

- filteredNumbers("prime3", 15):        // 15 random two-digit prime numbers
    -> [599, 839, 541, 167, 157, 457, 197, 233, 491, 941, 661, 977, 461, 491, 16
3]

- filteredNames(names, ".*ez$"):        // names ending with "ez"
    -> [Gonzalez, Gomez, Marquez]

- sortedNames(names, 8):        // first 8 names from sorted name list
    -> [Bernard, Brock, Buckner, Case, Casey, Cleveland, Crane, Duncan]

- sortedNamesByLength(names):   // names sorted by length
    -> [Ray, Case, Gill, Hall, Howe, Lott, Pena, Soto, Witt, Brock, Casey, Crane
, Gomez, Petty, Vance, Duncan, Graham, Hardin, Joyner, Strong, Talley, Bernard,
Buckner, Marquez, Navarro, Nielsen, Raymond, Gonzalez, Hamilton, Rutledge, Cleve
land, Hendricks, Richardson]

- calculateValue(orders):
    -> 20562

- sortOrdersByValue(orders):    // orders sorted by value
    ->
    - Kanne,  5x 1499 =   7495
    - Messer, 6x  789 =   4734
    - Lampe,  2x 1999 =   3998
    - Vase,   2x  999 =   1998
    - Tasse,  7x  249 =   1743
    - Becher, 2x  199 =    398
    - Stift,  4x   49 =    196
                      --------
                         20562
                      ========
done.
```


&nbsp;

## 4. *JUnit* - Tests

Install branch
[*b2-streams-tests*](../../tree/b2-streams-tests/tests/streams):

```sh
# pull content from branch 'b2-streams-tests'
# 
git pull origin b2-streams-tests --strategy-option theirs
```

Compile tests and run:

```sh
mk compile-tests                # compile JUnit tests
mk run-tests                    # run JUnit-tests (all tests found)

# or run specific tests specified by the '-c' flag
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c application.Application_0_always_pass_Tests \
  -c streams.Streams_1_tenRandomNumbers_Tests
```

Output:

```
╷
├─ JUnit Jupiter ✔
│  ├─ Application_0_always_pass_Tests ✔
│  │  ├─ test_001_always_pass() ✔
│  │  └─ test_002_always_pass() ✔
│  └─ Streams_1_tenRandomNumbers_Tests ✔
│     └─ test100_tenRandomNumbers_regular() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 1093 ms
[         3 tests found           ]
[         3 tests successful      ]
[         0 tests failed          ]
done.
```

Run tests also in your IDE, particularly for debugging.

When one test passes, proceed with the next method and its test.


&nbsp;

## Final Result

The final result will show all tests passing. Leave out tests that are
not passing.

```sh
mk run-tests                    # run all tests
```

Or run tests selectively (remove tests that are failing):

```sh
# or run tests selectively (remove tests that are failing)
java $(eval echo $JUNIT_CLASSPATH) org.junit.platform.console.ConsoleLauncher\
  $(eval echo $JUNIT_OPTIONS) \
  -c application.Application_0_always_pass_Tests \
  -c streams.Streams_1_tenRandomNumbers_Tests \
  -c streams.Streams_2_tenEvenRandomNumbers_Tests \
  -c streams.Streams_3_tenSortedEvenRandomNumbers_Tests \
  -c streams.Streams_4_filteredNumbers_Tests \
  -c streams.Streams_5_filteredNames_Tests \
  -c streams.Streams_6_sortedNames_Tests \
  -c streams.Streams_7_sortedNamesByLength_Tests \
  -c streams.Streams_8_calculateOrderValue_Tests \
  -c streams.Streams_9_sortByOrderValue_Tests
```

Output with all tests passing:

```
╷
├─ JUnit Jupiter ✔
│  ├─ Application_0_always_pass_Tests ✔
│  │  ├─ test_001_always_pass() ✔
│  │  └─ test_002_always_pass() ✔
│  ├─ Streams_1_tenRandomNumbers_Tests ✔
│  │  └─ test100_tenRandomNumbers_regular() ✔
│  ├─ Streams_2_tenEvenRandomNumbers_Tests ✔
│  │  └─ test200_tenEvenRandomNumbers_regular() ✔
│  ├─ Streams_3_tenSortedEvenRandomNumbers_Tests ✔
│  │  └─ test300_tenSortedEvenRandomNumbers_regular() ✔
│  ├─ Streams_4_filteredNumbers_Tests ✔
│  │  ├─ test400_filteredNumbers_50evenNumbers_regular() ✔
│  │  ├─ test410_filteredNumbers_50divisibleBy3Numbers_regular() ✔
│  │  ├─ test420_filteredNumbers_50primeNumbers_regular() ✔
│  │  ├─ test430_filteredNumbers_different_even_numbers_returned() ✔
│  │  ├─ test431_filteredNumbers_different_div_by_three_numbers_returned() ✔
│  │  ├─ test432_filteredNumbers_different_prime_numbers_returned() ✔
│  │  ├─ test490_filteredNumbers_50evenNumbers_illegalFilter_null() ✔
│  │  ├─ test491_filteredNumbers_50evenNumbers_illegalFilter_empty() ✔
│  │  ├─ test492_filteredNumbers_50evenNumbers_illegalFilter_unknown() ✔
│  │  └─ test495_filteredNumbers_50evenNumbers_illegalLimit_negativ() ✔
│  ├─ Streams_5_filteredNames_Tests ✔
│  │  ├─ test500_filteredNames_regular() ✔
│  │  ├─ test590_filteredNames_irregularNamesNull() ✔
│  │  ├─ test591_filteredNames_irregularRegexNull() ✔
│  │  └─ test592_filteredNames_irregularNamesAndRegexNull() ✔
│  ├─ Streams_6_sortedNames_Tests ✔
│  │  ├─ test600_sortedNames_regular() ✔
│  │  ├─ test601_sortedNames_regular() ✔
│  │  ├─ test610_sortedNames_emptyNames() ✔
│  │  ├─ test690_sortedNames_irregularNamesNull() ✔
│  │  ├─ test691_sortedNames_irregularLimitNegativ() ✔
│  │  └─ test692_sortedNames_irregularNamesNullAndLimitNegativ() ✔
│  ├─ Streams_7_sortedNamesByLength_Tests ✔
│  │  ├─ test700_sortedNamesByLength_regular() ✔
│  │  ├─ test710_sortedNamesByLength_emptyNames() ✔
│  │  └─ test790_sortedNamesByLength_irregular_names_Null() ✔
│  ├─ Streams_8_calculateOrderValue_Tests ✔
│  │  ├─ test800_calculateValue_regular() ✔
│  │  ├─ test801_calculateValue_regular() ✔
│  │  ├─ test810_calculateValue_emptyOrders() ✔
│  │  └─ test890_calculateValue_irregular_orders_Null() ✔
│  └─ Streams_9_sortByOrderValue_Tests ✔
│     ├─ test900_sortByOrderValue_regular() ✔
│     ├─ test901_sortByOrderValue_regular() ✔
│     ├─ test910_sortByOrderValue_emptyOrders() ✔
│     └─ test990_sortByOrderValue_irregular_orders_Null() ✔
├─ JUnit Vintage ✔
└─ JUnit Platform Suite ✔

Test run finished after 1413 ms
[        13 containers found      ]
[         0 containers skipped    ]
[        13 containers started    ]
[         0 containers aborted    ]
[        13 containers successful ]
[         0 containers failed     ]
[        36 tests found           ]
[         0 tests skipped         ]
[        36 tests started         ]
[         0 tests aborted         ]
[        36 tests successful      ]
[         0 tests failed          ]
```
