package homework11.part2;

public class ThreadB implements Runnable {
    ThreadD storage;

    ThreadB(ThreadD storage) {
        this.storage = storage;
        new Thread(this).start();
        System.out.println("Поток проверки делимости на 5 (\"B\") запустился");
    }

    @Override
    public void run() {
        while (storage.getNumber() <= storage.getTopValue()) {
            for (int i = 0; i < 5; i++) {
                storage.checkThreadQueueStatus(3);
            }

            buzz(storage.getNumber());
        }

        System.out.println("Поток B окончил работу");
    }

    synchronized void buzz(int number) {
        if (number % 5 == 0) {
            System.out.print("buzz ");
            storage.threadQStatus = 0;
        } else {
            storage.decreaseNumStatus();
        }
    }
}
