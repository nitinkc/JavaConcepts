# Control flow

## Selection

```java
if (temperature > 30) {
    System.out.println("hot");
} else if (temperature < 10) {
    System.out.println("cold");
} else {
    System.out.println("mild");
}
```

A traditional `switch` statement uses labels and explicit transfer:

```java
switch (choice) {
    case 1:
        System.out.println("one");
        break;
    default:
        System.out.println("other");
}
```

A switch expression returns a value and avoids accidental fall-through:

```java
String description = switch (choice) {
    case 1 -> "one";
    case 2 -> "two";
    default -> "other";
};
```

## Iteration

```java
for (int i = 0; i < values.length; i++) {
    System.out.println(values[i]);
}

for (int value : values) {
    System.out.println(value);
}

while (ready()) {
    process();
}
```

A `do`/`while` loop executes its body at least once.

## Transfer

- `break` exits a loop or switch.
- `continue` skips to the next loop iteration.
- `return` exits the current method, optionally returning a value.
- `throw` exits normal control flow by raising an exception.

`try`, `catch`, and `finally` participate in exception handling; `final` is a modifier, not a transfer statement.

## Repository examples

- `src/main/java/nitin/a4flowControl/F1switch.java`
- `src/main/java/nitin/a4flowControl/SwitchExpressions.java`
- `src/main/java/nitin/a4flowControl/FlowControl.md`
