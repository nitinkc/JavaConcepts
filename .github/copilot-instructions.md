Purpose
-------
Quick, actionable guidance for AI coding agents that must be immediately productive in this repository.

High-level picture
------------------
- This is a large Gradle-based Java code collection (not a single Spring app). It is a learning/recipes repository: many small example classes grouped by topic under `src/main/java/nitin/` and utility code under `src/main/java/com/`.
- There is no single entrypoint or server. Most useful work will be reading, updating, and running individual example classes (many contain `public static void main`).

Essential files & conventions
----------------------------
- Build: `build.gradle` + Gradle wrapper (`./gradlew`). Use the wrapper to build and run tasks.
- Versions/catalog: `versions.properties` and `gradle/libs.versions.toml` (refreshVersions was used). Do not manually split the generated `versions.properties` comments.
- Formatting: Spotless with `googleJavaFormat` configured in `build.gradle`. Run `./gradlew spotlessApply` to auto-format.
- Language level: project uses Java 26 preview features. See `--enable-preview` and `--add-exports=java.base/jdk.internal.vm=ALL-UNNAMED` in `build.gradle` and examples under `src/main/java/nitin/multithreading/cVirtualThreads/...` which import `jdk.internal.vm.*`.
- Annotation processors: Lombok and MapStruct are configured (compileOnly + annotationProcessor). Ensure IDE annotation processing is enabled when editing.
- Local flat dependency: `build.gradle` includes a `flatDir` reference to `../Utilities/build/libs`. That external module may be required locally.

Common workflows (commands)
---------------------------
- Build and compile classes (use wrapper):
  - `./gradlew clean build` — builds jar, runs tests (JUnit 5 + some JUnit4 artifacts configured).
  - `./gradlew classes` — compile sources only (useful before running a single demo class).
- Run a demo/main class (no application plugin). Preferred approach:
  1. `./gradlew classes`
 2. `java --enable-preview --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED -cp build/classes/java/main:build/resources/main <fully.qualified.ClassName>`
  Example: to run `src/main/java/nitin/LambdaExpressions/L1BasicWithListIteration.java`:
  `java --enable-preview -cp build/classes/java/main:build/resources/main nitin.LambdaExpressions.L1BasicWithListIteration`
- Formatting: `./gradlew spotlessApply` to auto-fix code style.
- Tests: `./gradlew test` (uses JUnit Platform / JUnit Jupiter). Test JVM args set to `--enable-preview` in `build.gradle`.
- Sonar/local checks: Sonar plugin is added but configured to skip compile in local settings.

Patterns & project-specific notes
--------------------------------
- Educational layout: many directories under `src/main/java/nitin/` are topic-focused (e.g., `a1languageFundamentals`, `a4flowControl`, `multithreading`). Look for `ReadMe.md` files alongside examples to understand intent.
- Many files are runnable examples rather than library code. Treat changes to these as example updates, not API-stable refactors.
- Search strategy: find runnable examples with `grep "public static void main"` or explore `src/main/java/nitin/**/ReadMe.md` for guided walkthroughs.
- Java preview + internal APIs: several multithreading examples import `jdk.internal.vm.Continuation` and require `--add-exports`. Preserve the `jvmArgs`/`compilerArgs` in `build.gradle` when editing those files.
- Annotation processors: MapStruct and Lombok are used together; code that uses generated mappers requires running a full build to produce sources.
- Dependencies: both reactive stacks are present (`rxjava3` and `reactor-core`) — be careful mixing semantics when refactoring reactive examples.

Integration, external deps & debug hints
--------------------------------------
- Local extra lib: `../Utilities/build/libs` referenced by `flatDir` — if a compile error complains about missing classes, build that Utilities project or remove the dependency reference.
- IDE: `.idea/compiler.xml` contains the same additional compiler options; double-check IDE settings if preview features don't compile locally.
- Long-running / heavy resources: some examples read large files in `src/main/resources` (word-lists, csv). Use small inputs when iterating.

Quick examples for agents (copyable)
-----------------------------------
- Build everything:
  `./gradlew clean build --no-daemon`  (use wrapper and avoid relying on system Gradle)
- Run a single example after compile:
  `./gradlew classes && java --enable-preview -cp build/classes/java/main:build/resources/main nitin.multithreading.ParallelFactorial`
- Apply formatting before opening a PR:
  `./gradlew spotlessApply`

Where to look first (priority)
-----------------------------
1. `build.gradle` — build flags, formatting, annotation processors, flatDir.
2. `versions.properties` and `gradle/libs.versions.toml` — dependency versions and catalog.
3. `src/main/java/nitin/multithreading/cVirtualThreads` — example of preview/internal-API usage and why `--add-exports` exists.
4. `src/main/java/nitin/**/ReadMe.md` — per-topic notes and run instructions.

Limitations for agents
---------------------
- No central app or API surface: many one-off examples, so changes should be scoped and documented.
- Do not remove `--enable-preview` or `--add-exports` without checking multithreading examples.
- Keep formatting consistent: run Spotless before committing.

Contacts / PR hygiene
---------------------
- Add short note in the modified example's `ReadMe.md` when changing behavior of an educational example.
- Run `./gradlew test` and `./gradlew spotlessCheck` locally in CI/PR.

README-index
------------
- This file is a concise agent-oriented summary. Use repository `README.md` for broader human-focused notes`.
