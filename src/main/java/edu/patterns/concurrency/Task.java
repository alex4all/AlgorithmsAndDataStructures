package edu.patterns.concurrency;

/**
 * Task takes input of specified type, process computation and returns output of specified type
 *
 * @param <A> task input type
 * @param <V> task output type
 */
public interface Task<A, V> {

    V execute(A input) throws InterruptedException;
}
