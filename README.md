# Java Concepts

A Gradle-based collection of Java learning examples accumulated across multiple Java releases. The repository contains 936 main-source files, 11 test files, and 549 directly runnable `main` methods.

## Documentation

The searchable syntax and concepts reference lives under `docs/` and is configured by `mkdocs.yml`.

```shell
python3 -m venv .venv
.venv/bin/pip install -r requirements-docs.txt
.venv/bin/mkdocs serve
```

Build the documentation with strict link and navigation validation:

```shell
.venv/bin/mkdocs build --strict
```

The generated site is written to `build/mkdocs`.

## Build

The project uses Java 26 preview features and the included Gradle wrapper.

```shell
./gradlew classes
./gradlew test
./gradlew spotlessCheck
scripts/verify-doc-examples.sh
```

Run an individual example after compiling:

```shell
java --enable-preview \
  --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED \
  -cp build/classes/java/main:build/resources/main \
  nitin.LambdaExpressions.L1BasicWithListIteration
```

## Reference sections

- [Documentation home](docs/index.md)
- [Syntax reference](docs/syntax/index.md)
- [Repository inventory](docs/audit/repository-inventory.md)
- [Retention report](docs/audit/retention-report.md)
- [Reorganization plan](docs/audit/reorganization-plan.md)
- [Current source map](docs/appendix/source-map.md)

## Important repository characteristics

- This is a learning and recipe collection, not a single application.
- Most examples are independent classes with their own entry points.
- Existing comments and progressive examples are preserved as educational material.
- Legacy APIs remain where they provide useful comparison with modern Java.
- Preview and internal-JDK examples require the flags configured in `build.gradle`.
