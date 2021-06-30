# Max

Implement `max` method of [`MaxMethod`](src/main/java/com/epam/rd/autotasks/max/MaxMethod.java) class.\
It has following signature:
```java
public static OptionalInt max(int[] values)
```
The correct implementation should receive an array of `int` values and return its maximum value wrapped in
[`OptionalInt`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/OptionalInt.html) object.\
Consider that `values` may be an empty array or even `null`, in that case the implementation should return the result of
[`empty`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/OptionalInt.html#empty()) static method 
of `OptionalInt` class.\
`values` may contain any `int` value between `Integer.MIN_VALUE` and `Integer.MAX_VALUE`.

Method usage example:
```java
int[] vals = new int[]{-2, 0, 10, 5};
OptionalInt result = MaxMethod.max(vals);
System.out.println(result.getAsInt() == 10); // true
vals = null;
result = MaxMethod.max(vals);
System.out.println(result.isEmpty()); // true
```