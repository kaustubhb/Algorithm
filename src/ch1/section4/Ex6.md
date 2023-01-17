Q. Give the order of growth (as a function of N ) of the running times of each 
of the following code fragments:

(1)
```java
int sum = 0;
  for (int n = N; n > 0; n /= 2)
    for(int i = 0; i < n; i++)
      sum++;
```

A. Outer loop is executed log(N) times.\
Inner loop is excuted n times for each outer loop.

Total execution time is \
N + N/2 + N/2 + N/8 + ... 1
= 2N

(2) 
```java
int sum = 0;
for (int i = 1 i < N; i *= 2)
  for (int j = 0; j < i; j++)
    sum++;
```
Same as previous, 2N

(3)
```java
int sum = 0;
for (int i = 1 i < N; i *= 2)
  for (int j = 0; j < N; j++)
    sum++;
```
N*log(N)