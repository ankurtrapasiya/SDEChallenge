package com.paytm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class MovingAverageDequeImplTest {

    private MovingAverageDeque<Integer> movingAverageDeque;

    @Test
    public void testAddNullElement() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new MovingAverageDequeImpl(3).addElement(null);
        });
    }

    @Test
    public void testGetMovingAverage() {
        int N = 3;
        Double movingAverage;
        movingAverageDeque = new MovingAverageDequeImpl(N);
        movingAverageDeque.addElement(1);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assertions.assertEquals(1.0d, movingAverage, 0.0);

        movingAverageDeque.addElement(10);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assertions.assertEquals(5.5, movingAverage, 0.0);

        movingAverageDeque.addElement(3);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assertions.assertEquals(4.666666666666667, movingAverage, 0.0);

        movingAverageDeque.addElement(5);
        movingAverage = movingAverageDeque.getMovingAverage();
        Assertions.assertEquals(6.0, movingAverage, 0.0);
    }

    @Test
    public void testGetAllElements() {
        movingAverageDeque = new MovingAverageDequeImpl(3);
        movingAverageDeque.addElement(1);
        movingAverageDeque.addElement(2);
        movingAverageDeque.addElement(3);
        movingAverageDeque.addElement(4);

        List<Integer> allElements = movingAverageDeque.getAllElements();
        List<Integer> expectedElements = new ArrayList<>();
        IntStream.range(0, 4)
                .forEach(index -> expectedElements.add(index + 1));

        Assertions.assertTrue(allElements.containsAll(expectedElements));
    }

    @Test
    public void testNegativeWindowSize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new MovingAverageDequeImpl(-1);
        });
    }
}