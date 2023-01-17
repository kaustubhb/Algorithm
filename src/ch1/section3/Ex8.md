Q. Give the contents and size of the array for ResizingArrayStack 
with the input\
`it was - the best - of times - - - it was - the - -`

A. top = 0\
Push 'it' -> top = 1, size = 1\
Push 'was' -> *resize* -> top = 2, size = 2\
Pop -> top = 1, size = 2\
Push 'the' -> top = 2, size = 2\
Push 'best' -> *resize* -> top = 3, size = 4\
Pop -> top = 2, size = 4\
Push 'of' -> top = 3, size = 4\
Push 'times' -> top = 4, size = 4\
Pop x 3 -> top = 1, size = 4 -> *resize* -> size = 2\
Push 'it' -> top = 2, size = 2\
Push 'was' -> *resize* -> top = 3, size = 4\
Pop -> top = 2, size = 4\
Push, Pop\
Pop -> top = 1, size = 4 -> *resize* -> top = 1, size = 2
