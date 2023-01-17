<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>
<script type="text/x-mathjax-config"> MathJax.Hub.Config({ tex2jax: {inlineMath: [['$', '$']]}, messageStyle: "none" });</script>

Q. Give a formula to predict the running time of a program for a problem of 
size N, when doubling experiments have shown that the doubling factor is $2^b$
and the running time for problems of size $N_0$ is T.

A. Given, \
$f(N_0) = T$, where f(N) is running time of algorithm with input size N

Also, given that\
$f(2N) = 2^b\cdot f(N/2)$

Therefore, $f(2N_0) = 2^b\cdot T$\
or, $f(2^a\cdot N_0) = 2^{ab}\cdot T$

Now, let $N = 2^a\cdot N_0$\
$\implies N/N_0 = 2^a$\
$\implies f(N) = T\cdot (N/N_0)^b$