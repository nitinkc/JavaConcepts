# Objects and interfaces

## Encapsulation

Encapsulation keeps state and the operations that protect it together:

```java
final class Account {
    private long balance;

    void deposit(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        balance += amount;
    }

    long balance() {
        return balance;
    }
}
```

Private fields provide access control; methods preserve the object's invariants.

## Inheritance and polymorphism

```java
abstract class Shape {
    abstract double area();
}

final class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```

A class can extend one class and implement multiple interfaces.

## Interfaces

```java
interface Named {
    String name();

    default String displayName() {
        return name().toUpperCase();
    }
}
```

Modern interfaces may declare abstract, default, static, and private methods. Interface fields are implicitly `public static final`. Interfaces cannot be instantiated directly.

An abstract class that implements an interface may leave methods unimplemented. A concrete subclass must provide the remaining implementations.

## Creating objects

The normal construction syntax is:

```java
Account account = new Account();
```

Reflection, cloning, deserialization, factories, and dependency-injection frameworks can also produce objects, but they are specialized mechanisms rather than replacements for constructors.

## Verified repository programs

<span class="md-tag">Runnable</span> <span class="md-tag">Deterministic output</span> <span class="md-tag">Stable Java</span>

Run the polymorphism example:

```shell
java --enable-preview \
  -cp build/classes/java/main:build/resources/main \
  nitin.a5object.AnimalDoctor
```

```text
Cat Checkup
Bird Checkup
Bird Checkup
Bird Checkup
Dog Checkup
Dog Checkup
```

Run the interface example:

```shell
java --enable-preview \
  -cp build/classes/java/main:build/resources/main \
  nitin.a6oops.interfaces.AnotherServiceProvider
```

```text
From Abstract Class, Not all Methods has to be implemented
```

Both outputs are verified by `scripts/verify-doc-examples.sh`.

## Repository examples

- `src/main/java/nitin/a5object`
- `src/main/java/nitin/a6oops`
- `src/main/java/nitin/a6oops/interfaces/I1InterfaceMethod.java`
- `src/main/java/nitin/nestedClasses`
- `src/main/java/nitin/cloning`
