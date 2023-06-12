## Goal: largerThanFourNeighbors

Suppose we want to write a method:

```agsl
public static Dog[] largerThanFourNeighbors(Dog[] dogs)
```

This method will return a new array that contains every Dog 
that is larger than its 4 cloeset neighbors, 
i.e., the two on the left and the two in the right.

If there is not enough neighbors, i.e. you're at the end of the array, then consider just the 

For example:

- Input: Dogs with size [10, 20, 30, 25, 20, 40, 10]
- Returns: Dogs with size [30, 40].
  - 30 is greater than 10, 20, 25, and 20.
  - 40 is greater than 25, 20, and 10.

Another example:

- Input: Dogs with size [10, 15, 20, 15, 10, 5, 10, 15, 22, 20]
- Returns: [20, 22]