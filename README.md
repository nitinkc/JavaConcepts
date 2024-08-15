# Java Concepts

Gradle based project

## Number of files while reorganization

find . -type f -name '*.java' | wc -l 798

Gradle upgrade branch

find . -type f -name '*.java' | wc -l 795

# New features
tasks.withType(JavaCompile) {
options.compilerArgs += [
'--add-exports=java.base/jdk.internal.vm=ALL-UNNAMED',
'--enable-preview'
]
}
tasks.withType(JavaExec) {
jvmArgs += [
'--add-exports=java.base/jdk.internal.vm=ALL-UNNAMED',
'--enable-preview'
]
}
# Topics
[src/main/java/nitin/flowControl/FlowControl.md](src/main/java/nitin/a4flowControl/FlowControl.md)

[src/main/java/nitin/a2operators/operators.md](src/main/java/nitin/a2operators/operators.md)

[src/main/java/nitin/accessModifiers/final/notes.md](src/main/java/nitin/a3accessModifiers/final/notes.md)

[src/main/java/nitin/object/notes.md](src/main/java/nitin/a5object/notes.md)

[src/main/java/nitin/a1languageFundamentals/Notes.md](src/main/java/nitin/a1languageFundamentals/Notes.md)

[src/main/java/nitin/generic/examples/readMe.md](src/main/java/nitin/generic/examples/readMe.md)

[src/main/java/nitin/generic/oReilly/a3Max/readMe.md](src/main/java/nitin/generic/oReilly/a3Max/readMe.md)

[src/main/java/nitin/generic/oReilly/a4sorting/ReadMe.md](src/main/java/nitin/generic/oReilly/a4sorting/ReadMe.md)

[src/main/java/nitin/generic/oReilly/a6erasure/ReadMe.md](src/main/java/nitin/generic/oReilly/a6erasure/ReadMe.md)

[src/main/java/nitin/exceptionHandling/commonExceptions/common-unchecked-exceptions.md](src/main/java/nitin/exceptionHandling/commonExceptions/common_unchecked_exceptions.md)

# Resources


Java Application Performance Tuning and Memory Management
- Matt Greencroft - Udemy

Java 21 Virtual Threads, Multithreading, Structured Concurrency, Scoped Values, Continuations and use with Spring Boot 
- Viraj Shetty - Udemy

Become an expert in Multithreading, Concurrency & Parallel programming in Java, with strong emphasis on high performance
- Michael Pogrebinsky

![https://www.youtube.com/watch?v=q2T9NlROLqw](https://www.youtube.com/watch?v=q2T9NlROLqw)
