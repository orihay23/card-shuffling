card-shuffling
==============

playing with ideas for shuffling--using merge-sort algorithm with a random seed

Based on a problem in the Cracking the Coding Interview book--working on a solution to shuffle cards in a random way (given that the we have a perfect random number generator).

-playing with a simple solution that does a merge-sort, but for every comparison, randomly compare based on the seed
-the math seemed to work out for me for four cards (4! = split into two sets of two, two choices for each, and then 3 sets of two choices for merging together (2*(2+2+2) + 2*(2+2+2))
-let me know what you think? (does my combinatorics make sense for 4 cards? does it hold up for 52? feedback on implementation?)

Have fun! Thanks!
