# Operators

## Arithmetic

```java
int quotient = 10 / 3;  // 3: integer division discards the fraction
int remainder = 10 % 3; // 1
int total = 4 + 5;
```

The repository's `O2ArithmaticOperators` example compares quotient and remainder values for consecutive integers.

## Comparison and equality

```java
boolean ordered = left < right;
boolean samePrimitive = x == y;
boolean sameReference = first == second;
boolean sameValue = first.equals(second);
```

Use `==` to compare primitive values or object identity. Use an appropriate `equals` implementation for object value equality.

## Short-circuit logic

```java
if (value != null && !value.isEmpty()) {
    System.out.println(value);
}
```

`&&` evaluates its right operand only when the left operand is `true`. `||` evaluates its right operand only when the left operand is `false`. In contrast, boolean `&` and `|` evaluate both operands.

## Increment

```java
int x = 5;
int before = x++; // before is 5, x becomes 6
int after = ++x;  // x becomes 7, after is 7
```

## Conditional operator

```java
String label = score >= 60 ? "pass" : "fail";
```

Java does **not** have a `??` null-coalescing operator. Use a conditional expression, `Objects.requireNonNullElse`, or `Optional` where appropriate.

## Verified repository program

<span class="md-tag">Runnable</span> <span class="md-tag">Deterministic output</span> <span class="md-tag">Stable Java</span>

```shell
java --enable-preview \
  -cp build/classes/java/main:build/resources/main \
  nitin.a2operators.O2ArithmaticOperators
```

Expected output, verified by `scripts/verify-doc-examples.sh`:

```text
3
0
3
1
3
2
4
0
```

## Repository examples

- `src/main/java/nitin/a2operators/O2ArithmaticOperators.java`
- `src/main/java/nitin/a2operators/O8ShortCircuit.java`
- `src/main/java/nitin/a2operators/operators.md`
