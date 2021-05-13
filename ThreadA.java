package homework11.part2;

public class ThreadA implements Runnable {
    ThreadD storage;
    Thread t;

    ThreadA(ThreadD storage) {
        this.storage = storage;
        t = new Thread(this);
        t.start();
        System.out.println("Поток проверки делимости на 3 (\"A\") запустился");
    }

    @Override
    public void run() {
        while (storage.getNumber() <= storage.getTopValue()) {
            for (int i = 0; i < 5; i++) {
                storage.checkThreadQueueStatus(2);
            }
            fizz(storage.getNumber());
        }

        System.out.println("Поток A окончил работу");
    }

    void fizz(int number) {
        if (number % 3 == 0) {
            System.out.print("fizz ");
            storage.threadQStatus = 0;
        } else {
            storage.decreaseNumStatus();
        }
    }


}
