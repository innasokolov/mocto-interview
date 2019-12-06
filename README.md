# SLCSP

## Calculate the second lowest cost silver plan

## Problem

You've been asked to determine the second lowest cost silver plan (SLCSP) for
a group of ZIP codes.

## Task

You've been given a CSV file, `slcsp.csv`, which contains the ZIP codes in the
first column. Fill in the second column with the rate (see below) of the
corresponding SLCSP and emit the answer as a CSV on stdout. Write your code in your best programming language.

### Expected output

The order of the rows in your answer as emitted on stdout must stay the same as how they
appeared in the original `slcsp.csv`. The first row should be the column headers: `zipcode,rate`
The remaining lines should output unquoted values with two digits after the decimal
place of the rates, for example: `64148,245.20`.

It may not be possible to determine a SLCSP for every ZIP code given; for example, if there is only one silver plan available, there is no _second_ lowest cost plan. Check for cases where a definitive answer cannot be found and leave those cells blank in the output CSV (no quotes or zeroes or other text). For example, `40813,`.

## Additional information

The SLCSP is the so-called "benchmark" health plan in a particular area. It's
used to compute the tax credit that qualifying individuals and families receive
on the marketplace. It's the second lowest rate for a silver plan in the rate area.

For example, if a rate area had silver plans with rates of `[197.3, 197.3, 201.1, 305.4, 306.7, 411.24]`, the SLCSP for that rate area would be `201.1`,
since it's the second lowest rate in that rate area.

A plan has a "metal level", which can be either Bronze, Silver, Gold, Platinum,
or Catastrophic. The metal level is indicative of the level of coverage the plan
provides.

A plan has a "rate", which is the amount that a consumer pays as a monthly
premium, in dollars.

A plan has a "rate area", which is a geographic region in a state that
determines the plan's rate. A rate area is a tuple of a state and a number, for
example, NY 1, IL 14.

There are two additional CSV files in this directory besides `slcsp.csv`:

- `plans.csv` — all the health plans in the U.S. on the marketplace
- `zips.csv` — a mapping of ZIP code to county/counties & rate area(s)

A ZIP code can potentially be in more than one county. If the county can not be
determined definitively by the ZIP code, it may still be possible to determine
the rate area for that ZIP code. A ZIP code can also be in more than one rate area. In that case, the answer is ambiguous
and should be left blank.

To compile and tests you can:
- run maven clean compile test from your IDE
- run `mvnw clean compile test` from command line in the project directory

To run application you can:
- run com.mocto.interview.Application class from your IDE
- run `java -classpath target/classes:$HOME/.m2/repository/org/projectlombok/lombok/1.18.10/lombok-1.18.10.jar:$HOME/.m2/repository/com/opencsv/opencsv/4.5/opencsv-4.5.jar:$HOME/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar:$HOME/.m2/repository/org/apache/commons/commons-text/1.3/commons-text-1.3.jar:$HOME/.m2/repository/commons-beanutils/commons-beanutils/1.9.3/commons-beanutils-1.9.3.jar:$HOME/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:$HOME/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:$HOME/.m2/repository/org/apache/commons/commons-collections4/4.2/commons-collections4-4.2.jar:$HOME/.m2/repository/com/google/guava/guava/18.0/guava-18.0.jar com.mocto.interview.Application` from command line in the project directory

