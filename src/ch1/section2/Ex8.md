Q. Suppose that `a[]` and `b[]` are each integer arrays consisting of millions
of integers. What does the follow code do? Is it reasonably efficient?

```
int[] t = a; a = b; b = t;
```

A. This code just swaps references, integers are not really moved. So it is very
efficient.