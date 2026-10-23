# Office

Minsu is working alone in the office and is about to leave the company.
Suddenly, he finds that every door of his company is locked. To unlock
the doors, Minsu needs keys. Luckily, all of the doors at the company
are identical and he can open them with one key.

To help Minsu, he has a map which describes the location of the key and
the floor plan of the company. The company is a one-story building
measuring `R` in length and `C` in width. Minsu can only move in four
directions: up, down, left, and right. The time required for Minsu to
move from one place to another is 1. Find the minimum time needed for
him to go to an exit.

## Legends on the map

  Symbol   Meaning
  -------- ------------------------------------------------
  `X`      Wall
  `_`      Where Minsu can move from one place to another
  `O`      Exit
  `A`      Door
  `a`      Key

## Constraints

1.  At the moment of finishing his work, Minsu does not have a key with
    him.
2.  The doors are surrounded by walls except for the two directions in
    which the doors open.
3.  The outside of the company is completely surrounded by walls.
4.  The place where Minsu is first positioned is not a wall and keys are
    not there.
5.  The key is not placed on the wall, and there could be up to 5 keys.
6.  The key can be used several times.
7.  Movement can be performed in four directions: up, down, left and
    right on the map.

## Input

The first line contains `T`, the number of test cases. The first line of
each test case contains `R` (the vertical length of the company) and `C`
(the horizontal width of the company). The second line contains `r` (the
vertical coordinate of Minsu's location) and `c` (the horizontal
coordinate of Minsu's location) (`2 ≤ r ≤ R - 1`, `2 ≤ c ≤ C - 1`). Then
the following `R` lines describe what the company looks like on the map.

## Output

Print one line per test case. First print `#x` (`x` is a test case
number, starting from 1), insert a space, then print the time required.
However, if there is no possible way to leave the office, print `-1`
instead of the time.

## Example of Input and Output

### Input

``` text
3
6 6
2 4
XXXXXX
X____X
X_X_aX
XAXXXX
X___OX
XXXXXX
7 7
2 2
XXXXXXX
X____aX
X_XXXXX
X____aX
X_XXXXX
X__AAOX
XXXXXXX
5 10
2 5
XXXXXXXXXX
X__a__Aa_X
XAXXXXX__X
X_aXXXXXOX
XXXXXXXXXX
```

### Output

``` text
#1 12
#2 16
#3 8
```

## Additional sample output shown in the document

``` text
#1 12
#2 16
#3 8
#4 22
#5 33
#6 29
#7 22
#8 -1
#9 194
#10 447
```

## Limits and evaluation

-   Time limit: 1 second using C/C++, or 1.5 seconds using Java.
-   Memory limit: 256 MB.
-   Code length limit: 128 KB.
-   The document states that 40 test cases must be executed.
