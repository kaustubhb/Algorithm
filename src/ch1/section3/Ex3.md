Q. Suppose that a client performs an intermixed sequence of (stack) 
push and pop operations. The push operations put the integers 0 through 
9 in order onto the stack;  the pop operations print out the return 
values. Which of the following sequence(s) could not occur?

1. 4 3 2 1 0 9 8 7 6 5 \
Yes. Sequence which prints this is \
`0 1 2 3 4 - - - - 5 6 7 8 9 - - - - -`

2. 4 6 8 7 5 3 2 9 0 1 \
No, After 9, 1 will be popped instead of 0.\
`0 1 2 3 4 - 5 6 - 7 8 - - - - - 9 - X`

3. 2 5 6 7 4 8 9 3 1 0 \
Yes,\
`0 1 2 - 3 4 5 - 6 - 7 - - 8 - 9 - - - -`

4. 4 3 2 1 0 5 6 7 8 9 \
Yes \
`0 1 2 3 4 - - - - - 5 - 6 - 7 - 8 - 9 -`

5. 1 2 3 4 5 6 9 8 7 0 \
Yes \
`0 1 - 2 - 3 - 4 - 5 - 6 - 7 8 9 - - - 0`

6. 0 4 6 5 3 8 1 7 2 9 \
No, trying to pop 1 after 8 \
`0 - 1 2 3 4 - 5 6 - - - 7 8 - X`

7. 1 4 7 9 8 6 5 3 0 2 \
No, trying to pop 0 after 3 \
`0 1 - 2 3 4 - 5 6 7 - 8 9 - - - - - X`

8. 2 1 4 3 6 5 8 7 9 0 \
Yes
`0 1 2 - - 3 4 - - 5 6 - - 7 8 - - 9 - -`
