# Exceptions

## Basic handling

```java
try {
    int value = Integer.parseInt(text);
    System.out.println(value);
} catch (NumberFormatException exception) {
    System.err.println("Not an integer: " + text);
}
```

Catch the most specific exception that the current boundary can handle meaningfully.

## Checked and unchecked exceptions

- Checked exceptions derive from `Exception` but not `RuntimeException`; callers must catch or declare them.
- Unchecked exceptions derive from `RuntimeException`; they often indicate invalid arguments, state, or programming mistakes.
- Errors derive from `Error` and generally are not application recovery mechanisms.

## Throwing and declaring

```java
static int requirePositive(int value) {
    if (value <= 0) {
        throw new IllegalArgumentException("value must be positive");
    }
    return value;
}

static String read(Path path) throws IOException {
    return Files.readString(path);
}
```

## Try-with-resources

```java
try (var lines = Files.lines(path)) {
    lines.forEach(System.out::println);
}
```

Resources implementing `AutoCloseable` are closed automatically, including when an exception occurs. Prefer this to manual closing in `finally`.

## Multiple exceptions

```java
catch (IOException | SecurityException exception) {
    System.err.println(exception.getMessage());
}
```

Alternatives in a multi-catch cannot have a subtype relationship.

## Repository examples

- `src/main/java/nitin/exceptionHandling`
- `src/main/java/nitin/io/fileIO/readfiles1/AllPalindromes.java`
- `src/main/java/nitin/io/fileIO/readfiles2/FileUtils.java`
