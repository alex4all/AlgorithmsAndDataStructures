package edu.patterns.concurrency;

import java.util.concurrent.*;

public class ConcurrentCache<A, V> implements Task<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Task<A, V> task;

    public ConcurrentCache(Task<A, V> task) {
        this.task = task;
    }

    @Override
    public V execute(A input) throws InterruptedException {
        while (true) {
            Future<V> cached = cache.get(input);
            if (cached == null) {
                FutureTask<V> task = new FutureTask<>(() -> this.task.execute(input));
                cached = cache.putIfAbsent(input, task);
                if (cached == null) {
                    cached = task;
                    task.run();
                }
            }

            // wait for processing to complete if it is not and get the result
            try {
                return cached.get();
            } catch (CancellationException e) {
                cache.remove(input, cached);
            } catch (ExecutionException e) {
                throw new IllegalStateException("Not unchecked", e);
            }
        }
    }
}
