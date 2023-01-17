<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<script type="text/x-mathjax-config"> MathJax.Hub.Config({ tex2jax: {inlineMath: [['$', '$']]}, messageStyle: "none" });</script>

Q. Develop a table like the one on page 181 for TwoSum.

A. Code
```java
public static int countPairs(int[] arr) {
  int count = 0;    // t0
  for (int i = 0; i < arr.length; ++i) {
    // t1
    for(int j = i + 1; j < arr.length; ++j) {
      // t2
      if(arr[i] + arr[j] == 0) {
        // t3
        ++count;
      }
    }
  }
  return count;
}
```

Let array length = n\
Number of time of condition is evaluated = x, as it is dependant on the input

|  Time |  Frequency  | Total Time  |
|-------|-------------|-------------|
| t0    | 1           |  t0         |
| t1    |  n          |  $n\cdot t1$      |
| t2    | $n\cdot (n-1)/2$  | $t2\cdot n\cdot (n-1)/2$   |
| t3    | x           |  $x\cdot t3$ |

Tilde approximation = ~$(t_2.n^2)/2$\
Order of growth = $n^2$