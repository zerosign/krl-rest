package org.zerosign.krl.rest.adt;

/**
 *
 * @author zerosign
 * @since 5 March 2014
 * @version 1.0
 */
public class ImmutablePair<T> {
    
    private final T first, second;
    
    public ImmutablePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
    
    
}
