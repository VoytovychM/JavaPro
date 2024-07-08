package summary20240607;

import java.util.List;
import java.util.concurrent.*;

public class TaskWithCallable {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();

        Task task1 = new Task(2, 300_000);
        Task task2 = new Task(300_000, 500_000);
        Task task3 = new Task(500_000, 650_000);
        Task task4 = new Task(650_000, 750_000);
        Task task5 = new Task(750_000, 850_000);
        Task task6 = new Task(850_000, 950_000);
        Task task7 = new Task(950_000, 1_000_000);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = executor.invokeAll(List.of(task1, task2, task3, task4, task5, task6, task7));
        int count = futures.stream().mapToInt(x -> {
            try {
                return x.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return 0;
            }}).sum();

        long end = System.currentTimeMillis();
        System.out.println("Total numbers of prime: " + count);
        System.out.println("Time " + (end - start) + ", ms");
        executor.shutdown();

    }
    static class Task implements Callable<Integer> {
        int start;
        int end;
        int primeCount;

        @Override
        public Integer call() {
            for (int i = start; i < end; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    primeCount++;
            }
            return primeCount;
        }

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
