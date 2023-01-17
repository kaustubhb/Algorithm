Q. Use mathematical induction to prove that Euclid’s algorithm computes the 
greatest common divisor of any pair of nonnegative integers p and q.

A. **Proof by method of Induction**

Without loss of generality, let's assume `p >= q`.\
If `p < q`, then first recursive calls swaps the arguments\
`gcd(p, q) => gcd(q, p % q)`

**Induction base step**\
`q = 0`, in this case, `Euclid(p, q)` says `gcd(p, 0) = p`, which is true.

**Induction hypothesis step**\
Let `Euclid(p, q) = gcd(p, q)` forall q <= n 

**Inductive Step**\
Try to prove `Euclid(a, b) = gcd(a, b)` where `b > n`\
`Euclid(a, b) = Euclid(b, a % b)` &emsp;&emsp;    (1)

Now, `a % b` is strictly less than `b`, as `a % b` lies between `0` and `b - 1`\
Hence, by step 2, `Euclid(b, a % b) = gcd (b, a % b)` &emsp;&emsp;  (2)

It can be proven that `gcd(a, b) = gcd(b, a % b)`   &emsp;&emsp;  (3)\
From (2) and (3), `Euclid(b, a % b ) = gcd(a, b)`     (4)

From (4) and (1), `Euclid(a, b) = gcd(a, b)`\
Hence, proved.

---
Prove that `gcd(a, b) = gcd(b, a % b)`
1. Let c divide a & b, this implies c divides a % b as well.
2. Let d divide b and a % b, this implies d divides a as well.

Let `a = qb + r`\
`=> r = a - qb`\
It is easy to prove both statements above.

This implies `a`, `b`, and `a % b` have same common factors.\
This implies `gcd(a, b) = gcd(b, a % b)`







