A pure function is essentially one where the return value, the result of that 
function, depends only on its arguments.  There are no variations and there are
no side effects. 

So, if we had a pure function and we call it, let's say, three and seven as arguments, the mechanism of the pure function always produces the same result for the same arguments; so, perhaps 10 in this case, if it were adding them together. 

Further, a pure function does not do anything else.
 
By contrast, a regular function, or an impure one, if we call it with three and seven, the mechanism might return different values for different invocations, even with the same arguments. 

It might for example look something up in a database; it might look up three and get 99 as a result (from the db call) and then produce a result of 106. 

It might also write things to the database. 

Pure functions are idempotent. Can be run many times without any effect.

Improves concurrency as multiple pure functions can be executed in parellel wihout any sideeffects.


