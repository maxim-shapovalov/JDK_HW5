import java.util.concurrent.Semaphore;


public class Philosopher extends Thread{
    private String name;
    private int forkLeftNumber;
    private Semaphore forkLeft;
    private int forkRightNumber;
    private Semaphore forkRight;
    private int eatCount = 0;

    public Philosopher(String name, int forkLeftNumber, Semaphore forkLeft, int forkRightNumber, Semaphore forkRight) {
        this.name = name;
        this.forkLeftNumber = forkLeftNumber;
        this.forkLeft = forkLeft;
        this.forkRightNumber = forkRightNumber;
        this.forkRight = forkRight;
    }

    @Override
    public void run() {
        int countEat = 3;
        while (countEat > 0) {
            try {
                if (forkLeft.tryAcquire()) {
                    if (forkRight.tryAcquire()) {
                        System.out.println(name + " взял вилки " + forkLeftNumber + " и " + forkRightNumber);
                        System.out.println(name + " поел");
                        eatCount++;
                        forkRight.release();
                        forkLeft.release();
                        System.out.println(name + " размышляет!");
                        countEat--;
                        Thread.sleep(1000); // Подумать между приемами пищи
                    } else {
                        forkLeft.release();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " поел " + eatCount + " раз");
    }
}
