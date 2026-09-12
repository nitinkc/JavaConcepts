# Generics

Generics add compile-time type safety to classes, interfaces, methods, and collections.

## Generic classes

```java
final class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

Box<String> names = new Box<>();
names.set("Java");
String name = names.get();
```

Without a type parameter, callers often need casts and errors move from compile time to runtime. The repository's `ObjectExample` demonstrates this transition from `Object` containers to generic containers.

## Generic methods

```java
static <T> T first(List<T> values) {
    return values.getFirst();
}
```

The type-parameter list appears before the return type.

## Bounds

```java
static double sum(List<? extends Number> values) {
    return values.stream().mapToDouble(Number::doubleValue).sum();
}

static void addDefaults(List<? super Integer> values) {
    values.add(0);
}
```

A useful rule is **producer extends, consumer super**:

- `? extends T` is useful when reading `T` values.
- `? super T` is useful when writing `T` values.

## Invariance

`List<Integer>` is not a subtype of `List<Number>`. Allowing that assignment would make it possible to insert a `Double` into a list of integers.

## Erasure

Most generic type information is erased from runtime class representations. Consequences include:

- no `new T()`;
- no `new List<String>[10]`;
- no overloads that differ only by erased type arguments;
- unchecked warnings when code cannot prove type safety.

## Repository examples

- `src/main/java/nitin/generic/examples/ObjectExample.java`
- `src/main/java/nitin/generic/oReilly`
- `src/main/java/nitin/generic`
