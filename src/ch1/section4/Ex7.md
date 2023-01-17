Q. Analyze ThreeSum under a cost model that counts arithmetic operations (and
comparisons) involving the input numbers.

A.
```java
public static int countTriples(int[] arr) {
  int count = 0;
  for (int i = 0; i < arr.length; ++i) {
    for (int j = i + 1; j < arr.length; ++j) {
      for (int k = j + 1; k < arr.length; ++k) {
        if (arr[i] + arr[j] + arr[k] == 0) {
          ++count;
        }
      }
    }
  }
  return count;
}
```

**Number of arithmetic operations:**\
Outer loop = `n` \
2nd loop = `n(n-1)/2`\
3rd loop = `n(n-1)(n-2)/6` for `k++` and `2*n(n-1)(n-2)/6` for if condition\
`x` for `++count`

**Number of comparisons**\
`n + n(n-1)/2 + n(n-1)(n-2)/6 + n(n-1)(n-2)/6`

**Tilde Approximation**
5N<sup>3</sup>/6
