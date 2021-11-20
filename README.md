# CS 430 IIT N machine M jobs Problem
## Goals
The goal of this assignment was to optimize the N MACHINE M JOB algorithm such that it ran in n log n time.  (We hit n^2).  Bummer!

## Test Cases 

The uploaded .txt file that has the orders returned the following for 3 machines:

--- Machine Count 3---

You reached else statement X times.

--Orders Remaining--

[1, 5]
[2, 6]
[1, 7]

Machine {  name=0, schedule=[[0, 1], [0, 0], [2, 3], [3, 5], [3, 5], [0, 0], [0, 0], [0, 0], [8, 9], [0, 0], [0, 0]]}

Machine {  name=1, schedule=[[0, 2], [0, 2], [2, 4], [2, 4], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [9, 11], [9, 11]]}

Machine {  name=2, schedule=[[0, 0], [0, 0], [0, 0], [3, 4], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0]]}

## Objects
It was easier to think about using an object to manipulate a schedule versus just using 2d arrays.  Though for the most part, the effect is the same.

## Further Analysis
Scheduling is a difficult problem.  Interested in trying out Google OR-Tools to see how it solves.
