# Reorganization plan

## Principles

1. Preserve educational comments and runnable examples.
2. Treat source code as the ground truth for documentation.
3. Separate generated output from input fixtures.
4. Move one coherent topic at a time.
5. Compile and test after every package migration.
6. Keep an old-to-new path map for every move.
7. Do not combine formatting changes with package moves.

## Canonical taxonomy

```text
examples
├── fundamentals
│   ├── syntax
│   ├── operators
│   ├── controlflow
│   ├── arrays
│   └── strings
├── oop
│   ├── objects
│   ├── access
│   ├── inheritance
│   ├── polymorphism
│   ├── interfaces
│   ├── nestedclasses
│   └── copying
├── types
│   ├── generics
│   ├── enums
│   ├── annotations
│   ├── records
│   ├── sealedclasses
│   └── patternmatching
├── functional
│   ├── lambdas
│   ├── optional
│   ├── streams
│   └── collectors
├── collections
├── errors
├── io
│   ├── files
│   ├── serialization
│   ├── networking
│   └── dataformats
├── datetime
│   ├── legacy
│   └── modern
├── concurrency
│   ├── threads
│   ├── synchronization
│   ├── locks
│   ├── executors
│   ├── futures
│   ├── completablefuture
│   ├── collections
│   ├── virtualthreads
│   └── structuredconcurrency
├── jvm
├── libraries
├── algorithms
└── exercises
```

The MkDocs navigation should use this taxonomy immediately. Physical package migration can follow gradually.

## Batch 0: baseline and audit

- Record source counts and current package boundaries.
- Record build, test, and formatting status.
- Identify exact and near duplicates.
- Classify generated output and stable input fixtures.
- Create this audit documentation.

The initial baseline found that Gradle 8.14 could not run on the installed Java 26.0.2 runtime. The wrapper was upgraded to Gradle 9.4.1, which supports Java 26, and refreshVersions was upgraded to 0.60.6 for Gradle 9 compatibility. Source compilation and tests now pass. Spotless runs with google-java-format 1.36.1 and reports two pre-existing violations in `SwitchExpressions.java` and `zJavaPuzzles.java`.

## Batch 1: generated output isolation

Low-risk first implementation batch:

1. Add one shared output-directory convention under `build/example-output/`.
2. Update file-writing and serialization examples to create parent directories.
3. Give each example an independent output path.
4. Verify each example produces its expected output.
5. Present the now-unreferenced tracked outputs for deletion approval.

This batch changes behavior only for output location and avoids package renames.

## Batch 2: documentation extraction without package moves

- Create the MkDocs skeleton.
- Migrate existing Markdown from source directories into canonical documentation topics.
- Convert Jekyll-specific blog syntax.
- Link documentation pages back to unchanged source paths.
- Establish the page template and snippet policy.

## Batch 3: fundamentals migration

Proposed mapping:

| Current path | Canonical package |
| --- | --- |
| `nitin.a1languageFundamentals` | `examples.fundamentals.syntax` |
| `nitin.a2operators` | `examples.fundamentals.operators` |
| `nitin.a4flowControl` | `examples.fundamentals.controlflow` |
| `nitin.arrays` | `examples.fundamentals.arrays` |
| `nitin.strings` | `examples.fundamentals.strings` |

Migrate one row at a time and update imports, tests, documentation links, and run instructions atomically.

## Batch 4: object-oriented and type-system migration

Migrate access modifiers, objects, OOP examples, nested classes, cloning, escaping references, enums, annotations, and generics. Preserve course-like numbered sequencing as documentation metadata rather than package-name prefixes.

## Batch 5: functional and collections migration

Migrate lambdas, optionals, streams, collectors, and collections. Preserve progressive loop-to-lambda and imperative-to-stream comparisons.

## Batch 6: I/O, serialization, date-time, and integrations

Migrate I/O only after output isolation. Keep legacy date-time examples in a clearly labeled legacy namespace and correct `calandarDateTime` during this batch.

## Batch 7: concurrency and JVM topics

Move concurrency last because it is the largest topic at 156 files and includes preview features and internal APIs. Split stable, preview, and internal-API examples in documentation and verification.

## Batch 8: exercises and sandbox

Classify root-level examples, `z*` course/exercise packages, and sandbox classes by concept. Preserve source attribution where material came from a book, course, or external exercise.

## Verification gate for every batch

- `./gradlew classes`
- `./gradlew test`
- `./gradlew spotlessCheck`
- verify changed example entry points;
- verify MkDocs links and snippet references;
- compare Java file counts against intentional additions/deletions;
- inspect `git diff --summary` to ensure moves are represented as renames where possible.

## MkDocs delivery sequence

1. Site configuration and navigation.
2. Getting started and example-running guide.
3. Language syntax reference.
4. OOP and type-system reference.
5. Lambdas, streams, and collections.
6. I/O, serialization, and date-time.
7. Concurrency and modern Java.
8. Libraries, JVM, algorithms, and exercises.
9. Generated source and package indexes.
10. Link, snippet, and site-build validation.
