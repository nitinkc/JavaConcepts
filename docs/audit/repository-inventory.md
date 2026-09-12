# Repository inventory

Inventory date: 2026-09-11

## Scope

Java Concepts is a Gradle learning and recipe repository rather than a single application. Most classes are independent demonstrations, and 549 main-source classes have a `public static void main` entry point.

## Counts

| Area | Java files |
| --- | ---: |
| `src/main/java` | 936 |
| `src/test/java` | 11 |
| Total | 947 |
| Markdown files | 29 |
| Main resources | 25 |

The README's historical counts of 798 and 795 Java files are no longer current.

## Main source groups

| Group | Files | Intended role |
| --- | ---: | --- |
| `nitin` | 811 | Java language, library, JVM, and exercise examples |
| `com` | 111 | Shared configuration, converters, entities, and utilities |
| `sandbox` | 14 | Unclassified experiments and puzzles |

## Topic inventory under `nitin`

| Current topic | Files | Canonical documentation section |
| --- | ---: | --- |
| Root-level examples | 6 | Appendix / unclassified examples |
| `a1languageFundamentals` | 7 | Language fundamentals |
| `a2operators` | 12 | Operators and expressions |
| `a3accessModifiers` | 8 | Classes and access control |
| `a4flowControl` | 5 | Control flow |
| `a5object` | 10 | Objects and `Object` |
| `a6oops` | 64 | Object-oriented programming |
| `annotations` | 6 | Type system and metadata |
| `arrays` | 8 | Arrays |
| `LambdaExpressions` | 22 | Functional Java / lambdas |
| `calandarDateTime` | 22 | Date and time |
| `classLoadingJVM` | 9 | JVM and class loading |
| `cloning` | 7 | Object copying |
| `collections` | 53 | Collections |
| `currency` | 1 | Applied examples |
| `enumConcept` | 7 | Enums |
| `escapingReferences` | 7 | Encapsulation and defensive copying |
| `exceptionHandling` | 20 | Exceptions |
| `garbageCollection` | 3 | JVM memory management |
| `generic` | 49 | Generics |
| `io` | 66 | I/O, files, and networking |
| `JDBC` | 1 | Database access |
| `mappers` | 25 | Mapping and serialization libraries |
| `multithreading` | 156 | Concurrency |
| `nestedClasses` | 6 | Nested and inner classes |
| `optionals` | 5 | `Optional` |
| `performance` | 13 | Performance |
| `reactiveProgramming` | 6 | Reactive programming |
| `recursion` | 2 | Algorithms / recursion |
| `reflectionAPI` | 7 | Reflection |
| `regex` | 2 | Regular expressions |
| `serialization` | 10 | Java and JSON serialization |
| `socketTCP` | 2 | Networking |
| `stats` | 1 | Applied examples |
| `streams` | 91 | Streams and collectors |
| `strings` | 15 | Strings and text |
| `zKnowYourJava` | 18 | Exercises and language puzzles |
| `zOReiley2020SimonRoberts` | 42 | Course/book-derived exercises |
| `zkcura` | 18 | Exercises / needs attribution review |

## Shared source inventory under `com`

| Current topic | Files | Intended role |
| --- | ---: | --- |
| `config` | 1 | Resource path configuration |
| `converter` | 17 | Conversion demonstrations |
| `entity` | 75 | Shared data models and API payload models |
| `utilities` | 18 | Shared helper code |

## Tests

The 11 tests cover selected date-time conversion, Jackson mapping, architecture metrics, `CompletableFuture`, and synchronization examples. Most runnable examples are not automatically verified.

## Existing prose

Documentation currently consists of:

- a small root README;
- notes beside fundamentals, operators, access modifiers, flow control, objects, interfaces, exceptions, and generics;
- REST utility notes;
- a substantial multithreading blog backup;
- a continuation README.

The root README has stale display paths and at least one filename mismatch. Existing prose should be migrated and corrected rather than discarded.

## Naming issues to normalize incrementally

- `LambdaExpressions` uses an uppercase package segment.
- `calandarDateTime` and `java8Calandar` misspell “calendar.”
- `ReadMe.md`, `readMe.md`, `README.md`, and `notes.md` vary in casing.
- Number prefixes (`a1` through `a6`) encode an old learning order but do not scale to the full repository.
- `zKnowYourJava`, `zOReiley2020SimonRoberts`, and `zkcura` use sorting prefixes instead of topic names.
- Several packages use mixed conventions such as `fileIO` and `reflectionAPI`.

These names should not be changed globally in one operation. Documentation can use canonical topic names while source packages are migrated in small verified batches.
