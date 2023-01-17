<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<script type="text/x-mathjax-config"> MathJax.Hub.Config({ tex2jax: {inlineMath: [['$', '$']]}, messageStyle: "none" });</script>


Q. Show that the number of different triples that can be chosen from N items is
precisely $N*(N-1)*(N-2)/6$.

A. Number of ways to choose 1st element $t_0$ of 3 tuple = N\
Number of ways to choose 2nd element $t_1$ without repetition = (N - 1)\
Number of ways to choose 3rd element $t_2$ = (N - 2)\
So, total number of ways to choose a unique tuple = $N*(N-1)*(N-2)$

The total number of ways includes all permutations of a tuple as well.\
(a, b, c) and (b, a, c) would be counted seperately.\
For each unique 3 tuple, there are 6 different configurations (3!)\
So, to calculate each tuple only once, the total number needs to be divided by 6.

Hence, number of triples = $N*(N-1)*(N-2)/6$