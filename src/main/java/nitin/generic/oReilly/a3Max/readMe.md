# Stream.max

Signature from Stream<T>

> Optional<T> max(Comparator<? super T) comparator)

the max method is going to apply on a stream, and it's going to return a single value.

Now if it turns out that during the stream processing there are no elements left in the stream, then what is the max
method supposed to do? Well, the decision was made to have it return an empty optional.

So if there are no elements in the stream, we'll get back and empty optional if there are any elements in the stream and
it is able to determine the maximum value, then it'll give us that maximum value wrapped in an optional so that we can
then extract it later.


