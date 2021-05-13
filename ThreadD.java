package homework11.part2;

public class ThreadD implements Runnable {

    private int topValue;
    private volatile int currentNumber = 0;
    volatile int threadQStatus = 0;

    ThreadD(int topValue) {
        this.topValue = topValue;
        new Thread(this).start();
        System.out.println("Поток вывода чисел (\"D\") запустился");
    }

    @Override
    public void run() {

        while (currentNumber <= topValue) {
            if (threadQStatus == 0)
                increaseValue();
            else if (threadQStatus == 1) printNumber();
        }

        System.out.println("\nПоток D окончил работу");
    }

    synchronized void increaseValue() {
        currentNumber++;
        threadQStatus = 4;
        notifyAll();
    }

    synchronized void checkThreadQueueStatus(int thisThreadValue) {
        if (threadQStatus != thisThreadValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            notifyAll();
        }
    }

    synchronized void decreaseNumStatus() {
        threadQStatus--;
        notifyAll();
    }

    int getNumber() {
        return currentNumber;
    }

    int getTopValue() {
        return topValue;
    }

    synchronized void printNumber() {
        System.out.print(currentNumber + " ");
        decreaseNumStatus();
    }


}
