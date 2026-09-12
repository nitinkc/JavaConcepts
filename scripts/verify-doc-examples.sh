#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."
./gradlew classes --quiet

classpath="build/classes/java/main:build/resources/main"
status=0

verify() {
    local class_name="$1"
    local expected="$2"
    local actual
    actual="$(mktemp)"
    java --enable-preview \
        --add-exports=java.base/jdk.internal.vm=ALL-UNNAMED \
        -cp "$classpath" "$class_name" >"$actual"
    if ! diff -u "$expected" "$actual"; then
        status=1
    fi
    rm -f "$actual"
}

verify nitin.a2operators.O2ArithmaticOperators docs/generated-output/arithmetic-operators.txt
verify nitin.a5object.AnimalDoctor docs/generated-output/polymorphism.txt
verify nitin.a6oops.interfaces.AnotherServiceProvider docs/generated-output/interfaces.txt
verify nitin.LambdaExpressions.L1BasicWithListIteration docs/generated-output/lambda-iteration.txt

exit "$status"
