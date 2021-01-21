# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.



##Coding Questions 

Moving Average Finding Data Structure
-> Implementation is based on Double Ended Queue(Deque)
-> Implementation is not thread safe
-> Space complexity is O(1)
-> Time complexity is O(WindowSize)

Explanation about implementation
-> We maintaing a running sum for window size N or less than that
-> When we receive an element, we recalculate the running sum. We check if with current number our window expands beyond N then we peek the element from head of the Queue, remove it from running
sum and add the received number to the WindowSum. Hence WindowSum remains for last N elements
-> While calculating the running average, we check if total elements are less than windowSize then we calculate average with that windowSize otherwise we calculate running average on N
-> Implementation is generic for any Wrapper class extending Number super class