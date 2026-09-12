# Build and run

## Requirements

- JDK 26
- The included Gradle wrapper
- Python 3.10 or newer for the documentation site

## Compile the examples

```shell
./gradlew classes
```

The build enables Java 26 preview features and exports an internal JVM package used by continuation experiments.

## Run tests

```shell
./gradlew test
```

## Check formatting

```shell
./gradlew spotlessCheck
```

## Run one example

There is no single application entry point. Compile first, then invoke the fully qualified class name:

```shell
java --enable-preview \
  --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED \
  -cp build/classes/java/main:build/resources/main \
  nitin.LambdaExpressions.L1BasicWithListIteration
```

Many examples are independent programs. Some require input files, external services, or internal APIs; check the corresponding reference page before running them.

## Verify documented program output

```shell
scripts/verify-doc-examples.sh
```

## Build the documentation

```shell
python3 -m venv .venv
.venv/bin/pip install -r requirements-docs.txt
.venv/bin/mkdocs build --strict
```

The generated site is written to `build/mkdocs`.
