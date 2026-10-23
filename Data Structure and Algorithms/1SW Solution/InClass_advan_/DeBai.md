# SW Certificate — Problem Statement

## Time Limit

5000 test inputs must be executed within 1 second using C/C++, or 1.5 seconds using Java.

## Memory Limit

Stack: 1 Mbytes / Total: 256 Mbytes

## Code Length Limit

128 Kbytes

## Evaluation

When you submit an answer, the result will be shown in real time.

If the answer is correct in all cases, it is Pass, otherwise, it is Fail.

## Problem

Given a natural number `N`, repeat the following operation so that the number becomes `1`.

1. If `N` is an odd number, `N ← N + 1`.
2. If `N` is an even number, `N ← N / 2`.

Assume that `F(N)` is the number of operations until `N` becomes `1`. The table below shows `F(N)` for values from 1 to 8.

| `N` | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
|---|---:|---:|---:|---:|---:|---:|---:|---:|
| `F(N)` | 0 | 1 | 3 | 2 | 5 | 4 | 4 | 3 |

For example, when `N = 3`, `N` becomes `3 + 1 = 4` using operation #1. Next, `4 / 2 = 2` using operation #2. Then, the next operation also uses operation #2, and `N` becomes `2 / 2 = 1`. Since `N = 1`, the operation ends.

Make a program that calculates the value of

`F(A) + F(A+1) + ... + F(B)`

by receiving two natural numbers `A` and `B` as input (`A ≤ B`). If `A = B`, find `F(A)`.

## Constraints

1. `A` and `B` are natural numbers from `1` to `10^15`.
2. `A ≤ B` holds.

## Input

On the first line, the number `T` of test cases is given. Then `T` test cases are given. Each case has one line with `A` and `B` given.

## Output

Output the answers of each test case to the standard output in order. For each test case, output `#x`, leave a space, and then output the answer for the relevant case.

## Example of Input and Output

### Input

```text
5
1 1
2 2
3 8
1 16
1 1000000000000000
```

### Output

```text
#1 0
#2 1
#3 21
...
```
