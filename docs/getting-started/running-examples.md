# Running documented examples

MkDocs produces a static site, so Java programs do not execute inside the documentation server. This site uses verified precomputed output instead: readers see the expected result immediately, while repository checks execute selected programs and detect stale output.

## Status labels

| Label | Meaning |
| --- | --- |
| Runnable | Has a directly invokable entry point |
| Deterministic output | Repeated executions should produce the documented text |
| Stable Java | Does not rely on preview or internal APIs |
| Java 8+ | Introduced with Java 8 and supported by the configured JDK |
| Java 26 | Requires the repository's configured toolchain |
| Preview | Requires `--enable-preview` |
| Internal API | Uses unsupported JDK implementation packages |
| Requires network | Contacts an external service |
| Requires input | Needs arguments, standard input, or a fixture |

## Verify documented output

```shell
scripts/verify-doc-examples.sh
```

The script:

1. compiles the main source set;
2. runs each selected deterministic program with the repository classpath;
3. captures standard output in a temporary file;
4. compares it with the corresponding file under `docs/generated-output`;
5. fails and prints a unified diff when output changes.

## Add another verified example

1. Choose a quick program that exits without user interaction.
2. Avoid timestamps, random values, thread-order-dependent output, network calls, and machine-specific paths.
3. Compile and run the program locally.
4. Save its exact output under `docs/generated-output/<example>.txt`.
5. Add the class and output path to `scripts/verify-doc-examples.sh`.
6. Add its command, output, and status labels to the relevant reference page.
7. Run the verification script and `mkdocs build --strict`.

## Nondeterministic examples

Concurrency demonstrations, random-number programs, benchmarks, clocks, and network clients may still be documented, but their output should be described rather than compared byte-for-byte. Label the reason and provide a representative output block only when it cannot be mistaken for an exact result.

## Security boundary

The documentation site does not submit code to an external service and does not provide a server that executes arbitrary reader input. This keeps the site deployable as static content and avoids exposing a remote code-execution service.
