# Max method

Implement `max` method of [`MaxMethod`](src/main/java/com/epam/rd/autotasks/max/MaxMethod.java) class.\
It has following signature:
```java
public static int max(int[] values)
```
The correct implementation should receive an array of `int` values and return its maximum value.\
Consider that `values` may not be an empty array or `null`, `max` method must not modify the array,
`values` may contain any `int` value between `Integer.MIN_VALUE` and `Integer.MAX_VALUE`. 

Method usage example:
```java
int[] vals = new int[]{-2, 0, 10, 5};
int result = MaxMethod.max(vals);
System.out.println(result == 10); // true
```
