# Streams

A stream pipeline consists of a source, zero or more intermediate operations, and a terminal operation.

## Basic pipeline

```java
List<String> result = words.stream()
        .filter(word -> word.length() >= 4)
        .map(String::toUpperCase)
        .sorted()
        .toList();
```

`filter`, `map`, and `sorted` are intermediate operations. `toList` is terminal.

## Laziness

Intermediate operations are lazy: they describe work but do not normally execute it until a terminal operation requests results.

```java
long count = words.stream()
        .filter(StringUtils::isPalindrome)
        .count();
```

## Reduction

```java
int total = numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();

Optional<Integer> maximum = numbers.stream()
        .max(Integer::compareTo);
```

## Collecting

```java
Map<Integer, List<String>> byLength = words.stream()
        .collect(Collectors.groupingBy(String::length));
```

## Streams are single-use

After a terminal operation, create a new stream rather than attempting to reuse the old one.

## Parallel streams

Parallel execution is not automatically faster. Use it only for suitable, measurable, stateless workloads where ordering and shared mutable state are handled correctly.

## Repository examples

- `src/main/java/nitin/streams`
- `src/main/java/nitin/io/fileIO/readfiles1`
- `src/main/java/nitin/io/fileIO/readfiles2`
- `src/main/java/nitin/io/fileIO/readfiles3`
