---
title: Scoped Value
date: 2024-07-27 20:17:00
categories:
- Multithreading
tags:
- Java
- Java 21
---

{% include toc title="Index" %}

[https://openjdk.org/jeps/446](https://openjdk.org/jeps/446)

Immutable and better way to share data between threads

Scoped Value are only available for use within the **dynamic scope** of the
method

# Advantages

- during the bounded period of execution of a method
- bound during start of scope and unbounded during end of scope (even exception)
- Rebinding allowed but cannot modify Scoped Value
- No cleanup required. Automatically handled

# Bind the Scoped Values to the Object

all methods return boolean
`boolean result = ScopedValue.callWhere(studentScopedValue, hp, CallableClass::methodName);`

```java
//bind a key (studentScopedValue) to a value (hp) with an operation op (handleUser())
ScopedValue.callWhere(studentScopedValue, hp, CallableClass::methodName);//using a callable

//binds studentScopedValue with harryPotter Object within the scope of the method voidMethodCall
ScopedValue.runWhere(studentScopedValue, hp, RunnableClass::voidMethodCall);//using runnable, void method call

//binds studentScopedValue with harryPotter Object within the Supplier method voidMethodCall
ScopedValue.getWhere(studentScopedValue, hp, Class::supplierMethodCall);
```

For multiple scopes

```java
// ScopedValues for managing different pieces of data
public static final ScopedValue<Student> studentScope = ScopedValue.newInstance();
public static final ScopedValue<Department> deptScope = ScopedValue.newInstance();

ScopedValue.where(studentScope, harrpPotter)
           .where(deptScope,gryffindor)
           .call(Class::method);
```

# Get the Scoped Value

Return the value if bound, else return a default value

```java
Student requestStudent = studentScopedValue.orElse(new Student("Harry Potter"));
```

Return the value if bound, else throw an exception

```java
Student requestStudent = studentScopedValue.orElseThrow(() -> new RuntimeException("Not Bound");
```

Scoped values are not available for Child threads except the ones initiated with
**StructuredTaskScope**

This is because threads started from StructuredTaskScope block are
**guaranteed to complete** before the **try-with-resources block ends** and THUS
remains within the scope of the ScopedValue.