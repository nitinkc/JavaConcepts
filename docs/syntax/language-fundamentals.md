# Language fundamentals

## Variables and primitive types

A declaration combines a type, name, and optional initializer:

```java
int count = 10;
double rate = 2.5;
boolean active = true;
char grade = 'A';
```

Java's eight primitive types are `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. Reference variables hold references to objects and may contain `null`.

## Type inference

For local variables, `var` asks the compiler to infer the static type from the initializer:

```java
var message = "Hello";       // String
var numbers = List.of(1, 2); // List<Integer>
```

`var` is not dynamic typing and cannot be used for fields, method parameters, or return types.

## Arrays

```java
int[] values = {10, 20, 30};
int first = values[0];
int size = values.length;
```

Array indices begin at zero. An invalid index throws `ArrayIndexOutOfBoundsException`.

## Methods

```java
static int add(int left, int right) {
    return left + right;
}
```

A method signature includes its name and parameter types. The return type is not part of overload selection.

## Classes

```java
final class Counter {
    private int value;

    void increment() {
        value++;
    }

    int value() {
        return value;
    }
}
```

## Repository examples

- `src/main/java/nitin/a1languageFundamentals`
- `src/main/java/nitin/arrays`
- `src/main/java/nitin/strings`
- `src/main/java/nitin/a5object`
