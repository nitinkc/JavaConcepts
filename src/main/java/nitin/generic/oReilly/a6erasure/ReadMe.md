# Type Erasure

[JavaDoc for Type Erasure](https://docs.oracle.com/javase/tutorial/java/generics/erasure.html)

the generics exist at compile time and are enforced at compile time, but the compiler removes them. It erases them. It
replaces them with references of type object or bounded references at runtime so that the generic types don't actually
exist at runtime at all.

Now, this has a lot of consequences and is a subject of some criticism of the language for that reason.

So there are certain rules that apply.

![image]()

When types are being erased at compile time, if you have a bounded wild card, then the type parameter is replaced with
the bound itself. If they are unbounded, you just get Object. And it will insert casts wherever needed. And there can be
special cases where bridge methods are generated in order to preserve polymorphism. Now, I'm not overly concerned with
the bridge methods or anything like that. There's plenty of information out there if you want to dig into it. Again, my
goal here is to make it so that you could interpret what's going on in the Java 8 API in a productive fashion.
  