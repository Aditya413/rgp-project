# Goal

Goal was to implement 3 feature.

1. Calculate the median value for a list of given temperatures.
2. Calculate the mean value for a list of given temperatures.
3. Calculate the mode value for a list of given temperatures.

# Approach

After analysing the problem statement and to achieve the desired goal, I decided to use "Strategy design pattern" which
help us to execute the different computation strategy during runtime. It has also helped me to isolate the business
logic of a class from the implementation details.

# Requirements

Currently, this application prints MEAN, MEDIAN and MODE of a provided hardcoded Temperature list. But, it is
implemented in such a way that if we are required to take the inputs from the user then it won't have any impact on our
business logic and can be easily achieved.