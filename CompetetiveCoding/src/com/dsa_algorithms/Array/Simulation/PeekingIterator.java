package com.dsa_algorithms.Array.Simulation;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Integer peekVal;
    Iterator<Integer> it;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        peekVal = null;
        it = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekVal == null){
            if (!it.hasNext())
                return -1;
            peekVal = it.next();
        }
        return peekVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer nextVal = peekVal;
        if (peekVal != null){
            peekVal = null;
            return nextVal;
        }
        if (it.hasNext())
            return it.next();

        return -1;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext() || peekVal != null;
    }
}
