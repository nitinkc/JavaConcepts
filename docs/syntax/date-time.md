# Date and time

## Modern API

Prefer the immutable classes in `java.time`.

```java
LocalDate date = LocalDate.of(2026, Month.SEPTEMBER, 11);
LocalTime time = LocalTime.of(14, 30);
LocalDateTime local = LocalDateTime.of(date, time);
```

## Formatting and parsing

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
String text = local.format(formatter);
LocalDateTime parsed = LocalDateTime.parse(text, formatter);
```

`DateTimeFormatter` is immutable and thread-safe.

## Time zones

```java
ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
ZonedDateTime eastern = utc.withZoneSameInstant(ZoneId.of("America/New_York"));
```

Use region IDs when daylight-saving rules matter. A numeric offset alone does not contain future or historical zone rules.

## Durations and periods

```java
Period age = Period.between(birthDate, LocalDate.now());
Duration elapsed = Duration.between(startInstant, endInstant);
```

`Period` models date-based units; `Duration` models time-based seconds and nanoseconds.

## Legacy APIs

`java.util.Date`, `Calendar`, `SimpleDateFormat`, and deprecated date constructors remain in the repository for comparison. Avoid them in new code; `SimpleDateFormat` is mutable and not thread-safe.

## Repository examples

- `src/main/java/nitin/calandarDateTime/java8Calandar/L1LocalDateTime.java`
- `src/main/java/nitin/calandarDateTime/java8Calandar`
- `src/main/java/nitin/calandarDateTime/old`
