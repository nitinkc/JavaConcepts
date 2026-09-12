# Lambdas

A lambda supplies an implementation of a functional interface: an interface with one abstract method.

## From iteration to behavior

```java
List<Integer> values = List.of(1, 2, 3);

for (int value : values) {
    System.out.println(value);
}

values.forEach(value -> System.out.println(value));
values.forEach(System.out::println);
```

The repository's introductory lambda example deliberately walks through indexed loops, enhanced loops, anonymous `Consumer` implementations, typed lambdas, inferred lambdas, and method references.

## Syntax forms

```java
Runnable task = () -> System.out.println("done");
Function<String, Integer> length = text -> text.length();
BinaryOperator<Integer> add = (left, right) -> left + right;
Predicate<String> present = text -> text != null && !text.isBlank();
```

Braces require an explicit `return` when returning a value:

```java
Function<String, Integer> length = text -> {
    int result = text.length();
    return result;
};
```

## Variable capture

Lambdas can capture local variables only when those variables are final or effectively final.

```java
int factor = 2;
Function<Integer, Integer> scale = value -> value * factor;
```

## Method references

| Form | Example |
| --- | --- |
| Static method | `Integer::parseInt` |
| Bound instance | `System.out::println` |
| Unbound instance | `String::length` |
| Constructor | `ArrayList::new` |

## Verified repository program

<span class="md-tag">Runnable</span> <span class="md-tag">Deterministic output</span> <span class="md-tag">Java 8+</span>

```shell
java --enable-preview \
  -cp build/classes/java/main:build/resources/main \
  nitin.LambdaExpressions.L1BasicWithListIteration
```

The first four lines come from progressively shorter lambda forms. The final two lines compare imperative and stream reductions.

```text
123456789
123456789
123456789
123456789
90
90
```

The output is verified by `scripts/verify-doc-examples.sh`.

## Repository examples

- `src/main/java/nitin/LambdaExpressions/L1BasicWithListIteration.java`
- `src/main/java/nitin/LambdaExpressions`
- `src/main/java/nitin/io/fileIO/readfiles3/FileUtils.java`
