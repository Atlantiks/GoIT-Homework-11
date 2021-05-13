package homework11.part2;

public class ThreadC implements Runnable {
    ThreadD storage;

    ThreadC(ThreadD storage) {
        this.storage = storage;
        new Thread(this).start();
        System.out.println("Поток проверки делимости и на 3 и на 5 (\"C\") запустился");
    }

    @Override
    public void run() {
        while (storage.getNumber() <= storage.getTopValue()) {
            for (int i = 0; i < 5; i++) {
                storage.checkThreadQueueStatus(4);
            }

            fizzbuzz(storage.getNumber());
        }

        System.out.println("Поток С окончил работу");
    }

    void fizzbuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.print("fizzbuzz ");
            storage.threadQStatus = 0;
        } else {
            storage.decreaseNumStatus();
        }
    }
}
